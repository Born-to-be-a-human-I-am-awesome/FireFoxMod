package com.myself.firefox.items;

import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityFirefoxBullet;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


//火狐子弹：子弹类
public class ItemFirefoxBullet extends Item {
    public ItemFirefoxBullet(Item.Properties name) {
        super(name);
    }

    public ItemFirefoxBullet() {
        //放到哪个物品栏 每个槽最多放几个 默认：64
        super(new Properties().tab(ModMain.TUTORIAL_TAB).stacksTo(64));
    }

    public EntityFirefoxBullet createArrow(Level level, ItemStack stack, LivingEntity entityIn) {
        //指明我们生成的投掷物实体
        EntityFirefoxBullet arrowentity = new EntityFirefoxBullet(level, entityIn);
        return arrowentity;
    }
    //如果有无限的附魔，就不消耗子弹
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ItemFirefoxBullet.class;
    }
}
