package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.block.ModBlocks.oreBlocks
import net.brendanmccall.beximitesmagic.item.ModItems.crystalItems
import net.brendanmccall.beximitesmagic.item.ModItems.crystalShardItems
import net.brendanmccall.beximitesmagic.item.ModItems.soulItems
import net.brendanmccall.beximitesmagic.item.ModItems.staffItems
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {

    fun registerModItemGroups() {
        BeximitesMagic.logger.info("Registering Item Groups for ${BeximitesMagic.modID}")
    }

    val beximites_magic_group: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(BeximitesMagic.modID, BeximitesMagic.modID),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.beximitesmagic"))
            .icon { ItemStack(staffItems["staff"]) }
            .entries { _, entries ->
                // Adding items to creative mode group
                staffItems.values.forEach { item ->
                    entries.add(item)
                }
                entries.add(ModItems.crystal)
                crystalItems.values.forEach { item ->
                    entries.add(item)
                }
                crystalShardItems.values.forEach { item ->
                    entries.add(item)
                }
                oreBlocks.values.forEach { block ->
                    entries.add(block)
                }
                soulItems.values.forEach { item ->
                    entries.add(item)
                }

                // Unused items/blocks
                //entries.add(ModItems.custom_item) // Custom item
                //entries.add(ModBlocks.custom_block) // Custom block
                //entries.add(ModItems.tomato) // Food item
                //entries.add(ModItems.coal_briquette) // Fuel item
                //entries.add(ModItems.ruby_helmet) // Helmet item
                //entries.add(ModItems.ruby_chestplate) // Chestplate item
                //entries.add(ModItems.ruby_leggings) // Leggings item
                //entries.add(ModItems.ruby_boots) // Boots item
                //entries.add(ModBlocks.dahlia) // Flower block
                //entries.add(ModItems.bar_brawl_music_disk) // Music disk item
            }
            .build()
    )
}
