package net.brendanmccall.beximitesmagic.util

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object ModTags {
    object Items {
        private fun createTag(name: String): TagKey<Item> {
            return TagKey.of(RegistryKeys.ITEM, Identifier(BeximitesMagic.modID, name))
        }
    }

    object Blocks {
        private fun createTag(name: String): TagKey<Block> {
            return TagKey.of(RegistryKeys.BLOCK, Identifier(BeximitesMagic.modID, name))
        }
    }
}
