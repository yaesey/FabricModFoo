package yaesey.foo.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseItem extends Item {
    //todo:等肝力上来了会专门把tooltip写一遍的
    private boolean openTooltip = false;

    public BaseItem(Settings settings) {
        super(settings);
    }

    public void setOpenTooltip(boolean openTooltip) {
        this.openTooltip = openTooltip;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (openTooltip) {
            tooltip.add(new TranslatableText(this.getTranslationKey() + ".tooltip").formatted(Formatting.GRAY));
        }
    }
}
