package xyz.alycat.rsponge;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "rsponge";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final Float rarity = 0.16f;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info(MOD_ID + ": adding sponges to fishing loot table, rarity " + rarity);

		ModifyLootTable.addItemToLootTable(LootTables.FISHING_TREASURE_GAMEPLAY, Items.SPONGE, rarity);

	}
}