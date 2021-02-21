package yaesey.foo.mixin;

import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yaesey.foo.Originiums;
import yaesey.foo.item.OriginiumsItem;

@Mixin(ModelLoader.class)
public class ModelLoaderMixin {
    private String getItemModelJson(String path, String type) {
        if ("generated".equals(type) || "handheld".equals(type)) {
            return "{\n" +
                    "  \"parent\": \"item/" + type + "\"," + "\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"example_mod:" + path + "\"\n" +
                    "  }\n" +
                    "}";
        } else {
            return "";
        }
    }

    @Inject(method = "loadModelFromJson",
            at = @At(value = "INVOKE",
                     target = "Lnet/minecraft/resource/ResourceManager;" +
                             "getResource(Lnet/minecraft/util/Identifier;)" +
                             "Lnet/minecraft/resource/Resource;"),
            cancellable = true)
    public void loadModelFromJson(Identifier id, CallbackInfoReturnable<JsonUnbakedModel> cir) {
        if (!Originiums.MODID.equals(id.getNamespace())) {
            return;
        }
        //todo:我们需要在 ItemRegistry 里面添加一些Set来进行判断
        //这里有个令人吐槽的点，在实操中id.getPath()返回的是"item/item_name"这种令人吐槽不能的格式
        String modelJson = getItemModelJson(id.getPath(),"generated");
        Originiums.LOGGER.info("注意啦，" + id.getPath() + "模型已加载");
        if ("".equals(modelJson)) {
            return;
        }

        JsonUnbakedModel model = JsonUnbakedModel.deserialize(modelJson);
        model.id = id.toString();
        cir.setReturnValue(model);
        cir.cancel();
    }
}
