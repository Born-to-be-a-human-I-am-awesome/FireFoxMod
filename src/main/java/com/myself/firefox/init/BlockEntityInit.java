package com.myself.firefox.init;

import com.myself.firefox.ModMain;
import com.myself.firefox.blocks.virusgenerator.VirusGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//注册方块实体
public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ModMain.MOD_ID);

    public static final RegistryObject<BlockEntityType<VirusGeneratorBlockEntity>> VIRUS_GENERATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("virus_generator_block_entity", () ->
                    BlockEntityType.Builder.of(VirusGeneratorBlockEntity::new,
                            BlockInit.VIRUS_GENERATOR_BLOCK.get()).build(null));

    //    public static final RegistryObject<BlockEntityType<GeneratorBlockEntity>> GENERATOR_BLOCK_ENTITY =
//            BLOCK_ENTITIES.register("generator_block_entity", () ->
//                    BlockEntityType.Builder.of(GeneratorBlockEntity::new,
//                            BlockInit.GENERATOR_BLOCK.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
