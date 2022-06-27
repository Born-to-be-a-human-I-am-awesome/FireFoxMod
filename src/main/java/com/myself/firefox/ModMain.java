package com.myself.firefox;

import com.mojang.logging.LogUtils;
import com.myself.firefox.config.ModCommonConfig;
import com.myself.firefox.init.*;
import com.myself.firefox.screen.VirusGeneratorScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLanguageProvider;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("firefox")
public class ModMain
{
    // Directly reference a slf4j logger
    public static final String MOD_ID = "firefox"; //定义模组唯一标识符

    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab(MOD_ID) { //新的创造模式分页签
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            //设置显示图标
            return new ItemStack(ItemInit.PORTABLE_FIRE_CHARGE.get());
        }
    };

    private static final Logger LOGGER = LogUtils.getLogger();

    public ModMain()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        //注册clientSetup
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);


        //注册定义类
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //添加物品，方块的初始化信息
        //物品
        ItemInit.ITEMS.register(bus);
        //方块
        BlockInit.BLOCKS.register(bus);
        //放在一起注册它们进MC
        MinecraftForge.EVENT_BUS.register(this);

        //添加这个，注册音频初始化
        SoundInit.SOUNDS.register(bus);

        //把生物初始化语句加入
        EntityInit.ENTITY_TYPES.register(bus);

        //添加药水初始化注册事件
        PotionInit.POTIONS.register(bus);

        //配置文件初始化
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfig.SPEC, "firefox_mod-modify.toml");

        //添加这个 注册维度生成器
        DimensionInit.register();

        //添加这个 注册方块实体类
        BlockEntityInit.register(bus);

        //添加这个 注册GUI初始化类
        MenuInit.register(bus);

        //添加这个 注册GUI配方类
        RecipeInit.register(bus);

        //添加效果类的注册事件
        EffectInit.EFFECTS.register(bus);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        LOGGER.info("火狐模组：下面就要加载模组了，给大家整个活？");
        LOGGER.warn("好耶！");

        for (int times = 0; times<=30; times++)
        {
            LOGGER.warn(String.valueOf(times));
        }

        LOGGER.warn("火狐模组：希望我不会被打.java");

        //TODO
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        //将screen时间进行注册
        //EntityRenderers.register(EntityInit.DUND1.get(), RenderDund::new);
        //ItemBlockRenderTypes.setRenderLayer(BlockInit.EBONY_LEAVES.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(BlockInit.HERB_BLOCK.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(BlockInit.EBONY_SAPLING.get(), RenderType.cutout());

        //添加这个，第一个参数机器方块的GUI，后面是这个机器方块的screen
        MenuScreens.register(MenuInit.VIRUS_GENERATOR_MENU.get(), VirusGeneratorScreen::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("firefox", "helloworld", () -> { LOGGER.info("Hello world from the MDK "); LOGGER.warn("试图往日志里面打印东西.png\n"); return "Hello world";});

        LOGGER.warn("Font Name: Alpha");
        LOGGER.warn("\n" +
                "          _____                    _____                    _____                    _____                    _____                   _______                                 \n" +
                "         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                 /::\\    \\                ______          \n" +
                "        /::\\    \\                /::\\    \\                /::\\    \\                /::\\    \\                /::\\    \\               /::::\\    \\              |::|   |         \n" +
                "       /::::\\    \\               \\:::\\    \\              /::::\\    \\              /::::\\    \\              /::::\\    \\             /::::::\\    \\             |::|   |         \n" +
                "      /::::::\\    \\               \\:::\\    \\            /::::::\\    \\            /::::::\\    \\            /::::::\\    \\           /::::::::\\    \\            |::|   |         \n" +
                "     /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\         /:::/~~\\:::\\    \\           |::|   |         \n" +
                "    /:::/__\\:::\\    \\               \\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\       /:::/    \\:::\\    \\          |::|   |         \n" +
                "   /::::\\   \\:::\\    \\              /::::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\     /:::/    / \\:::\\    \\         |::|   |         \n" +
                "  /::::::\\   \\:::\\    \\    ____    /::::::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\   /:::/____/   \\:::\\____\\        |::|   |         \n" +
                " /:::/\\:::\\   \\:::\\    \\  /\\   \\  /:::/\\:::\\    \\  /:::/\\:::\\   \\:::\\____\\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\ |:::|    |     |:::|    | ______|::|___|___ ____ \n" +
                "/:::/  \\:::\\   \\:::\\____\\/::\\   \\/:::/  \\:::\\____\\/:::/  \\:::\\   \\:::|    |/:::/__\\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\|:::|____|     |:::|    ||:::::::::::::::::|    |\n" +
                "\\::/    \\:::\\   \\::/    /\\:::\\  /:::/    \\::/    /\\::/   |::::\\  /:::|____|\\:::\\   \\:::\\   \\::/    /\\::/    \\:::\\   \\::/    / \\:::\\    \\   /:::/    / |:::::::::::::::::|____|\n" +
                " \\/____/ \\:::\\   \\/____/  \\:::\\/:::/    / \\/____/  \\/____|:::::\\/:::/    /  \\:::\\   \\:::\\   \\/____/  \\/____/ \\:::\\   \\/____/   \\:::\\    \\ /:::/    /   ~~~~~~|::|~~~|~~~      \n" +
                "          \\:::\\    \\       \\::::::/    /                 |:::::::::/    /    \\:::\\   \\:::\\    \\               \\:::\\    \\        \\:::\\    /:::/    /          |::|   |         \n" +
                "           \\:::\\____\\       \\::::/____/                  |::|\\::::/    /      \\:::\\   \\:::\\____\\               \\:::\\____\\        \\:::\\__/:::/    /           |::|   |         \n" +
                "            \\::/    /        \\:::\\    \\                  |::| \\::/____/        \\:::\\   \\::/    /                \\::/    /         \\::::::::/    /            |::|   |         \n" +
                "             \\/____/          \\:::\\    \\                 |::|  ~|               \\:::\\   \\/____/                  \\/____/           \\::::::/    /             |::|   |         \n" +
                "                               \\:::\\    \\                |::|   |                \\:::\\    \\                                         \\::::/    /              |::|   |         \n" +
                "                                \\:::\\____\\               \\::|   |                 \\:::\\____\\                                         \\::/____/               |::|   |         \n" +
                "                                 \\::/    /                \\:|   |                  \\::/    /                                          ~~                     |::|___|         \n" +
                "                                  \\/____/                  \\|___|                   \\/____/                                                                   ~~              \n" +
                "                                                                                                                                                                              \n");
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
        LOGGER.info("你是不是开服了？ 观望.png");
        LOGGER.info("即使是服务端，我也不能放弃整活！");

        for (int times = 0; times<=30; times++)
        {
            LOGGER.warn(String.valueOf(times));
        }

        LOGGER.info("要有整活的动力，欧耶");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            //LOGGER.info("HELLO from Register Block");
            LOGGER.info("火狐模组：方块注册完成！");
            LOGGER.warn("方块：我好看吗？导播\n");

            LOGGER.warn("Font Name: Roman");
            LOGGER.warn("\n" +
                    "      .o     .oooo.         .o               ooo        ooooo   .oooooo.   oooooooooo.   \n" +
                    "    .d88    d8P'`Y8b      .d88               `88.       .888'  d8P'  `Y8b  `888'   `Y8b  \n" +
                    "  .d'888   888    888   .d'888                888b     d'888  888      888  888      888 \n" +
                    ".d'  888   888    888 .d'  888                8 Y88. .P  888  888      888  888      888 \n" +
                    "88ooo888oo 888    888 88ooo888oo              8  `888'   888  888      888  888      888 \n" +
                    "     888   `88b  d88'      888                8    Y     888  `88b    d88'  888     d88' \n" +
                    "    o888o   `Y8bd8P'      o888o  ooooooooooo o8o        o888o  `Y8bood8P'  o888bood8P'   \n" +
                    "                                                                                         \n" +
                    "                                                                                         \n" +
                    "                                                                                         \n");






        }
    }
}
