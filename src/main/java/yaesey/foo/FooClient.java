package yaesey.foo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FooClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

    }
}
