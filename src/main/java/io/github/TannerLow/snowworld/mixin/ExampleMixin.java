package io.github.TannerLow.snowworld.mixin;

import net.minecraft.client.MinecraftApplet;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftApplet.class)
public class ExampleMixin {
	@Inject(at = @At("RETURN"), method = "init", remap = false)
	private void initReturn(CallbackInfo ci) {
		System.out.println("This line is printed by an example mod mixin!");
	}
}
