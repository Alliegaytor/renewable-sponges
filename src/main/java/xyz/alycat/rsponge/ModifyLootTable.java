package xyz.alycat.rsponge;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModifyLootTable {
    public static void addItemToLootTable(Identifier tableId, Item item, Float rarity) {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && tableId.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(rarity))
                        .with(ItemEntry.builder(item));
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
