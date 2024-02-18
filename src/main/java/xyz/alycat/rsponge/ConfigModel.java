package xyz.alycat.rsponge;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RestartRequired;
@Modmenu(modId = Main.MOD_ID)
@Config(name = Main.MOD_ID, wrapperName = "ModConfig")
public class ConfigModel {
    // Client side
    // Server handles the recipe config, no need to sync
    @RestartRequired
    public float rarity = 0.16f;
}