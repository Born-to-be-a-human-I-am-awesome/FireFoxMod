package com.myself.firefox.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    //这些参数都是我们所需要的配置参数
    public static final ForgeConfigSpec.ConfigValue<Integer> DISABLE_ITEM__flatten_the_starry_sky;

    //public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Moroaicas;

    //public static final ForgeConfigSpec.ConfigValue<Integer> CITRINE_ORE_VEIN_SIZE;



    static {
        BUILDER.push("Configs for Resident Firefox Mod");

        //comment: 参数解释，define：参数定义 后跟一个值
        //禁用：踏平星空
        DISABLE_ITEM__flatten_the_starry_sky = BUILDER.comment("Disabled at 1, the player will not be able to use this item")
                .define("Forbidden items: Leveling the stars", 0);


        //SPAWN_Moroaicas = BUILDER.comment("Spawn Moroaicas,Hauler,Soldat Eins")
                //.define("entity.moroaicas.spawnrate", 13);


        //comment: 参数解释，define：参数定义 后跟三个值，第一个是可变值，第二个是最小值，第三是最大值
        //CITRINE_ORE_VEIN_SIZE = BUILDER.comment("How many Citrine Ore Blocks spawn in one Vein!")
                //.defineInRange("Vein Size", 9, 4, 20);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
