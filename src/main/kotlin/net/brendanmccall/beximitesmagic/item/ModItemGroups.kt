package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.item.ModItems.registerItem
import net.brendanmccall.beximitesmagic.item.ModItems.staffColors
import net.brendanmccall.beximitesmagic.item.ModItems.staffItems
import net.brendanmccall.beximitesmagic.item.ModItems.staffTypes
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {

    fun registerModItemGroups() {
        BeximitesMagic.logger.info("Registering Item Groups for ${BeximitesMagic.mod_id}")
    }

    val BEXIMITES_MAGIC_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(BeximitesMagic.mod_id, "beximitesmagic"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.beximitesmagic"))
            .icon { ItemStack(ModItems.staffItems["staff_wood"]) }
            .entries { _, entries ->
                // Adding items to creative mode group
                staffItems.values.forEach { item ->
                    entries.add(item)
                }
                entries.add(ModItems.shard_water)
                entries.add(ModItems.shard_fire)

            }
            .build()
    )
}
