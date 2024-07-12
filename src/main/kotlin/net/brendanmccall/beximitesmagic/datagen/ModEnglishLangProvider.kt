package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.block.ModBlocks.oreTypes
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.brendanmccall.beximitesmagic.item.ModItems.materials
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModEnglishLangProvider(
    private val dataGenerator: FabricDataOutput,
    registryFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricLanguageProvider(dataGenerator, registryFuture) {

    // Capitalize the first letter of each word in a name
    private fun String.titleCase(): String {
        return this.split(" ").joinToString(" ")
        { it.replaceFirstChar { char -> char.uppercase() } }
    }

    override fun generateTranslations(registryLookup: RegistryWrapper.WrapperLookup,
                                      translationBuilder: TranslationBuilder) {
        // List for soul effect
        val soulEffectNames = listOf("§9§lWater", "§b§lIce", "§2§lTerra", "§4§lFire", "§e§lMind", "§6§lChaos",
            "§7§lOrder", "§5§lSpacetime", "§d§lLife", "§8§lDeath")

        // Registering translations
        // Creative mode tab
        translationBuilder.add("itemgroup.${BeximitesMagic.modID}", "Beximite's Magic")
        // Staff items
        materials.forEach { staffMaterial ->
            val materialCaseName = staffMaterial.titleCase()
            elements.forEach { staffElement ->
                val elementCaseName = staffElement.titleCase()
                translationBuilder.add(
                    "item.${BeximitesMagic.modID}." +
                            (if (staffMaterial.isNotEmpty()) staffMaterial + "_" else "") +
                            "${if (staffElement.isNotEmpty()) staffElement + "_" else ""}staff",
                    (if (staffMaterial.isNotEmpty()) "$materialCaseName " else "") +
                            "${if (staffElement.isNotEmpty()) "$elementCaseName " else ""}Staff")
            }
        }
        // Crystal items, crystal shard items, and soul items
        translationBuilder.add("item.${BeximitesMagic.modID}.crystal", "Crystal")
        elements.drop(2).forEach { element ->
            val elementCaseName = element.titleCase()
            translationBuilder.add(
                "item.${BeximitesMagic.modID}.${element}_crystal",
                "$elementCaseName Crystal")
            translationBuilder.add(
                "item.${BeximitesMagic.modID}.${element}_crystal_shard",
                "$elementCaseName Crystal Shard")
            translationBuilder.add(
                "item.${BeximitesMagic.modID}.${element}_soul",
                "$elementCaseName Soul")
        }
        // Ore blocks
        oreTypes.forEach { oreType ->
            var oreTypeCaseName = oreType.titleCase()
            if (oreType == "end_stone") {
                oreTypeCaseName = "End Stone"
            }
            elements.drop(2).forEach { oreElement ->
                val elementCaseName = oreElement.titleCase()
                translationBuilder.add(
                    "block.${BeximitesMagic.modID}.${if (oreType.isNotEmpty()) oreType + "_" else ""}" +
                            "${oreElement}_crystal_ore",
                    (if (oreType.isNotEmpty()) "$oreTypeCaseName " else "") +
                            "$elementCaseName Crystal Ore")
            }
        }
        // Soul effects & descriptions
        soulEffectNames.withIndex().forEach { (index, name) ->
            for (elementIndex in 0..9) {
                if (elementIndex == index) {
                    val element = elements.drop(2)[elementIndex]
                    translationBuilder.add(
                        "effect.${BeximitesMagic.modID}.${element}_soul_effect",
                        "$name Soul")
                    translationBuilder.add(
                        "effect.${BeximitesMagic.modID}.${element}_soul_effect.description",
                        "Your soul is bound to the element of ${element}.")
                }
            }
        }

        // Unused translations
        /*translationBuilder.add(
            "tooltip.${BeximitesMagic.modID}.custom_item.tooltip",
            "Custom Item Tooltip")*/ // Custom Tooltip

        // Load the language file
        val existingFilePath = dataGenerator.modContainer
            .findPath("assets/${BeximitesMagic.modID}/lang/en_us.existing.json")

        if (existingFilePath.isPresent) {
            try {
                translationBuilder.add(existingFilePath.get())
            } catch (e: Exception) {
                BeximitesMagic.logger.warn("Failed to add existing language file: ${e.message}")
            }
        } else {
            BeximitesMagic.logger.info("No existing language file found. Skipping.")
        }
    }
}