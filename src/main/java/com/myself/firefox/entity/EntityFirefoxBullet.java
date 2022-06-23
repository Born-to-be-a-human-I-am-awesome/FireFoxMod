package com.myself.firefox.entity;

import com.myself.firefox.init.EntityInit;
import com.myself.firefox.init.ItemInit;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

//火狐子弹：投掷物实体类
public class EntityFirefoxBullet extends ThrowableItemProjectile{
    //投掷物伤害
    public double damage;
    private int ticksInGround;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(EntityFirefoxBullet.class, EntityDataSerializers.INT);

    public EntityFirefoxBullet(EntityType<?> entityIn, Level level) {
        super((EntityType<? extends EntityFirefoxBullet>) entityIn, level);
        //this.size(1.0F, 1.0F);
        this.damage = 1.4D;
        // TODO Auto-generated constructor stub
    }

    public EntityFirefoxBullet(Level world, LivingEntity entity) {
        super(EntityInit.MOSPITTER.get(), entity, world);
        //把伤害初始为1.4点
        this.damage= 1.4D;
    }

    //原理类似弓箭、雪球，我们对应第二步中的投掷物品
    @Override
    protected Item getDefaultItem() {
        return ItemInit.FIREFOX_BULLET.get();
    }
    //打到生物身上的效果
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();


        int i = 6;
        if(entity instanceof IronGolem || entity instanceof Ravager){
            i = 10;
        }
        if(entity instanceof EnderDragon || entity instanceof WitherBoss){
            i= 11;
        }
//        if(entity instanceof EntityMoreau || entity instanceof EntityHeisen || entity instanceof EntityDimi2 || entity instanceof EntityMiranda2){
//            i= 4;
//        }
        //给被打生物伤害
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));

        //上火（物理）
        entity.setSecondsOnFire(20 * 6);

        //地火（物理）
        if (level.getBlockState(entity.getOnPos()) != Blocks.AIR.defaultBlockState())
        {
            level.setBlock(entity.getOnPos().atY(entity.getBlockY()), Blocks.FIRE.defaultBlockState(), 11, 11);
        }

        //当击中生物时，给使用者防火效果
        if (!result.getEntity().level.isClientSide)
        {
        ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 4, 0, true, true));
        }

        //概率触发
        if(random.nextInt(100) != 80)
        {
            //当满足概率且击中生物时触发
            //TODO

        }
        else
        {
            //TODO
            //((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50,0,true,true));

        }
    }

    //撞到墙上就把这个子弹给从主世界移除，并放置个方块
    //protected void onHit(EntityHitResult p_70227_1_)
    @Override
    protected void onHit(HitResult p_37260_) {
        super.onHit(p_37260_);
        if (!this.level.isClientSide) {
            //level.setBlock(.getEntity().getOnPos(), Blocks.FIRE.defaultBlockState(),1,1);
            //this.level.broadcastEntityEvent(this, (byte)3);
            //this.remove(Entity.RemovalReason.KILLED);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult p_37258_) {
        super.onHitBlock(p_37258_);

        if (level.getBlockState(p_37258_.getBlockPos().atY(p_37258_.getBlockPos().getY() + 1)).getBlock() == Blocks.AIR) //判定要放置的地方是空气，防止替换方块
        {
            level.setBlock(p_37258_.getBlockPos().atY(p_37258_.getBlockPos().getY() + 1), Blocks.FIRE.defaultBlockState(), 1, 1); //放置方块

            //删除子弹
            //this.level.broadcastEntityEvent(this, (byte)3);
            //this.remove(Entity.RemovalReason.KILLED);
        }


    }

    @Override
    public Packet<?> getAddEntityPacket() {
        FriendlyByteBuf pack = new FriendlyByteBuf(Unpooled.buffer());
        pack.writeDouble(getX());
        pack.writeDouble(getY());
        pack.writeDouble(getZ());
        pack.writeInt(getId());
        pack.writeUUID(getUUID());


        return NetworkHooks.getEntitySpawningPacket(this);

    }
}
