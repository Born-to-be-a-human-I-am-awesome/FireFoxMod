package com.myself.firefox;

import com.myself.firefox.blocks.virusgenerator.VirusGeneratorRecipe;
import com.myself.firefox.entity.EntityDirtBallKing;
import com.myself.firefox.entity.EntityRe8Dimi;
import com.myself.firefox.entity.model.ModelDirtBallKing;
import com.myself.firefox.entity.model.ModelRe8Dimi;
import com.myself.firefox.entity.render.RenderDirtBallKing;
import com.myself.firefox.entity.render.RenderFirefoxBullet;
import com.myself.firefox.entity.render.RenderPortableFireCharge;
import com.myself.firefox.entity.render.RenderRe8Dimi;
import com.myself.firefox.init.EntityInit;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEventSubscriber {


    //将所有的生物的皮肤贴图信息写在这个函数里，有几个写几个
    //RE8DIMI
    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelRe8Dimi.LAYER_LOCATION, ModelRe8Dimi::createBodyLayer);
    }

    //DIRT_BALL_KING
    @SubscribeEvent
    public static void onRegisterLayers_1(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelDirtBallKing.LAYER_LOCATION, ModelDirtBallKing::createBodyLayer);
    }




    //将所有的生物的渲染信息写在这个函数里，有几个写几个
    //RE8DIMI
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.RE8DIMI.get(), RenderRe8Dimi::new);
    }

    //火狐子弹
    @SubscribeEvent
    public static void onRegisterRenderer_1(EntityRenderersEvent.RegisterRenderers event) {

        //添加我们的投掷物的渲染事件
        event.registerEntityRenderer(EntityInit.MOSPITTER.get(), RenderFirefoxBullet::new);

    }

    //土球王
    @SubscribeEvent
    public static void onRegisterRenderer_2(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.DIRT_BALL_KING.get(), RenderDirtBallKing::new);
    }

    //便捷式火焰弹
    @SubscribeEvent
    public static void onRegisterRenderer_3(EntityRenderersEvent.RegisterRenderers event) {

        //添加我们的投掷物的渲染事件
        event.registerEntityRenderer(EntityInit.ENTITY_PORTABLE_FIRE_CHARGE.get(), RenderPortableFireCharge::new);

    }




    //将所有的生物的属性信息写在这个函数里，有几个写几个
    //RE8DIMI
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityInit.RE8DIMI.get(), EntityRe8Dimi.prepareAttributes().build());
    }

    //DIRT_BALL_KING
    @SubscribeEvent
    public static void onAttributeCreate_1(EntityAttributeCreationEvent event) {
        event.put(EntityInit.DIRT_BALL_KING.get(), EntityDirtBallKing.prepareAttributes().build());
    }


    /**
     * GUI配方类型注册
     */
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, VirusGeneratorRecipe.Type.ID, VirusGeneratorRecipe.Type.INSTANCE);
    }



} // end class
