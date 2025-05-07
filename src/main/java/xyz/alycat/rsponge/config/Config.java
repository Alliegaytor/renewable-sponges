package xyz.alycat.rsponge.config;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import xyz.alycat.rsponge.Main;

// Client/Server side configs non restart
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.ConfigValue<Boolean> SPONGE_WET = BUILDER
			.comment("SPONGE_ITEM")
			.define("SPONGE_ITEM", true);

	public static final ModConfigSpec SPEC = BUILDER.build();

	public static Item SPONGE_ITEM = Items.SPONGE;

	@SubscribeEvent
	static void onLoad(final ModConfigEvent event) {
		SPONGE_ITEM = SPONGE_WET.get() ? Items.WET_SPONGE : Items.SPONGE;
	}
}
