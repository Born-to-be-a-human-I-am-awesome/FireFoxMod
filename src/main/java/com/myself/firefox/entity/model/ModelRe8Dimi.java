package com.myself.firefox.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityRe8Dimi;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ModelRe8Dimi <T extends EntityRe8Dimi> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    //注意这个皮肤路径
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ModMain.MOD_ID, "re8dimi"), "main");
    private final ModelPart Head;
    private final ModelPart Body;
    private final ModelPart RightArm;
    private final ModelPart LeftArm;
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;

    public ModelRe8Dimi(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4444F, -23.0556F, -3.3889F, -0.1047F, 0.0F, 0.0F));

        PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(62, 33).addBox(-4.0F, -9.9993F, -6.9476F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(51, 0).addBox(-7.0F, -7.9993F, -6.9476F, 14.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(75, 43).addBox(-3.0F, -4.9993F, -10.9476F, 13.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(87, 0).addBox(-12.0F, -4.9993F, -10.9476F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 77).addBox(-13.0F, -4.9993F, -10.9476F, 1.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(68, 66).addBox(9.0F, -5.9993F, -9.9476F, 3.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-12.0F, -5.9993F, -9.9476F, 21.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(32, 80).addBox(-4.0F, -5.9993F, -6.9476F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4444F, 3.0556F, 5.3889F, 0.1309F, 0.0F, 0.0F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(56, 12).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(46, 65).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 60).addBox(-6.0F, -3.0F, -7.0F, 12.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(86, 33).addBox(-6.0F, -1.0F, 4.0F, 12.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(44, 46).addBox(-8.0F, 2.0F, -7.0F, 16.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 39).addBox(-8.0F, -9.0F, -8.0F, 16.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

        PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -4.0F, -9.0F, 18.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, -0.0436F, 0.0F));

        PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(88, 65).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -0.5F, 0.0F, 0.0436F, 0.0F));

        PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(64, 81).addBox(-5.0F, -0.5F, -4.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.5654F, -6.5679F, 1.0036F, 0.0F, 0.0F));

        PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -10.0F, -1.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(90, 46).addBox(-3.9816F, -2.2586F, -3.0789F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.759F, -0.7541F, 0.0436F, -0.1745F, 1.4399F));

        PartDefinition Rightbacktlib = RightArm.addOrReplaceChild("Rightbacktlib", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition RightArm_r2 = Rightbacktlib.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 94).addBox(-5.0F, -6.9981F, -5.0872F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.644F, 3.0686F, 0.1745F, 0.0F, 0.0F));

        PartDefinition Rightfrontlib = Rightbacktlib.addOrReplaceChild("Rightfrontlib", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition RightArm_r3 = Rightfrontlib.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(0, 38).addBox(-0.1511F, -7.7229F, -1.5045F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0422F, 18.6266F, -6.0745F, -0.3054F, 0.0436F, 0.0873F));

        PartDefinition RightArm_r4 = Rightfrontlib.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(6, 38).addBox(-1.1702F, 4.3202F, -1.0721F, 0.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 0).addBox(-2.1702F, 3.3202F, -1.0721F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(51, 3).addBox(-2.1702F, 3.3202F, -2.0721F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8017F, -1.1584F, -0.3491F, 0.0F, 0.0873F));

        PartDefinition RightArm_r5 = Rightfrontlib.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(4, 39).addBox(0.8391F, -3.262F, -0.014F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(9, 49).addBox(0.8391F, -3.262F, -0.014F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0774F, 11.6115F, -4.6201F, -0.6545F, 0.0F, -0.1745F));

        PartDefinition RightArm_r6 = Rightfrontlib.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(2, 39).addBox(-0.1609F, -0.9749F, 0.5562F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0774F, 11.6115F, -2.6201F, -0.3491F, 0.0F, -0.1745F));

        PartDefinition RightArm_r7 = Rightfrontlib.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(51, 0).addBox(-0.1609F, -2.6589F, 1.4355F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0774F, 11.6115F, -4.6201F, -0.3491F, 0.0F, -0.1745F));

        PartDefinition RightArm_r8 = Rightfrontlib.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(0, 77).addBox(-2.0F, -6.6868F, -3.0746F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8017F, -1.1584F, -0.3491F, 0.0F, 0.0F));

        PartDefinition nail = Rightfrontlib.addOrReplaceChild("nail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3274F, 14.8615F, -4.6201F, -0.0436F, 0.0F, 0.0F));

        PartDefinition Rightnail_r1 = nail.addOrReplaceChild("Rightnail_r1", CubeListBuilder.create().texOffs(8, 38).addBox(-0.1281F, -0.5693F, -1.6828F, 0.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.25F, 0.0F, -0.1745F, -0.6109F, -0.4363F));

        PartDefinition RightArm_r9 = nail.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(51, 10).addBox(0.3164F, -2.4682F, -1.5852F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.25F, 0.0F, -0.3491F, 0.0F, -0.4363F));

        PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(8.4442F, -8.8343F, -0.4302F, 0.2094F, 0.0F, 0.0F));

        PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(88, 85).addBox(-0.0164F, -3.2557F, -2.0027F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5558F, -3.3343F, -0.4302F, 0.0436F, -0.2182F, -1.4399F));

        PartDefinition Leftlib = LeftArm.addOrReplaceChild("Leftlib", CubeListBuilder.create(), PartPose.offset(0.5558F, 2.5308F, -0.3245F));

        PartDefinition LeftArm_r2 = Leftlib.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(17, 77).addBox(-2.0F, -5.4988F, -1.9302F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition LeftArm_r3 = Leftlib.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(16, 94).addBox(-1.0F, -9.076F, -3.2313F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0829F, -5.6691F, -0.8727F, 0.0F, 0.0F));

        PartDefinition Leftfrontlib = Leftlib.addOrReplaceChild("Leftfrontlib", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -2.0F));

        PartDefinition LeftArm_r4 = Leftfrontlib.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -9.076F, -3.2313F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0829F, -3.6691F, -0.8727F, 0.0F, 0.0F));

        PartDefinition LeftArm_r5 = Leftfrontlib.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(45, 46).addBox(0.4117F, 1.9822F, -3.162F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3084F, 2.5147F, -3.6691F, -0.8727F, 0.0F, 0.3054F));

        PartDefinition LeftArm_r6 = Leftfrontlib.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(45, 39).addBox(-1.0F, 2.0373F, -1.364F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0829F, -3.6691F, -0.9599F, 0.0F, 0.0F));

        PartDefinition LeftArm_r7 = Leftfrontlib.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.6472F, -6.2955F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0829F, -3.6691F, -0.8727F, 0.0F, 0.0F));

        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.192F, 0.0F, 0.0349F));

        PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(64, 91).addBox(-3.9698F, -6.9878F, -1.7911F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 5.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));

        PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(91, 6).addBox(-0.0302F, -8.9988F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 7.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.yRot = netHeadYaw * 0.007453292F;
        this.Head.xRot = headPitch * 0.007453292F;
//		this.beak.xRot = this.head.xRot;
//		this.beak.yRot = this.head.yRot;
//		this.redThing.xRot = this.head.xRot;
//		this.redThing.yRot = this.head.yRot;
//		this.body.xRot = ((float)Math.PI / 2F);
        this.LeftArm.xRot = Mth.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
        this.RightArm.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;
        this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 1.4F * limbSwingAmount;
        this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }

    public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
        ModelPart.xRot = x;
        ModelPart.yRot= y;
        ModelPart.zRot = z;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Head.render(poseStack, buffer, packedLight, packedOverlay);
        Body.render(poseStack, buffer, packedLight, packedOverlay);
        RightArm.render(poseStack, buffer, packedLight, packedOverlay);
        LeftArm.render(poseStack, buffer, packedLight, packedOverlay);
        RightLeg.render(poseStack, buffer, packedLight, packedOverlay);
        LeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
