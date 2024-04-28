package net.brendanmccall.beximitesmagic.block

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

object ModBlocks {

    fun registerModBlocks() {
        BeximitesMagic.logger.info("Registering Mod Blocks for ${BeximitesMagic.modID}")

        registerOreBlocks()
    }

    private fun registerBlockItem(name: String, block: Block): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.modID, name),
            BlockItem(block, FabricItemSettings()))
    }

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(BeximitesMagic.modID, name), block)
    }

    // Initialize maps and lists for ore blocks
    private val oreTypes = listOf("", "deepslate", "nether", "end")
    val oreBlocks: MutableMap<String, Block> = mutableMapOf()

    // Helper functions for getting blocks from maps
    fun getOreBlock(oreType: String?, element: String): Block? {
        return if (oreType != null) {
            ModBlocks.oreBlocks["${oreType}_${element}_crystal_ore"]
        } else {
            ModBlocks.oreBlocks["${element}_crystal_ore"]
        }
    }

    // Registering blocks
    private fun registerOreBlocks() {
        oreTypes.forEach { oreType ->
            elements.drop(2).forEach { oreElement ->
                val name = (if (oreType.isNotEmpty()) oreType + "_" else "") +
                        "${oreElement}_crystal_ore"
                oreBlocks[name] = registerBlock(name,
                    ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                        FabricBlockSettings.copyOf(Blocks.STONE)
                            .strength(3.5f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)))
            }
        }
    }
}