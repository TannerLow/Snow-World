package io.github.TannerLow.snowworld.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import net.minecraft.world.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public class WorldMixin{

    @Shadow protected WorldProperties properties;
    @Shadow protected float rainGradient;
    @Shadow protected float rainGradientPrev;

    @Inject(method="updateWeatherCycles", at=@At("HEAD"))
    private void setPermaRain(CallbackInfo ci) {
        this.properties.setRaining(true);
        this.properties.setRainTime(5000);
    }

    @WrapOperation(method="getAmbientDarkness", at=@At(value="INVOKE", target="Lnet/minecraft/world/World;getRainGradient(F)F"))
    private float zeroAmbientDarknessRainGradient(World instance, float param, Operation<Float> original) {
        return 0.f;
    }

    // Rain gradient controls the actual density of rain/snow and not just the look of the sky
//    @Inject(method="updateWeatherCycles", at=@At("RETURN"))
//    private void zeroRainGradient(CallbackInfo ci) {
//        this.rainGradient = 1;
//        this.rainGradientPrev = 1;
//    }
}
