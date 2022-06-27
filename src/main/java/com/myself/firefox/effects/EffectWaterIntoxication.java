package com.myself.firefox.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

//水中毒：状态效果类
public class EffectWaterIntoxication extends BaseEffect{
    public EffectWaterIntoxication(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    //buff隔多久生效一次
    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 5 == 0;
    }

    //buff在生物身上的效果
    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified ++;
        Random ran = new Random();
        int co = ran.nextInt(5);
        //如果是玩家的话，就加快其饥饿速度
        if(living instanceof Player)
            ((Player)living).causeFoodExhaustion(2F*amplified);
        //生物每次受到0.5乘buff等级这么多的伤害
        living.hurt(DamageSource.WITHER, 0.5F*amplified);

    }
    //是不是增益buff
    @Override
    public boolean isBeneficial() {
        return this.getCategory() == MobEffectCategory.BENEFICIAL;
        //return true; //我故意的
    }
}
