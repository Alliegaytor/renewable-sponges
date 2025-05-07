package xyz.alycat.rsponge;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import xyz.alycat.rsponge.config.Config;
import xyz.alycat.rsponge.loot.ModLootTableModifiers;


@Mod(Main.MODID)
public class Main {
	public static final String MODID = "rsponge";
	public static final Logger LOGGER = LogUtils.getLogger();

	public Main(IEventBus modEventBus, ModContainer modContainer) {
		// Configuration
		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
		modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

		NeoForge.EVENT_BUS.register(this);

        ModLootTableModifiers.register(modEventBus);
	}

	@SubscribeEvent
	public void onServerSetup(ServerStartingEvent event) {
		LOGGER.info(MODID + ": adding sponges to fishing loot table");
	}

}
