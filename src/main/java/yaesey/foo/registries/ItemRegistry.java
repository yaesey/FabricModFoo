package yaesey.foo.registries;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import yaesey.foo.Originiums;
import yaesey.foo.client.OriTab;
import yaesey.foo.item.OriginiumsItem;
import yaesey.foo.item.armor.SteamArmorMaterial;

import java.lang.reflect.Field;

public class ItemRegistry {
    private ItemRegistry(){ }
    public static final ItemRegistry INSTANCE = new ItemRegistry();

    public static final Item ORIGINIUMS = new OriginiumsItem();

    private static final Item.Settings setting = new Item.Settings().group(OriTab.ORI_GROUP);
    public static final ArmorMaterial steamArmor = new SteamArmorMaterial();
    public static final Item STEAM_ARMOR_HELMET = new ArmorItem(steamArmor, EquipmentSlot.HEAD,setting);
    public static final Item STEAM_ARMOR_CHESTPLATE = new ArmorItem(steamArmor,EquipmentSlot.CHEST,setting);
    public static final Item STEAM_ARMOR_LEGGINGS = new ArmorItem(steamArmor,EquipmentSlot.LEGS,setting);
    public static final Item STEAM_ARMOR_BOOTS = new ArmorItem(steamArmor,EquipmentSlot.FEET,setting);

    public void registry() {
        try {
            for(Field field : ItemRegistry.class.getDeclaredFields()) {
                if (field.get(null) instanceof Item) {
                    Item item = (Item)field.get(null);
                    Registry.register(Registry.ITEM,
                                      new Identifier(Originiums.MODID,field.getName().toLowerCase()),
                                      item);
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
