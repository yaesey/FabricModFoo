package yaesey.foo.registries;

public class Registries {
    private Registries() { }
    public static final Registries INSTANCE = new Registries();

    public void registry() {
        ItemRegistry.INSTANCE.registry();
        EffectRegistry.INSTANCE.registry();
    }

    public void clientRegistry() {

    }
}
