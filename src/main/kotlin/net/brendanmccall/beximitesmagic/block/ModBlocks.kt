package net.brendanmccall.beximitesmagic.block

import net.brendanmccall.beximitesmagic.BeximitesMagic
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
    }

    fun registerBlockItem(name: String, block: Block): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.modID, name),
            BlockItem(block, FabricItemSettings()))
    }

    fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(BeximitesMagic.modID, name), block)
    }

    val water_crystal_ore: Block =  registerBlock("water_crystal_ore",
        ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
            FabricBlockSettings.copyOf(Blocks.STONE).strength(3.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK)))
}