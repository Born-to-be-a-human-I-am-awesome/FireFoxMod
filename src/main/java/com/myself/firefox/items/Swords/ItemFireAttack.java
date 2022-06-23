package com.myself.firefox.items.Swords;

import com.myself.firefox.ModMain;

import com.myself.firefox.items.CustomItemTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

//我们要做一把剑，就继承原版的剑
public class ItemFireAttack extends SwordItem {
    public ItemFireAttack() {
        //各参数：工具等级，伤害，攻速，放在哪个物品栏
        super(CustomItemTier.PreciseAttack,10,-2F,new Item.Properties().tab(ModMain.TUTORIAL_TAB));
    }
}
