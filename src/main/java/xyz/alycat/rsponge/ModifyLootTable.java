package xyz.alycat.rsponge;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModifyLootTable {
    public static void addItemToLootTable(Identifier tableId, Item item, Integer weight) {
        LootTableEvents.MODIFY.register((resourceManager,lootManager, key, tableBuilder, source) -> {
            if (source.isBuiltin() && tableId.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder.with(ItemEntry.builder(item).weight(weight)));
            }
        });
    }
}
