package com.myself.firefox.entity.render;

import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityDirtBallKing;
import com.myself.firefox.entity.model.ModelDirtBallKing;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderDirtBallKing extends MobRenderer<EntityDirtBallKing, ModelDirtBallKing<EntityDirtBallKing>> {
    //注意这个路径，要和上面model文件中的路径保持一致
    public static final ResourceLocation TEXTURE = new ResourceLocation(ModMain.MOD_ID, "textures/entity/dirt_ball_king.png");

    public RenderDirtBallKing(EntityRendererProvider.Context manager) {
        super(manager, new ModelDirtBallKing<>(manager.bakeLayer(ModelDirtBallKing.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDirtBallKing p_110775_1_) {
        return TEXTURE;
    }
}
