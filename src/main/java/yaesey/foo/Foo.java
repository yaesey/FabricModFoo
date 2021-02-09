package yaesey.foo;

import io.netty.util.internal.logging.Log4J2LoggerFactory;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Foo implements ModInitializer {
    public static final String MODID = "foo";
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void onInitialize() {
        LOGGER.info("Mod加载中...");
    }
}
