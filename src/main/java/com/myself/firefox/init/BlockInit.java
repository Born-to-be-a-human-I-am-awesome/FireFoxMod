package com.myself.firefox.init;

import java.util.function.Function;
import com.google.common.base.Supplier;
import com.myself.firefox.ModMain;
import com.myself.firefox.blocks.virusgenerator.VirusGeneratorBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.client.renderer.ItemBlockRenderTypes.canRenderInLayer;

@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockInit {
    //注册机
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            ModMain.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    //定义一个属于我们的方块
    public static final RegistryObject<Block> FIRE_BRICKS = register("fire_bricks", //烈焰砖
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(3.0f)
                    .sound(SoundType.METAL).requiresCorrectToolForDrops()),
            //添加到自定义创造模式分页签中
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModMain.TUTORIAL_TAB)));


    public static final RegistryObject<Block> FIRING_BRICKS = register("firing_bricks", //烧制砖块
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(3.1f)
                    .sound(SoundType.METAL).requiresCorrectToolForDrops()),
            //添加到自定义创造模式分页签中
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModMain.TUTORIAL_TAB)));


    public static final RegistryObject<Block> TRANSPARENT_FORBIDDEN_ROOM_WALL = register("transparent_forbidden_room_wall", //透明禁言室墙壁
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(-1f) //无法挖掘
                    .sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion().isValidSpawn(BlockInit::never).isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)),
            //添加到自定义创造模式分页签中
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModMain.TUTORIAL_TAB)));


    /**
     * 我们的机器方块
     * @param event
     */
    public static final RegistryObject<Block> VIRUS_GENERATOR_BLOCK = register("virus_generator",
            () -> new VirusGeneratorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModMain.TUTORIAL_TAB)));



    //设置透明  不可被活塞推动 .noOcclusion().isValidSpawn(BlockInit::never).isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)
    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.TRANSPARENT_FORBIDDEN_ROOM_WALL.get(), RenderType.cutout());
    }


    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        //不是有效重生点（在上面的床会显示重生点已丢失）
        return (boolean)false;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block, CreativeModeTab tutorialTab) {
        return BLOCKS.register(name, block);
    }


    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block, ModMain.TUTORIAL_TAB);
        //注册方块对应的ItemBlock，没有这一句的话只能指令填充并且挖掘无法掉落其本身
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
