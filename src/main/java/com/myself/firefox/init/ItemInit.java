package com.myself.firefox.init;

import com.google.common.base.Supplier;
import com.myself.firefox.ModMain;
//import com.myself.firefox.ModMain.ItemPreAttack;

import com.myself.firefox.items.*;
import com.myself.firefox.items.Swords.ItemCantLookAttack;
import com.myself.firefox.items.Swords.ItemFireAttack;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    //注册机
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            ModMain.MOD_ID);



    /**
     * 特殊物品的注册
     */
    //我们的投掷物品声明：火狐子弹
    public static RegistryObject<Item> FIREFOX_BULLET = ITEMS.register("firefox_bullet",()->
    {
        return new ItemFirefoxBullet();
    });

    //枪物品的注册：火狐发射器
    public static RegistryObject<Item> FIREFOX_LAUNCHER = ITEMS.register("firefox_launcher",()->
    {
        return new ItemFirefoxLauncher();
    });

    //便捷式火焰弹
    public static RegistryObject<Item> PORTABLE_FIRE_CHARGE = register("portable_fire_charge", () ->
    {
        //原写法：new Item(new Item.Properties().tab(ModMain.TUTORIAL_TAB).defaultDurability(100)));
        return new ItemPortableFireCharge();
    });

    //踏平星空
    public static RegistryObject<Item> FLATTEN_THE_STARRY_SKY = register("flatten_the_starry_sky", () ->
    {
        return new ItemFlattenTheStarrySky();
    });



    /**
     * 刷怪蛋注册
     */
    //刷怪蛋格式:ForgeSpawnEggItem(生物类,颜色1,颜色2,放在哪个物品栏)
    //RE8DIMI
    //public static final RegistryObject<Item> THIEF_EGG = ITEMS.register("re8dimi_spawn_egg",
            //() -> new ForgeSpawnEggItem(EntityInit.RE8DIMI, 9577503, 13423070, new Item.Properties().tab(ModMain.TUTORIAL_TAB)));

    //DIRT_BALL_KING
    public static final RegistryObject<Item> DIRT_BALL_KING_EGG = ITEMS.register("dirt_ball_king_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DIRT_BALL_KING, 9577503, 13423070, new Item.Properties().tab(ModMain.TUTORIAL_TAB)));


    /**
     * 剑类注册
     */
    //注册剑：火剑
    public static RegistryObject<Item> FIRE_ATTACK = register("fire_attack",()->
    {
        return new ItemFireAttack();
    });

    //注册剑：看不剑
    public static RegistryObject<Item> CANT_LOOK_ATTACK = register("cant_look_attack",()->
    {
        return new ItemCantLookAttack();
    });


    /**
     * 普通空白物品注册
     */
    //定义一个属于我们自己的物品
    //public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
            //() -> new Item(new Item.Properties().tab(ModMain.TUTORIAL_TAB)));

    //土球
    public static final RegistryObject<Item> DIRT_BALL = register("dirt_ball",
            () -> new Item(new Item.Properties().tab(ModMain.TUTORIAL_TAB)));




    /**
     * 食物注册
     */
    //tab(放到哪个物品栏中)，nutrition(i) 回复i点饥饿度，saturationMod(j)饱腹度为j点， //铁质盔甲
    public static final RegistryObject<Item> IRON_CHESTPLATE = ITEMS.register("iron_chestplate_food",
            () -> new Item(new Item.Properties().tab(ModMain.TUTORIAL_TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(2.5F).
                    alwaysEat().alwaysEat().build())));

    //tab(放到哪个物品栏中)，nutrition(i) 回复i点饥饿度，saturationMod(j)饱腹度为j点， //生瓜蛋子
    public static final RegistryObject<Item> RAW_MELON_AND_EGG = ITEMS.register("raw_melon_and_egg",
            () -> new Item(new Item.Properties().tab(ModMain.TUTORIAL_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).
                    alwaysEat().alwaysEat().build())));



    //物品定义的注册
    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
