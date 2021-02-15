package yaesey.foo.client;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import yaesey.foo.Originiums;
import yaesey.foo.registries.ItemRegistry;

public class OriTab {
    public static final ItemGroup ORI_GROUP = FabricItemGroupBuilder.create(new Identifier(Originiums.MODID,"ori_group"))
            .icon(() -> new ItemStack(ItemRegistry.ORIGINIUMS))
            .build();
}
