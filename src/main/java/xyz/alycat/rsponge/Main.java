package xyz.alycat.rsponge;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.alycat.rsponge.ModConfig;

public class Main implements ModInitializer {
	public static final String MOD_ID = "rsponge";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final ModConfig CONFIG = ModConfig.createAndLoad();
	private static final Integer weight = (int) (CONFIG.rarity() * 100);

	@Override
	public void onInitialize() {
		// Display welcome
		LOGGER.info(MOD_ID + ": adding sponges to fishing loot table, weight {}", weight);

		if (weight >= 100) {
			LOGGER.info(MOD_ID + ": you may want to lower the weight of the sponges :)");
		}

		ModifyLootTable.addItemToLootTable(LootTables.FISHING_GAMEPLAY, Items.SPONGE, weight);
	}
}
