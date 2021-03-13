package yaesey.foo.item.wand;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import yaesey.foo.entity.SpellLightEntity;
import yaesey.foo.registries.EntityRegistry;

public class SupportWandItem extends BaseWandItem{
    public SupportWandItem(Settings settings) {
        super(settings);
    }

    @Override
    protected void useLogic(World world, PlayerEntity user, Hand hand) {
        SpellLightEntity spellLightEntity = new SpellLightEntity(EntityRegistry.SPELL_LIGHT,world);
        spellLightEntity.setOwner(user);
        spellLightEntity.setVelocity(user.getVelocity());
        spellLightEntity.addEffect(StatusEffects.SLOWNESS);

        world.spawnEntity(spellLightEntity);
    }
}
