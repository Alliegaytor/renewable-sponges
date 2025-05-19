# 1.2.1 - 2025.05.19

* Use newer non-deprecated fabric LootTableEvents v3 api
* Update build tools


# 1.2.0-beta.1+neo (1.21.4 - 1.21.5) - 2025.05.07

* Initial port to neoforge


# 1.2.0 - 2025.01.07

* Change fishing drop from SPONGE to WET_SPONGE (issue #1)
* Add configuration option for sponge type (wet, normal)
* Fix dependency issues in fabric.mod.json
    * Properly specify Minecraft versions that the mod is compatible with (Minecraft 1.20.5-6 should work now)
    * Add breaking version of owo-lib (0.12.9+1.20.5)
* Update build tools


# 1.1.0 - 2024.05.14

* Update for Minecraft 1.20.5+
* Change how sponges are appended to fishing loot table
    * Sponges now are dropped alone without any other item
    * Sponges are now in the FISHING_GAMEPLAY loot table
    * Rarity is now calculated as weight
    * Rarity set to 0.12 (12 weight) by default
* Used newer build tools


# 1.0.0 - 2024.02.15

* Initial release