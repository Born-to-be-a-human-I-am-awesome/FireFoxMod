package com.myself.firefox.init;

import com.myself.firefox.ModMain;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionInit {
    //将我们的维度在这里声明我们的维度名称
    //火世界
    public static final ResourceKey<Level> FIRE_WORLD_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(ModMain.MOD_ID, "fire_world"));
    public static final ResourceKey<DimensionType> RE8_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, FIRE_WORLD_KEY.getRegistryName());


    public static void register() {
        System.out.println("Registering Resident Evil 8 Dimensions for " + ModMain.MOD_ID);
    }
}
