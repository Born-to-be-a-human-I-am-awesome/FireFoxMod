package com.myself.firefox.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

public class EntityRe8Dimi extends Ravager {
    //boss血条信息
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityRe8Dimi.class, EntityDataSerializers.INT);
    //我们的boss不攻击类型为不死亡灵类的生物(凋零骷髅一类)
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
    };

    public EntityRe8Dimi(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }
    //是否怕阳光
    protected boolean isSunSensitive() {
        return true;
    }

    public void aiStep() {


        super.aiStep();
    }
    //设置生物属性(最大血量、移动速度、攻击力、护甲值等)
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 120.0D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 8.0D).
                add(Attributes.ARMOR_TOUGHNESS, 10.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }
    //给生物设置攻击行为
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.addBehaviourGoals();
    }
    //给生物添加其行为
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    //生物攻击其他生物
    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            //如果攻击的对象是生物，就给这个对象一个凋零效果，持续1s(20ticks=1s)
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WITHER, 20,0,true,true));
            }
            return true;
        }
    }

    //生物死亡音效
    @Override
    protected SoundEvent getDeathSound() {
//        Random ran = new Random();
//        int co = ran.nextInt(3);
//        if(co==0)
//        {
//            return SoundInit.ENTITY_DIMI_DEATH1.get();
//        }
//        else if(co==1) return SoundInit.ENTITY_DIMI_DEATH2.get();
        return SoundEvents.BEE_DEATH;
    }
    // 生物在玩家身边的音效
    protected SoundEvent getAmbientSound() {
//        Random ran = new Random();
//        int co = ran.nextInt(2);
//        if(co==0)
//        {
//            return SoundInit.ENTITY_DIMI_AMBIENT1.get();
//        }
//        return  SoundInit.ENTITY_DIMI_AMBIENT2.get();
        return SoundEvents.ZOMBIE_AMBIENT;
    }
//    生物受伤音效
//    @Override
//    protected SoundEvent getHurtSound(DamageSource source) {
//        Random ran = new Random();
//        int co = ran.nextInt(2);
//        if(co==0)
//        {
//            return SoundInit.ENTITY_DIMI_HURT1.get();
//        }
//        return SoundInit.ENTITY_DIMI_HURT2.get();
//    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 3F;
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        this.entityData.set(DATA_ID_INV, p_82215_1_);
    }

    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }

    }

    public void setCustomName(@Nullable Component p_200203_1_) {
        super.setCustomName(p_200203_1_);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        if(this.isSunSensitive()){
            this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*10,1,true,true));
        }

        Random ran = new Random();
        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 60.0F && this.getHealth()<=65.0F)
        {
            for(int i=0;i<4;i++)
                this.heal(1.5F*ran.nextFloat());
        }

//        if(this.getHealth() >= 0.1F && this.getHealth()<=10.0F)
//        {
//            this.convertTo(EntityDimi2,true);
//            EntityDimi2 e = new EntityDimi2(EntityInit.DIMI2.get(),this.level);
//            e.copyPosition(this);
//            this.level.addFreshEntity(e);
//            this.remove();
//
//        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }


    public boolean isNonBoss()
    {
        return false;
    }
    //什么时候能看见boss血条
    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }
    //什么时候看不见boss血条
    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }
}
