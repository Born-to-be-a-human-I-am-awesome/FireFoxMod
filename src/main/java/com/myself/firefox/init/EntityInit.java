package com.myself.firefox.init;


import com.myself.firefox.ModMain;
import com.myself.firefox.entity.EntityDirtBallKing;
import com.myself.firefox.entity.EntityFirefoxBullet;
import com.myself.firefox.entity.EntityPortableFireCharge;
import com.myself.firefox.entity.EntityRe8Dimi;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            ModMain.MOD_ID);

    //我们的生物类型为MONSTER(怪物)，你可以定义其他类型MOB等，两个字符串要一样比如"re8dimi"
    public static final RegistryObject<EntityType<EntityRe8Dimi>> RE8DIMI = ENTITY_TYPES.register("re8dimi",
            () -> EntityType.Builder.of(EntityRe8Dimi::new, MobCategory.MONSTER).sized(0.8f,3.0f).setTrackingRange(30)
                    .build(new ResourceLocation(ModMain.MOD_ID, "re8dimi").toString()));

    //dirt_ball_king 土球王
    public static final RegistryObject<EntityType<EntityDirtBallKing>> DIRT_BALL_KING = ENTITY_TYPES.register("dirt_ball_king",
            () -> EntityType.Builder.of(EntityDirtBallKing::new, MobCategory.MONSTER).sized(0.8f,3.0f).setTrackingRange(30)
                    .build(new ResourceLocation(ModMain.MOD_ID, "dirt_ball_king").toString()));


    //注册投掷物【实体】
    //火狐子弹
    public static final RegistryObject<EntityType<EntityFirefoxBullet>> MOSPITTER = ENTITY_TYPES.register("re8dimi_touzhi",()->{
        return EntityType.Builder.of((EntityType<EntityFirefoxBullet> entityType, Level level)->{
            return new EntityFirefoxBullet(entityType,level);
        }, MobCategory.MISC).sized(1F,1F).build("re8dimi_touzhi");
    });

    //便捷式烈焰弹
    public static final RegistryObject<EntityType<EntityPortableFireCharge>> ENTITY_PORTABLE_FIRE_CHARGE = ENTITY_TYPES.register("entity_portable_fire_charge",()->{
        return EntityType.Builder.of((EntityType<EntityPortableFireCharge> entityType, Level level)->{
            return new EntityPortableFireCharge(entityType,level);
        }, MobCategory.MISC).sized(1F,1F).build("entity_portable_fire_charge");
    });

    //你可以往下续写
}
