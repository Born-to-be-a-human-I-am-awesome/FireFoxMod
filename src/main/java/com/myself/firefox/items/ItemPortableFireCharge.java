package com.myself.firefox.items;

import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityPortableFireCharge;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;


//便捷式火焰弹：物品类
public class ItemPortableFireCharge extends Item{
    public ItemPortableFireCharge() {
        super(new Item.Properties().tab(ModMain.TUTORIAL_TAB).defaultDurability(100));
    }

    public ItemPortableFireCharge(Item.Properties name) {
        super(name);
    }



    //右键使用事件
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_)
    {
        ItemStack itemstack = p_41433_.getItemInHand(p_41434_);
        //p_43142_.playSound((Player)null, p_43143_.getX(), p_43143_.getY(), p_43143_.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (p_43142_.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!p_41432_.isClientSide) { //如果不在客户端
            EntityPortableFireCharge p_404_1 = new EntityPortableFireCharge(p_41432_, p_41433_);
            p_404_1.setItem(itemstack);
            p_404_1.shootFromRotation(p_41433_, p_41433_.getXRot(), p_41433_.getYRot(), 0.0F, 1.5F, 1.0F); //发射实体
            p_41432_.addFreshEntity(p_404_1);
        }

        //使用后，当前数量-1
        //p_41433_.awardStat(Stats.ITEM_USED.get(this));
        //if (!p_41433_.getAbilities().instabuild) {
            //itemstack.shrink(1);
        //}

        //使用后扣一点耐久，算法来自原版.防止出现扣到负数还扣不烂的情况
        hurtEnemy(itemstack,p_41433_);

        return InteractionResultHolder.sidedSuccess(itemstack, p_41432_.isClientSide());

    }



    //发射间隔
    public int getUseDuration(ItemStack p_77626_1_) {
        return 1300; //1300
    }

    //扣耐久方法(造轮子.png)
    public boolean hurtEnemy(ItemStack p_43390_, LivingEntity p_43392_) {
        p_43390_.hurtAndBreak(1, p_43392_, (p_43414_) -> { //扣耐久逻辑，每次扣一点
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND); //损坏逻辑，目标为主手
        });
        return true;
    }



    //物品描述
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_)
    {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_); //作为该物品的属性
        p_41423_.add(new TranslatableComponent("item." + this.getRegistryName() + ".desc"));
    }
}
