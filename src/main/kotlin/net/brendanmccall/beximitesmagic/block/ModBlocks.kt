package net.brendanmccall.beximitesmagic.block

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.minecraft.block.AbstractBlock
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
        return Registry.register(Registries.ITEM, Identifier.of(BeximitesMagic.modID, name),
            BlockItem(block, Item.Settings()))
    }

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier.of(BeximitesMagic.modID, name), block)
    }

    // Initialize maps and lists for ore blocks
    val oreTypes = listOf("", "deepslate", "netherrack", "end_stone")
    val oreBlocks: MutableMap<String, Block> = mutableMapOf()

    // Helper functions for getting blocks from maps
    fun getOreBlock(oreType: String?, element: String): Block? {
        return if (oreType != null) {
            oreBlocks["${oreType}_${element}_crystal_ore"]
        } else {
            oreBlocks["${element}_crystal_ore"]
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
                        AbstractBlock.Settings.copy(Blocks.STONE)
                            .strength(3.5f)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)))
            }
        }
    }

    // Registering unused blocks
    /*val custom_block: Block = registerBlock("custom_block",
        CustomBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).
        sounds(ModSounds.custom_block_sounds)))*/ // Custom block & custom sounds
    /*val dahlia: Block = registerBlock("dahlia", FlowerBlock(StatusEffects.FIRE_RESISTANCE, 20,
        FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()))*/ // Flower block
    /*val potted_dahlia: Block = Registry.register(Registries.BLOCK,
        Identifier(BeximitesMagic.modID, "potted_dahlia"),
        FlowerPotBlock(dahlia, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()))*/ // Potted flower block
}