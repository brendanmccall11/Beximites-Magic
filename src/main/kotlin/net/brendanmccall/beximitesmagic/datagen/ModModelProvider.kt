package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks.getOreBlock
import net.brendanmccall.beximitesmagic.block.ModBlocks.oreTypes
import net.brendanmccall.beximitesmagic.item.ModItems
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalItem
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalShardItem
import net.brendanmccall.beximitesmagic.item.ModItems.getSoulItem
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
        oreTypes.drop(1).forEach { oreType ->
            elements.drop(2).forEach { oreElement ->
                blockStateModelGenerator.registerSimpleCubeAll(getOreBlock(oreType, oreElement))
            }
        }

        // Unused blocks
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.custom_block) // Custom block
        /*blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.dahlia, ModBlocks.potted_dahlia,
            BlockStateModelGenerator.TintType.NOT_TINTED)*/ // Flower block
    }

    // Generate model json files for items
    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        // Crystal items
        itemModelGenerator.register(ModItems.crystal, Models.GENERATED)
        elements.drop(1).forEach { crystalElement ->
            itemModelGenerator.register(getCrystalItem(crystalElement), Models.GENERATED)
        }
        // Crystal shard items & soul items
        elements.drop(2).forEach { crystalElement ->
            itemModelGenerator.register(getCrystalShardItem(crystalElement), Models.GENERATED)
            itemModelGenerator.register(getSoulItem(crystalElement), Models.GENERATED)
        }

        // Unused items
        //itemModelGenerator.register(ModItems.custom_item, Models.GENERATED) // Custom item
        //itemModelGenerator.register(ModItems.tomato, Models.GENERATED) // Food item
        //itemModelGenerator.register(ModItems.coal_briquette, Models.GENERATED) // Fuel item
        //itemModelGenerator.registerArmor(ModItems.ruby_helmet as ArmorItem) // Helmet item
        //itemModelGenerator.registerArmor(ModItems.ruby_chestplate as ArmorItem) // Chestplate item
        //itemModelGenerator.registerArmor(ModItems.ruby_leggings as ArmorItem) // Leggings item
        //itemModelGenerator.registerArmor(ModItems.ruby_boots as ArmorItem) // Boots item
        //itemModelGenerator.register(ModItems.bar_brawl_music_disk, Models.GENERATED) // Music disk item
    }
}