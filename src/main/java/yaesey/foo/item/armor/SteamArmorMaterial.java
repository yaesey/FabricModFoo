package yaesey.foo.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * 蒸汽甲胄
 */
public class SteamArmorMaterial implements ArmorMaterial {
    private int tagValue = 5;//加成
    private static final int[] BASE_DURABILITY = new int[] {10,30,20,5};
    private static final int[] PROTECTION_VALUES = new int[] {2,3,3,1};
    /**
     * @return 装备的耐久度，当然，不同部位的耐久也会有所不同，这里我们也可以理解为不同装备在不被击破前最大受击数
     */
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * tagValue;
    }

    /**
     * @return 根据身体部位返回一个保护值，决定了不同部位能获得多少保护
     */
    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    /**
     * @return 一个附魔值,决定了装备最高附魔等级或在附魔台能刷出多NB的魔咒
     */
    @Override
    public int getEnchantability() {
        return 30;
    }

    /**
     * @return 穿上装甲会发出什么声音
     */
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public String getName() {
        return "steam_armor";
    }

    /**
     * @return 面对高攻击时的防护值
     */
    @Override
    public float getToughness() {
        return (float)tagValue;
    }

    /**
     * @return 击退保护，格式为0.xF，默认为0
     */
    @Override
    public float getKnockbackResistance() {
        return 0.0F;
    }

    /**
     * @return 修补要用什么来修补
     */
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_BLOCK);
    }
}
