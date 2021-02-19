package yaesey.foo.client;

import net.fabricmc.api.ClientModInitializer;
import yaesey.foo.Originiums;
import yaesey.foo.registries.Registries;

/**
 * 客户端注册请在这里，包括模型加载，渲染器注册等等
 */
public class OriginiumsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Originiums.LOGGER.info("Mod 客户端启动中...");

        Registries.INSTANCE.clientRegistry();
    }
}
