package com.myself.firefox.init;

import com.myself.firefox.ModMain;
import com.myself.firefox.blocks.virusgenerator.VirusGeneratorRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//GUI配方初始化类
public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModMain.MOD_ID);

    public static final RegistryObject<RecipeSerializer<VirusGeneratorRecipe>> VIRUS_GENERATOR_SERIALIZER =
            SERIALIZERS.register("virus_generator", () -> VirusGeneratorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
