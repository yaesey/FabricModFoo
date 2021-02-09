package yaesey.foo.registries;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import yaesey.foo.Foo;
import yaesey.foo.item.OriginiumsItem;

import java.lang.reflect.Field;

public class ItemRegistry {
    private ItemRegistry(){ }
    public static final ItemRegistry INSTANCE = new ItemRegistry();

    public static final Item ORIGINIUMS = new OriginiumsItem();

    public void registry() {
        try {
            for(Field field : ItemRegistry.class.getDeclaredFields()) {
                if (field.get(null) instanceof Item) {
                    Item item = (Item)field.get(null);
                    Registry.register(Registry.ITEM,
                                      new Identifier(Foo.MODID,field.getName().toLowerCase()),
                                      item);
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
