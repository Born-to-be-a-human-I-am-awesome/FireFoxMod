package com.myself.firefox.entity;

import com.myself.firefox.init.EntityInit;
import com.myself.firefox.init.ItemInit;
import io.netty.buffer.Unpooled;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

//投掷物生物实体类，写法来自原版 //便捷式火焰弹
public class EntityPortableFireCharge extends ThrowableItemProjectile {
    //投掷物伤害
    public double damage;

    //EntityType<? extends EntityPortableFireCharge>
    public EntityPortableFireCharge(EntityType<?> p_37391_, Level p_37392_) {
        super((EntityType<? extends EntityPortableFireCharge>) p_37391_, p_37392_);
        //super(p_37391_, p_37392_);
        //this.size(1.0F, 1.0F);
        this.damage = 6D;
    }

    public EntityPortableFireCharge(Level p_37399_, LivingEntity p_37400_) {
        super(EntityInit.ENTITY_PORTABLE_FIRE_CHARGE.get(), p_37400_, p_37399_); //指明实体，为我们要右键发射的那一个 原版为·EntityType.SNOWBALL
        //把伤害初始为6点
        this.damage = 6D;
    }

    public EntityPortableFireCharge(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(EntityInit.ENTITY_PORTABLE_FIRE_CHARGE.get(), p_37395_, p_37396_, p_37397_, p_37394_); //按双精度浮点型坐标生成，原版为·EntityType.SNOWBALL
    }

    //原理类似弓箭、雪球，我们对应第二步中的投掷物品
    @Override
    protected Item getDefaultItem() { //获取物品
        return ItemInit.PORTABLE_FIRE_CHARGE.get(); //便携式火焰弹：物品
    }

    //private ParticleOptions getParticle() {
        //ItemStack itemstack = this.getItemRaw();
        //return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    //}

    public void handleEntityEvent(byte p_37402_) { //击中实体就加个粒子上去
        //if (p_37402_ == 3) {
            //ParticleOptions particleoptions = this.getParticle();

            //for(int i = 0; i < 8; ++i) {
                //this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            //}
        //}

    }

    @Override
    protected void onHitEntity(EntityHitResult p_37404_) { //击中实体事件
        super.onHitEntity(p_37404_);
        Entity entity = p_37404_.getEntity(); //获取被打实体
        int i = entity instanceof Blaze ? 3 : 0;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);

        //给被打生物一个伤害
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));
    }

    //@Override
    //protected void onHit(HitResult p_37406_) { //击中任何东西的事件
        //super.onHit(p_37406_);
        //if (!this.level.isClientSide) {
            //this.level.broadcastEntityEvent(this, (byte)3);
            //this.discard();
        //}


    protected void onHitBlock(BlockHitResult p_37258_)
    {
        super.onHitBlock(p_37258_);

        if (level.getBlockState(p_37258_.getBlockPos().atY(p_37258_.getBlockPos().getY() + 1)).getBlock() == Blocks.AIR) //判定要放置的地方是空气，防止替换方块
        {
            level.setBlock(p_37258_.getBlockPos().atY(p_37258_.getBlockPos().getY() + 1), Blocks.FIRE.defaultBlockState(), 1, 1); //放置方块
        }
    }

    //不写这个会崩端（写了也会崩，不知道哪里出问题了啊啊啊）
    //哦，想起来了，忘写投掷物渲染了
    //那没事了
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
