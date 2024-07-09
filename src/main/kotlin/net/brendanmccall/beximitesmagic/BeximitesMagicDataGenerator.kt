package net.brendanmccall.beximitesmagic

import net.brendanmccall.beximitesmagic.datagen.ModBlockTagProvider
import net.brendanmccall.beximitesmagic.datagen.ModEnglishLangProvider
import net.brendanmccall.beximitesmagic.datagen.ModItemTagProvider
import net.brendanmccall.beximitesmagic.datagen.ModLootTableProvider
import net.brendanmccall.beximitesmagic.datagen.ModModelProvider
import net.brendanmccall.beximitesmagic.datagen.ModRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object BeximitesMagicDataGenerator : DataGeneratorEntrypoint {

	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider(::ModBlockTagProvider)
		pack.addProvider(::ModEnglishLangProvider)
		pack.addProvider(::ModItemTagProvider)
		pack.addProvider(::ModLootTableProvider)
		pack.addProvider(::ModModelProvider)
		pack.addProvider(::ModRecipeProvider)
	}
}