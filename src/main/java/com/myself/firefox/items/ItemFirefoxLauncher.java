package com.myself.firefox.items;

import java.util.function.Predicate;

import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityFirefoxBullet;
import com.myself.firefox.init.ItemInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

//火狐发射器：发射器类
public class ItemFirefoxLauncher extends ProjectileWeaponItem implements Vanishable{

    public ItemFirefoxLauncher() {
        super(new ItemFirefoxLauncher.Properties().tab(ModMain.TUTORIAL_TAB).stacksTo(1));
    }

    public ItemFirefoxLauncher(Item.Properties name) {
        super(name);
    }


    public void releaseUsing(ItemStack p_77615_1_, Level level, LivingEntity p_77615_3_, int p_77615_4_) {
        if (p_77615_3_ instanceof Player) { //如果使用者是玩家
            Player Player = (Player)p_77615_3_;
            boolean flag = Player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_77615_1_) > 0; //如果有指定附魔：无限
//            ItemStack itemstack = Player.getProjectile(p_77615_1_);

            //加buff 水下呼吸 必得
            //Player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200,1,true,true));
            //给自己防火效果
            //Player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 4, 0, true, true));

            ItemStack itemstack = this.findAmmo(Player);

            int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_, level, Player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) { //如果，物品不是空的
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ItemInit.FIREFOX_BULLET.get().asItem());
                }

                float f = getPowerForTime(i); //蓄力时间
                if (!((double)f < 0.1D)) {
                    boolean flag1 = Player.getAbilities().instabuild || (itemstack.getItem() instanceof ItemFirefoxBullet && ((ItemFirefoxBullet)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, Player));
                    if (!level.isClientSide) { //如果不在客户端执行
                        ItemFirefoxBullet arrowitem = (ItemFirefoxBullet)(itemstack.getItem() instanceof ItemFirefoxBullet ? itemstack.getItem() : ItemInit.FIREFOX_BULLET.get().asItem());
                        //这里指明我们之前的投掷物实体
                        EntityFirefoxBullet abstractarrowentity = arrowitem.createArrow(level, itemstack, Player);

                        abstractarrowentity = customArrow(abstractarrowentity);
                        //abstractarrowentity.setItem(itemstack);
                        abstractarrowentity.shootFromRotation(Player, Player.getXRot(), Player.getYRot(), 0.2F, f * 30.0F, 0.75F);


                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x , abstractarrowentity.position().y, abstractarrowentity.position().z); //添加粒子
                        abstractarrowentity.playSound( SoundEvents.ARROW_SHOOT, 2.5F,2.5F); //播放音效


                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) { //判断附魔是否存在
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        p_77615_1_.hurtAndBreak(1, Player, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(Player.getUsedItemHand());
                        });


                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE_POP, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.08D, abstractarrowentity.position().z * -0.2D); //添加粒子

                        level.addFreshEntity(abstractarrowentity);

                        //加buff 潮涌能量 右键后获得，即使未击中生物
                        //Player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 60,1,true,true));

                    }
                    //发射的声音
                    level.playSound((Player)null, Player.getX(), Player.getY(), Player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.4F, 1.4F / (Player.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !Player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            Player.getInventory().removeItem(itemstack);
                        }
                    }

                    Player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player palyerIn, InteractionHand handIn) {
        ItemStack itemstack = palyerIn.getItemInHand(handIn);
        boolean flag = !this.findAmmo(palyerIn).isEmpty();
//        boolean flag;
//        if (!(itemstack.getItem() instanceof ShootableItem)) {
//            flag=false;
//        }


        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, palyerIn, handIn, flag);
        if (ret != null) return ret;

        if (!palyerIn.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            palyerIn.startUsingItem(handIn);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public static float getPowerForTime(int p_185059_0_) {
        float f = (float)p_185059_0_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }


    //发射间隔
    public int getUseDuration(ItemStack p_77626_1_) {
        return 600; //600
    }


    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    public EntityFirefoxBullet customArrow(EntityFirefoxBullet arrow) {
        return arrow;
    }
    public int getDefaultProjectileRange() {
        return 11;
    }

    //判断我们是否有子弹
    protected ItemStack findAmmo(Player player)
    {
        if (this.isMoSpitter(player.getItemInHand(InteractionHand.OFF_HAND)))
        {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        }
        else if (this.isMoSpitter(player.getItemInHand(InteractionHand.MAIN_HAND)))
        {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i)
            {
                ItemStack itemstack = player.getInventory().getItem(i);

                if (this.isMoSpitter(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }
    //判断是不是这把枪的子弹
    protected boolean isMoSpitter(ItemStack stack)
    {
        return stack.getItem() instanceof ItemFirefoxBullet;
    }
}
