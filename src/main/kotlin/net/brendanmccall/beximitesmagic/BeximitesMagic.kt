package net.brendanmccall.beximitesmagic

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object BeximitesMagic : ModInitializer {
	private val mod_id = "beximitesmagic";
    private val logger = LoggerFactory.getLogger(mod_id	)

	override fun onInitialize() {
		logger.info("Loading Beximite's Magic...")
	}
}