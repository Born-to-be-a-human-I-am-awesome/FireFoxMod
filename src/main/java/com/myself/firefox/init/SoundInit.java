package com.myself.firefox.init;

import net.minecraftforge.registries.RegistryObject;

import com.myself.firefox.ModMain;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModMain.MOD_ID);
    //这个路径与第二步"name"字段对应, 为开头的声音事件名
    public static final RegistryObject<SoundEvent> FLICK = build("flick");
    //public static final RegistryObject<SoundEvent> ENTITY_DIMI_AMBIENT2 = build("entity.dimi.ambient2");
    //public static final RegistryObject<SoundEvent> ENTITY_DIMI_HURT1 = build("entity.dimi.hurt1");
    //public static final RegistryObject<SoundEvent> ENTITY_DIMI_HURT2 = build("entity.dimi.hurt2");
    //public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH1 = build("entity.dimi.death1");
    //public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH2 = build("entity.dimi.death2");
    //...

    private static RegistryObject<SoundEvent> build(String id)
    {
        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(ModMain.MOD_ID, id)));
    }
}
