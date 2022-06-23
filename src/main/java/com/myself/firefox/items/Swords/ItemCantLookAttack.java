package com.myself.firefox.items.Swords;

import com.myself.firefox.ModMain;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class ItemCantLookAttack extends ModSwordBase {
    public ItemCantLookAttack() {
        super(Tiers.GOLD, 10, -4F, new Item.Properties().tab(ModMain.TUTORIAL_TAB));
    }
}
