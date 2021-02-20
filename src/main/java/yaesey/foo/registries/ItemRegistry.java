package yaesey.foo.registries;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import yaesey.foo.Originiums;
import yaesey.foo.client.OriTab;
import yaesey.foo.item.BaseItem;
import yaesey.foo.item.OriginiumsItem;
import yaesey.foo.item.armor.SteamArmorMaterial;

import java.lang.reflect.Field;

public class ItemRegistry {
    private ItemRegistry(){ }
    public static final ItemRegistry INSTANCE = new ItemRegistry();

    private static final Item.Settings setting = new Item.Settings().group(OriTab.ORI_GROUP);

    public static final Item ORIGINIUMS = new OriginiumsItem();
    public static final Item LMD = new BaseItem(setting);
    //异铁
    public static final Item ORIRON_SHARD = new BaseItem(setting);
    public static final Item ORIRON = new BaseItem(setting);
    public static final Item ORIRON_CLUSTER = new BaseItem(setting);
    public static final Item ORIRON_BLOCK = new BaseItem(setting);
    //酯
    public static final Item ESTER = new BaseItem(setting);
    public static final Item POLYESTER = new BaseItem(setting);
    public static final Item POLYESTER_PACK = new BaseItem(setting);
    public static final Item POLYESTER_LUMP = new BaseItem(setting);
    //装置
    public static final Item DAMAGED_DEVICE = new BaseItem(setting);
    public static final Item DEVICE = new BaseItem(setting);
    public static final Item INTEGRATED_DEVICE = new BaseItem(setting);
    public static final Item OPTIMIZED_DEVICE = new BaseItem(setting);
    //糖
    public static final Item SUGAR_SUB = new BaseItem(setting);
    public static final Item SUGAR = new BaseItem(setting);
    public static final Item SUGAR_PACK = new BaseItem(setting);
    public static final Item SUGAR_LUMP = new BaseItem(setting);
    //酮
    public static final Item DIKETON = new BaseItem(setting);
    public static final Item POLYKETON = new BaseItem(setting);
    public static final Item AKETON = new BaseItem(setting);
    public static final Item KETON_COLLOID = new BaseItem(setting);
    //土
    public static final Item ORIROCK = new BaseItem(setting);
    public static final Item ORIROCK_CUBE = new BaseItem(setting);
    public static final Item ORIROCK_CLUSTER = new BaseItem(setting);
    public static final Item ORIROCK_CONCEN = new BaseItem(setting);

    public static final Item LOXIC_KOHL = new BaseItem(setting);
    public static final Item WHITE_HORSE_KOHL = new BaseItem(setting);
    public static final Item GRINDSTONE = new BaseItem(setting);
    public static final Item GRINDSTONE_PENTA = new BaseItem(setting);
    public static final Item MANGANESE_ORE = new BaseItem(setting);
    public static final Item D32_STEEL = new BaseItem(setting);
    public static final Item BIPOLAR_NANOFLAKE = new BaseItem(setting);
    public static final Item PREPARATION = new BaseItem(setting);

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
                    Originiums.LOGGER.info("已注册物品："+field.getName()+"它的翻译名将会为"+item.getTranslationKey());
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
