package yaesey.foo.registries;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import yaesey.foo.Foo;
import yaesey.foo.effect.OripathyEffect;

public class EffectRegistry {
    private EffectRegistry(){ }
    public static final EffectRegistry INSTANCE = new EffectRegistry();

    public static final StatusEffect ORI = new OripathyEffect();

    public void registry() {
        Registry.register(Registry.STATUS_EFFECT,
                          new Identifier(Foo.MODID,"ori"),
                          ORI);
    }
}
