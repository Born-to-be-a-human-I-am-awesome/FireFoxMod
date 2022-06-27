package com.myself.firefox.init;

import com.myself.firefox.ModMain;
import com.myself.firefox.effects.EffectWaterIntoxication;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ModMain.MOD_ID);



//    public static RegistryObject<MobEffect> DEADLY = EFFECTS.register("deadly",()->
//    {
//        return new EffectDeadly(MobEffectCategory.HARMFUL, 0x333333, false);
//    });

    //我们的效果类
    public static RegistryObject<MobEffect> WATER_INTOXICATION = EFFECTS.register("water_intoxication",()->
    {
        //这个效果生效时，就将玩家的速度降低25%
        return new EffectWaterIntoxication(MobEffectCategory.HARMFUL, 0x000033, false)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                        "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    });

}
