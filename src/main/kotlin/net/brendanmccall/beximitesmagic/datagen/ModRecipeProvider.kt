package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.brendanmccall.beximitesmagic.item.ModItems.getStaffItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class ModRecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {

    // Helper functions for using Iron and Diamond to upgrade in smithing table
    fun offerIronUpgradeRecipe(exporter: RecipeExporter?, input: Item?, category: RecipeCategory?, result: Item?) {
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
    fun offerDiamondUpgradeRecipe(exporter: RecipeExporter?, input: Item?, category: RecipeCategory?, result: Item?) {
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
    }
}