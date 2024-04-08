package net.brendanmccall.beximitesmagic

import net.brendanmccall.beximitesmagic.item.ModItemGroups
import net.brendanmccall.beximitesmagic.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object BeximitesMagic : ModInitializer {
	public val mod_id = "beximitesmagic";
    public val logger = LoggerFactory.getLogger(mod_id)

	override fun onInitialize() {
		logger.info("Loading Beximite's Magic...")

		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
	}
}