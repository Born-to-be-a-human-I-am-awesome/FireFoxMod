package com.myself.firefox.entity.render;

import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityRe8Dimi;
import com.myself.firefox.entity.model.ModelRe8Dimi;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderRe8Dimi extends MobRenderer<EntityRe8Dimi, ModelRe8Dimi<EntityRe8Dimi>> {
    //注意这个路径，要和上面model文件中的路径保持一致
    public static final ResourceLocation TEXTURE = new ResourceLocation(ModMain.MOD_ID, "textures/entity/re8dimi.png");

    public RenderRe8Dimi(EntityRendererProvider.Context manager) {
        super(manager, new ModelRe8Dimi<>(manager.bakeLayer(ModelRe8Dimi.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityRe8Dimi p_110775_1_) {
        return TEXTURE;
    }
}
