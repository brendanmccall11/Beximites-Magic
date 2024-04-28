package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks.getOreBlock
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalItem
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalShardItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {

    // Generate model json files for blocks
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        // Ore blocks
        elements.drop(2).forEach { oreElement ->
            blockStateModelGenerator.registerSimpleCubeAll(getOreBlock(null, oreElement))
        }
        elements.drop(2).forEach { oreElement ->
            blockStateModelGenerator.registerSimpleCubeAll(getOreBlock("deepslate", oreElement))
        }
        elements.drop(2).forEach { oreElement ->
            blockStateModelGenerator.registerSimpleCubeAll(getOreBlock("netherrack", oreElement))
        }
        elements.drop(2).forEach { oreElement ->
            blockStateModelGenerator.registerSimpleCubeAll(getOreBlock("end_stone", oreElement))
        }
    }

    // Generate model json files for items
    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        elements.drop(2).forEach { crystalElement ->
            itemModelGenerator.register(getCrystalItem(crystalElement), Models.GENERATED)
        }
        elements.drop(2).forEach { crystalElement ->
            itemModelGenerator.register(getCrystalShardItem(crystalElement), Models.GENERATED)
        }
    }
}