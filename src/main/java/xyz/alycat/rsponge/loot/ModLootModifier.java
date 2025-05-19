package xyz.alycat.rsponge.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.random.Weight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntry;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import xyz.alycat.rsponge.config.Config;

import java.util.function.Supplier;


public class ModLootModifier extends LootModifier {
	public static final Supplier<MapCodec<ModLootModifier>> CODEC = Suppliers.memoize(()
			-> RecordCodecBuilder.mapCodec(inst -> codecStart(inst).and(BuiltInRegistries.ITEM.byNameCodec()
			.fieldOf("item").forGetter(m -> m.item)).apply(inst, ModLootModifier::new)));
	private final Item item;


	public ModLootModifier(LootItemCondition[] conditionsIn, Item item) {
		super(conditionsIn);
		this.item = item;
	}

	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		for (LootItemCondition condition : this.conditions) {
			if (!condition.test(context)) {
				return generatedLoot;
			}
		}

//		generatedLoot.removeFirst(); // remove original loot
		generatedLoot.add(new ItemStack(Config.SPONGE_ITEM));
		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}
