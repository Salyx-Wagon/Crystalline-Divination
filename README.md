# Crystalline-Divination
 A Minecraft Forge mod for 1.16.4/5 that is under heavy devolpement.

v0.8

Changelog
*********
+ Added Export Rune
+ Added Import Rune
~ Updated Rendering of runes

Features
********
- Various crystals that spawn naturally in the world.
- Various crystal armor and tool types that give bonuses depending on what you're wearing or if you
have a full set of a single type of armor.
- Crystal dusts that can be crafted into any type of dye
- A wand to create various runes which all have different uses. 
- A pedestal to display items on (functional use comming soon)


Player Guide
************
- To start you'll need to find solar, lunar, pyro, and hydro crystal clusters. They need a diamond pickaxe or greater to mine.
(fortune increases drops)
	-Solar and lunar crystals spawn in "grassy" biomes, lunar being more rare. Lunar can also be found occasionally in the nether.
	-Pyro crystals spawn in desert and wasteland biomes and the nether.
	-Hydro crystals spawn in oceans and rivers.

- Crystals can be grown and reharvested in specific environments. They all have 4 stages, you know when they're grown when they start to emit particles.
	-Solar crystals can be grown on glowstone, sea lanterns, or shroomlights. They must also have a light level of 12 or above.
	-Lunar crystals can be grown on bedrock, obsidian, and netherite blocks. They must also have a light level of 7 or below.
	-Pyro crystals can be grown on magma blocks. They must also have lava adjacent to the block it's on.
	-Hydro crystals can be grown on packed ice, blue ice, prismarine, prismarine bricks, or dark prismarine. They must also have water adjacent to the block it's on.

- You can craft a Pedestal to display items with a quartz pillar, polished blackstone pressure plate, and 3 polished blackstone slabs.

- With the crystals you can craft a pure crystal using one of each in a crafting table.

- You can now make crystal tools and armor, which are better than netherrite. 

- Using a crystal tool or armor piece with a crystal of choice in a smithing table will infuse it with that crystal type.

- Solar tools and armor
	- When mining, all solar tools give you haste 1
	- Solar boots apply the speed 1 effect, and solar leggings apply jump-boost 2
	- When wearing a full set of solar armor, you gain speed 3 and jump-boost 4, and when mining with a solar tool you gain haste 3
- Lunar tools and armor
	- When holding any lunar tool, all mobs within a 50 block radius, not including players, will gain the glowing effect
	- Wearing the lunar helmet gives you night vision
	- when wearing a full set of lunar armor, and mob or player that deals damage to you will receive that x2
- Pyro tools and armor
	- All pyro tools will be enchanted with fire aspect when held 
	(if you'd like to enchant the tool in an enchanting table, make sure you don't hold it until you do)
	- Wearing any piece of pyro armor will give you fire resistance
	- When wearing a full set of pyro armor, any mobs attacking you will be set on fire for 5 seconds
- Hydro tools and armor
	- All hydro effects will only apply when in water or rain
	- When holding a hydro tool, you'll gain haste 25 (this negates the slow mining that comes from being in water)
	- When wearing a hydro chestplate you'll gain dophin's grace
	- A full set of hydro armor will give conduit power to all players and mobs within a 32 block radius including yourself

- All variants of crystals can be crafted in the stone cutter to get 2x crystal dust.

- Crafting with the 5 crystal dusts, you can create all 16 dyes.

- To craft a Divination Wand you'll need a couple sticks, a pure crystal, and the 4 other variants of crystals.

- To create the base rune, you'll need to have pure crystal dust in your offhand and right click a surface with the divination wand.

- Crafting with the base rune requires a specific order, right-click the ingredients onto the base rune and shift + right-click to craft.

- The storage rune is crafted with (in the specific order): chest, solar crystal, lunar crystal, pyro crystal, hydro crystal.
	- The storage rune is used to store items, it has the capacity of a normal chest. If you want to stop rendering the items, give the rune a redstone signal.

- The Crystalline Tablet is crafted with glass pane, solar crystal, lunar crystal, pyro crystal, hydro crystal.
	- You can shift + right-click a storage rune with the tablet to link it, then you can access that storage rune with the tablet as long as you're within 128 blocks.

- The export rune is crafted with ...
	- The export rune is used to export items from a (storage) rune to any other block inventory. 
	- Place the rune on the side of the block you want to export to, then shift-click the rune you're exporting from with your
	divination wand, then shift-click the export rune. 

- The import rune is crafted with ...
	- The import rune is used to import items to a (storage) rune from any other block inventory. 
	- Place the rune on the side of the block you want to import from, then shift-click the rune you're importing to with your
	divination wand, then shift-click the import rune. 
** Item filters for the import and export runes
	- You can filter both runes the same way. Have the item you're filtering in your offand whilst you right-click the rune with
	the divination wand. Click again with the same item in your offhand to toggle between whitelisting and blacklisting (as seen by
	black or white text that's shown when you hold the wand). To remove the filter just right-click the rune with the wand with 
	nothing in your offhand.