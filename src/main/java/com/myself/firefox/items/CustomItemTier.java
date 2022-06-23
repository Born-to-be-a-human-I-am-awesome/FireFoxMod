package com.myself.firefox.items;

import java.util.function.Supplier;

import com.myself.firefox.init.ItemInit;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

//工具质地类
public enum CustomItemTier implements Tier {

    //这是我们的自定义的工具等级，可以往下续写...
    exampleToolTire(10, 120, 8.0F, 10.0F, 100,() -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    PreciseAttack(3, 2, 8.0F, 10.0F, 100,() -> {
        return Ingredient.of(Items.DIAMOND);
    }),


    //土球球质地 4z:草？？
    texture_4z(5,3,8.0F,5.0F,850,() -> {
        return Ingredient.of(ItemInit.DIRT_BALL.get());
    });


    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private CustomItemTier(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
        this.level = p_43332_;
        this.uses = p_43333_;
        this.speed = p_43334_;
        this.damage = p_43335_;
        this.enchantmentValue = p_43336_;
        this.repairIngredient = new LazyLoadedValue<>(p_43337_);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

//	   @javax.annotation.Nullable public net.minecraft.tags.Tag<net.minecraft.world.level.block.Block> getTag() { return net.minecraftforge.common.ForgeHooks.getTagFromVanillaTier(this); }
}
