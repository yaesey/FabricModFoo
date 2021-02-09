package yaesey.foo.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import yaesey.foo.Foo;
import yaesey.foo.registries.EffectRegistry;

public class OripathyEffect extends StatusEffect {
    private static final int MAX_ORI = 5;
    private static final int TIME = 0;

    public OripathyEffect() {
        super(StatusEffectType.NEUTRAL,
                0xff9933//有点像源石的橙色
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //todo:待添加矿石病的增益
        if (amplifier >= MAX_ORI) {
            entity.damage(DamageSource.MAGIC,1.0F);
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        //判断该生物是不是处于旁观者模式或创造模式
        //神（创造模式）会感染矿石病吗？
        if (entity.isSpectator() || (entity instanceof PlayerEntity && ((PlayerEntity) entity).isCreative())) {
            return;
        }
        entity.addStatusEffect(new StatusEffectInstance(EffectRegistry.ORI,1,amplifier + 1));
        //Foo.LOGGER.info("新的要来");
        super.onRemoved(entity, attributes, amplifier);
    }
}
