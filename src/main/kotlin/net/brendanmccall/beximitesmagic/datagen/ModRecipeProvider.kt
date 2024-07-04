package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.item.ModItems
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalItem
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalShardItem
import net.brendanmccall.beximitesmagic.item.ModItems.getStaffItem
import net.brendanmccall.beximitesmagic.item.ModItems.materials
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.*
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class ModRecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {

    // Helper functions for using Iron and Diamond to upgrade in smithing table
    private fun offerIronUpgradeRecipe(exporter: RecipeExporter?, input: Item?, category: RecipeCategory?,
                                       result: Item?) {
        SmithingTransformRecipeJsonBuilder.create(
            Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.ofItems(input),
            Ingredient.ofItems(
                Items.IRON_INGOT
            ),
            category,
            result
        ).criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
            .offerTo(exporter, getItemPath(result) + "_smithing")
    }
    private fun offerDiamondUpgradeRecipe(exporter: RecipeExporter?, input: Item?, category: RecipeCategory?,
                                          result: Item?) {
        SmithingTransformRecipeJsonBuilder.create(
            Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.ofItems(input),
            Ingredient.ofItems(
                Items.DIAMOND
            ),
            category,
            result
        ).criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter, getItemPath(result) + "_smithing")
    }

    // Generating recipe json files
    override fun generate(exporter: RecipeExporter) {
        // Basic staff crafting recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, getStaffItem(null, null), 1)
            .pattern("## ")
            .pattern(" # ")
            .pattern("  #")
            .input('#', Items.STICK)
            .criterion(hasItem(Items.STICK), RecipeProvider.conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier(getRecipeName(getStaffItem(null, null))))

        // Elemental staff crafting recipes
        // Wooden staff
        elements.drop(2).forEach { crystalElement ->
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                getStaffItem(null, crystalElement), 1)
                .input(getStaffItem(null, null))
                .input(getCrystalItem(crystalElement))
                .criterion(
                    hasItem(getStaffItem(null, null)),
                    RecipeProvider.conditionsFromItem(getStaffItem(null, null))
                )
                .criterion(
                    hasItem(getCrystalItem(crystalElement)),
                    RecipeProvider.conditionsFromItem(getCrystalItem(crystalElement))
                )
                .offerTo(exporter, Identifier(getRecipeName(getStaffItem(null, crystalElement))))
        }
        // Iron, Diamond, Netherite staffs
        materials.drop(1).forEach { staffMaterial ->
            elements.drop(2).forEach { crystalElement ->
                ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,
                    getStaffItem(staffMaterial, crystalElement), 1)
                    .input(getStaffItem(staffMaterial, null))
                    .input(getCrystalItem(crystalElement))
                    .criterion(
                        hasItem(getStaffItem(staffMaterial, null)),
                        RecipeProvider.conditionsFromItem(getStaffItem(staffMaterial, null))
                    )
                    .criterion(
                        hasItem(getCrystalItem(crystalElement)),
                        RecipeProvider.conditionsFromItem(getCrystalItem(crystalElement))
                    )
                    .offerTo(exporter, Identifier(getRecipeName(getStaffItem(staffMaterial, crystalElement))))
            }
        }

        // Staff smithing recipes
        offerIronUpgradeRecipe(exporter, getStaffItem(null, null), RecipeCategory.COMBAT,
            getStaffItem("iron", null))
        offerDiamondUpgradeRecipe(exporter,  getStaffItem("iron", null), RecipeCategory.COMBAT,
            getStaffItem("diamond", null))
        offerNetheriteUpgradeRecipe(exporter,  getStaffItem("diamond", null), RecipeCategory.COMBAT,
            getStaffItem("netherite", null))
        elements.drop(2).forEach { staffElement ->
            offerIronUpgradeRecipe(exporter,
                getStaffItem(null, staffElement),
                RecipeCategory.COMBAT,
                getStaffItem("iron", staffElement))
        }
        elements.drop(2).forEach { staffElement ->
            offerDiamondUpgradeRecipe(exporter,
                getStaffItem("iron", staffElement),
                RecipeCategory.COMBAT,
                getStaffItem("diamond", staffElement))
        }
        elements.drop(2).forEach { staffElement ->
            offerNetheriteUpgradeRecipe(exporter,
                getStaffItem("diamond", staffElement),
                RecipeCategory.COMBAT,
                getStaffItem("netherite", staffElement))
        }

        // Crystal crafting recipes
        // Standard crystal
        val crystalRecipe = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.crystal, 1)
        elements.drop(2).dropLast(1).forEach { crystalElement ->
                crystalRecipe.input(getCrystalShardItem(crystalElement))
        }
        elements.drop(2).dropLast(1).forEach { crystalElement ->
            crystalRecipe.criterion(hasItem(getCrystalShardItem(crystalElement)),
                RecipeProvider.conditionsFromItem(getCrystalShardItem(crystalElement)))
        }
        crystalRecipe.offerTo(exporter, Identifier(getRecipeName(ModItems.crystal)))
        // Elemental crystals
        elements.drop(2).forEach { crystalElement ->
            offerCompactingRecipe(exporter, RecipeCategory.MISC,
                getCrystalItem(crystalElement),
                getCrystalShardItem(crystalElement))
        }
    }
}