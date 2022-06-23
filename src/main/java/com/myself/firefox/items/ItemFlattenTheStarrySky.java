package com.myself.firefox.items;

import com.myself.firefox.ModMain;
import com.myself.firefox.config.ModCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.List;

//踏平星空：物品类
public class ItemFlattenTheStarrySky extends Item {
    public ItemFlattenTheStarrySky() {
        super(new Item.Properties().tab(ModMain.TUTORIAL_TAB).defaultDurability(1));
    }

    public ItemFlattenTheStarrySky(Item.Properties name) {
        super(name);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        ItemStack itemstack = p_41433_.getItemInHand(p_41434_);

        //this.hurtEnemy(itemstack, p_41433_, p_41433_); //扣耐久，算法自原版 (这次就不造轮子了) (啊这，原版直接返回假了，还是得造轮子)
        //new ItemPortableFireCharge().hurtEnemy(itemstack, p_41433_); //好吧，我记得我写过，直接用就行了，不用造轮子了(
        this.hurtEnemy(itemstack, p_41433_); //绝了，上面的写法会崩，我终究还是逃不过造轮子 =_=)

        //判断是否该物品被禁用
        if (ModCommonConfig.DISABLE_ITEM__flatten_the_starry_sky.get() != 1)
        {
            //未被禁用

            //真·踏平星空（从当前玩家位置开启，循环遍历周围2048格正方形范围内的所有区块替换空气）
            for (int blockZ = 0; blockZ <= 100; blockZ++) { //Z坐标偏移量自增
                for (int blockX = 0; blockX <= 100; blockX++) { //X坐标偏移量自增
                    for (int blockY = -166; blockY <= 320; blockY++) { //Y坐标偏移量自增

                        if (p_41432_.getBlockState(p_41433_.getOnPos().offset(blockX - 50, blockY, blockZ - 50)) != Blocks.BEDROCK.defaultBlockState()) //不替换基岩，如遇到就跳过这些地方
                        {
                            if (p_41432_.getBlockState(p_41433_.getOnPos().offset(blockX - 50, blockY, blockZ - 50)) != Blocks.AIR.defaultBlockState())  //不填充空气部分，以节省性能
                            {
                                p_41432_.setBlock(p_41433_.getOnPos().offset(blockX - 50, blockY, blockZ - 50), Blocks.AIR.defaultBlockState(), 1, 1); //消除方块
                            }
                        }
                    }
                }
            }
        } else {
            //已被禁用
            //判断玩家防止出现两个聊天信息
            if (p_41433_ instanceof ServerPlayer serverPlayer)
            {
                serverPlayer.sendMessage(new TranslatableComponent("disable.the.item"), serverPlayer.getUUID());
            }
        }

        return super.use(p_41432_, p_41433_, p_41434_);
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

        //判断配置文件中该物品是否被禁用
        if (ModCommonConfig.DISABLE_ITEM__flatten_the_starry_sky.get() != 1)
        {
            //未被禁用
            p_41423_.add(new TranslatableComponent("item." + this.getRegistryName() + ".desc"));
        } else {
            //已被禁用
            p_41423_.add(new TranslatableComponent("item." + this.getRegistryName() + ".desc_1"));
        }
    }
}
