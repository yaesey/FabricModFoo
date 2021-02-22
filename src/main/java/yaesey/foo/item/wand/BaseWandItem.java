package yaesey.foo.item.wand;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BaseWandItem extends Item implements Vanishable {
    public BaseWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        world.playSound((PlayerEntity)null,user.getX(),user.getY(),user.getZ(), SoundEvents.ENTITY_FISHING_BOBBER_THROW, SoundCategory.NEUTRAL,0.5F,0.4F / (RANDOM.nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            this.useLogic(world,user,hand);
        }
        this.useClient(world,user,hand);

        return TypedActionResult.success(itemStack,world.isClient);
    }

    /**
     * 魔杖的基本逻辑
     */
    protected void useLogic(World world, PlayerEntity user, Hand hand) {

    }

    /**
     * 魔杖转起来时候客户端应该加上什么特效
     */
    @Environment(EnvType.CLIENT)
    protected void useClient(World world, PlayerEntity user, Hand hand) {

    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 73200;
    }
}
