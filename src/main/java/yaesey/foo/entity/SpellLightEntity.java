package yaesey.foo.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class SpellLightEntity extends ThrownEntity {
    private static final Set<StatusEffect> EFFECTS = new HashSet<>();

    public SpellLightEntity(EntityType<? extends SpellLightEntity> entityType, World world) {
        super(entityType,world);
    }

    @Override
    public void tick() {
        super.tick();
    }

    /**
     * 添加击中生物后这个可怜生物会获得的效果
     * @param effect
     */
    public void addEffect(StatusEffect effect) {
        EFFECTS.add(effect);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entityHitResult.getEntity();
            livingEntity.damage(DamageSource.MAGIC,1.0F);
            for (StatusEffect effect : EFFECTS) {
                livingEntity.addStatusEffect(new StatusEffectInstance(effect,1200,1));
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.world.isClient) {
            this.remove();
        }
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void initDataTracker() {

    }
}