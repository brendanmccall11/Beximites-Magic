package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
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
            .icon { ItemStack(ModItems.STAFF) }
            .entries { _, entries ->
                // Adding items to creative mode group
                entries.add(ModItems.STAFF)

            }
            .build()
    )
}
