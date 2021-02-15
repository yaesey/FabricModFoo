package yaesey.foo;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yaesey.foo.registries.EffectRegistry;
import yaesey.foo.registries.ItemRegistry;

public class Originiums implements ModInitializer {
    public static final String MODID = "originiums";
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void onInitialize() {
        LOGGER.info("Mod加载中...");
        ItemRegistry.INSTANCE.registry();
        EffectRegistry.INSTANCE.registry();
    }
}
