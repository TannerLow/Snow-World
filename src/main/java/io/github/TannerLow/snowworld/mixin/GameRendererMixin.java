package io.github.TannerLow.snowworld.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @WrapOperation(method="renderSnow", at=@At(value="INVOKE", target="Lnet/minecraft/world/World;getRainGradient(F)F"))
    private float zeroRainGradient(World instance, float param, Operation<Float> original) {
        return 0.5f;
    }
}
