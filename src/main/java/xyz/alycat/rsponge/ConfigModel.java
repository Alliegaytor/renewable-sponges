package xyz.alycat.rsponge;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RestartRequired;

@Modmenu(modId = Main.MOD_ID)
@Config(name = Main.MOD_ID, wrapperName = "ModConfig")
public class ConfigModel {
    // Client side
    // Server handles the rarity config, no need to sync
    // Is multiplied by 100 and cast to int. Not an int for legacy config compatibility
    @RestartRequired
    public float rarity = 0.12f;
    @RestartRequired
    public boolean wetSponge = true;
}
