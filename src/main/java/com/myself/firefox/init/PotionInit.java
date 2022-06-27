package com.myself.firefox.init;

import com.myself.firefox.ModMain;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionInit {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ModMain.MOD_ID);

    //第一个参数是我们药水的名字 后面跟上我们上期的药水
    public static final RegistryObject<Potion> BLINDNESS_POTION = POTIONS.register("blindness_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS.delegate.get(), 200, 0)));

    //深湖药水
    public static final RegistryObject<Potion> DEEP_LAKE_POTION = POTIONS.register("deep_lake_potion",
            () -> new Potion(new MobEffectInstance(EffectInit.WATER_INTOXICATION.get(), 1234, 0)));



    //public static final RegistryObject<Potion> DEADLY_POTION = POTIONS.register("deadly_potion",
    //	    () -> new Potion(new MobEffectInstance(EffectInit.DEADLY.get(), 200, 0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
