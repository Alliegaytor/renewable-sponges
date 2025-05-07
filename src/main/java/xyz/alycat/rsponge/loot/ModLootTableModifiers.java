package xyz.alycat.rsponge.loot;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import xyz.alycat.rsponge.Main;

import java.util.function.Supplier;

public class ModLootTableModifiers {
	public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZER =
			DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Main.MODID);

	public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM =
			LOOT_MODIFIER_SERIALIZER.register("add_item", ModLootModifier.CODEC);

	public static void register(IEventBus eventBus) {
		LOOT_MODIFIER_SERIALIZER.register(eventBus);
	}
}
