package net.alecjensen.minecraft2_0;

import net.alecjensen.minecraft2_0.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecraft2_0 implements ModInitializer {
	public static final String MOD_ID = "minecraft2_0";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		LOGGER.info("Loaded Minecraft 2.0!");
	}
}
