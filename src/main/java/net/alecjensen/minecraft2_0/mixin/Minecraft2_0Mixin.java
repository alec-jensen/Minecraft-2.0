package net.alecjensen.minecraft2_0.mixin;

import net.alecjensen.minecraft2_0.Minecraft2_0;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class Minecraft2_0Mixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Minecraft2_0.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
