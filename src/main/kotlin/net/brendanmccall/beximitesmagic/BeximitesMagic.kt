package net.brendanmccall.beximitesmagic

import net.brendanmccall.beximitesmagic.block.ModBlocks
import net.brendanmccall.beximitesmagic.item.ModFuelComponents
import net.brendanmccall.beximitesmagic.item.ModItemGroups
import net.brendanmccall.beximitesmagic.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object BeximitesMagic : ModInitializer {
	public val modID = "beximitesmagic"
	public val logger = LoggerFactory.getLogger(modID)

	override fun onInitialize() {
		logger.info("Loading Beximite's Magic...")

		ModItemGroups.registerModItemGroups()
		ModItems.registerModItems()
		ModBlocks.registerModBlocks()

		// Unused Registries
		//ModFuelComponents.registerModFuelComponents()
	}
}