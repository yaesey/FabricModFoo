package yaesey.foo.registries;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import yaesey.foo.Originiums;
import yaesey.foo.entity.SpellLightEntity;

import java.lang.reflect.Field;

public class EntityRegistry {
    public static final EntityType<SpellLightEntity> SPELL_LIGHT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Originiums.MODID,"spell_light"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC,SpellLightEntity::new)
                    .dimensions(EntityDimensions.fixed(2.0F,0.25F))
                    .trackRangeChunks(2)
                    .build()
    );
}
