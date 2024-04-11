package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.item.ModItems.registerItem
import net.brendanmccall.beximitesmagic.item.ModItems.staffElements
import net.brendanmccall.beximitesmagic.item.ModItems.staffItems
import net.brendanmccall.beximitesmagic.item.ModItems.staffMaterials
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
        BeximitesMagic.logger.info("Registering Item Groups for ${BeximitesMagic.modID}")
    }

    val BEXIMITES_MAGIC_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(BeximitesMagic.modID, "beximitesmagic"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.beximitesmagic"))
            .icon { ItemStack(ModItems.staffItems["staff"]) }
            .entries { _, entries ->
                // Adding items to creative mode group
                staffItems.values.forEach { item ->
                    entries.add(item)
                }
                entries.add(ModItems.water_crystal_shard)
                entries.add(ModItems.fire_crystal_shard)
            }
            .build()
    )
}
