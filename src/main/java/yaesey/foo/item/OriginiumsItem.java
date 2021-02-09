package yaesey.foo.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import yaesey.foo.effect.OripathyEffect;
import yaesey.foo.registries.EffectRegistry;

public class OriginiumsItem extends Item{
    public OriginiumsItem(){
        super(new FabricItemSettings()
                    .fireproof()  //源石将会防火
                    .group(ItemGroup.MISC));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        //用源石击中生物后，该生物将会有概率患上矿石病，如果此前已经患上了，将会加重病情
        int ampilifier = 1;
        if(entity.hasStatusEffect(EffectRegistry.ORI)) {
            ampilifier = entity.getStatusEffect(EffectRegistry.ORI).getAmplifier() + 1;
            entity.removeStatusEffect(EffectRegistry.ORI);
        }
        entity.addStatusEffect(new StatusEffectInstance(EffectRegistry.ORI,1,ampilifier));
        return super.useOnEntity(stack, user, entity, hand);
    }
}
