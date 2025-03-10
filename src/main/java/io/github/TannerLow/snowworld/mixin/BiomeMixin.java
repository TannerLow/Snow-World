package io.github.TannerLow.snowworld.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biome.class)
public class BiomeMixin {

    @Inject(method="init", at=@At("HEAD"))
    private static void makeAllBiomesSnow(CallbackInfo ci) {
        Biome.PLAINS.enableSnow();
        Biome.FOREST.enableSnow();
        Biome.DESERT.enableSnow();
        Biome.ICE_DESERT.enableSnow();
        Biome.RAINFOREST.enableSnow();
        Biome.SAVANNA.enableSnow();
        Biome.SEASONAL_FOREST.enableSnow();
        Biome.SHRUBLAND.enableSnow();
        Biome.SKY.enableSnow();
        Biome.TUNDRA.enableSnow();
        Biome.TAIGA.enableSnow();
        Biome.SWAMPLAND.enableSnow();
    }
}
