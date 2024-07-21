package net.brendanmccall.beximitesmagic

import net.brendanmccall.beximitesmagic.block.ModBlocks
import net.brendanmccall.beximitesmagic.effect.ModStatusEffects
import net.brendanmccall.beximitesmagic.entity.ModEntities
import net.brendanmccall.beximitesmagic.item.ModItemGroups
import net.brendanmccall.beximitesmagic.item.ModItems
import net.fabricmc.api.EnvType
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory


object BeximitesMagic : ModInitializer {
	val modID = "beximitesmagic"
	val logger = LoggerFactory.getLogger(modID)

	override fun onInitialize() {
		logger.info("Loading Beximite's Magic...")

		// Only render on the client
		if (FabricLoader.getInstance().environmentType == EnvType.CLIENT) {
			BeximitesMagicClient.onInitializeClient()
		}

		// Registries
		ModStatusEffects.registerModStatusEffects() // WARNING: PUT BEFORE ITEM REGISTRY
		ModItemGroups.registerModItemGroups()
		ModItems.registerModItems()
		ModBlocks.registerModBlocks()
		ModEntities.registerModEntities()

		// Unused Registries
		//ModFuelComponents.registerModFuelComponents()
		//ModSounds.registerSounds()
		//ModEntitySpawns.registerEntitySpawns()

		// Unused Modifiers
		//ModLootTableModifiers.modifyLootTables()
	}
}