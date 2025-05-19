package xyz.alycat.rsponge.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import xyz.alycat.rsponge.Main;
import xyz.alycat.rsponge.config.Config;
import xyz.alycat.rsponge.loot.ModLootModifier;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
	public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, Main.MODID);
		replacing();
	}

	@Override
	protected void start() {
		this.add("sponge", new ModLootModifier(
				new LootItemCondition[]{
						new LootTableIdCondition.Builder(BuiltInLootTables.FISHING.location()).build(),
						LootItemRandomChanceCondition.randomChance(0.16f).build(),
				},
				Config.SPONGE_ITEM
		));
	}
}
