package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalShardItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {

    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.water_crystal_ore)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        elements.drop(2).forEach() { crystalElement ->
            itemModelGenerator.register(getCrystalShardItem(crystalElement), Models.GENERATED)
        }
    }
}