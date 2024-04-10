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
            .icon { ItemStack(ModItems.STAFF_WOOD) }
            .entries { _, entries ->
                // Adding items to creative mode group
                entries.add(ModItems.STAFF_WOOD)
                entries.add(ModItems.STAFF_WOOD_WHITE);
                entries.add(ModItems.STAFF_WOOD_BLUE);
                entries.add(ModItems.STAFF_WOOD_TURQUOISE);
                entries.add(ModItems.STAFF_WOOD_GREEN);
                entries.add(ModItems.STAFF_WOOD_RED);
                entries.add(ModItems.STAFF_WOOD_YELLOW);
                entries.add(ModItems.STAFF_WOOD_GOLD);
                entries.add(ModItems.STAFF_WOOD_ORANGE);
                entries.add(ModItems.STAFF_WOOD_GRAY);
                entries.add(ModItems.STAFF_WOOD_PURPLE);
                entries.add(ModItems.STAFF_WOOD_PINK);
                entries.add(ModItems.STAFF_WOOD_BLACK);
                entries.add(ModItems.STAFF_IRON)
                entries.add(ModItems.STAFF_IRON_WHITE);
                entries.add(ModItems.STAFF_IRON_BLUE);
                entries.add(ModItems.STAFF_IRON_TURQUOISE);
                entries.add(ModItems.STAFF_IRON_GREEN);
                entries.add(ModItems.STAFF_IRON_RED);
                entries.add(ModItems.STAFF_IRON_YELLOW);
                entries.add(ModItems.STAFF_IRON_GOLD);
                entries.add(ModItems.STAFF_IRON_ORANGE);
                entries.add(ModItems.STAFF_IRON_GRAY);
                entries.add(ModItems.STAFF_IRON_PURPLE);
                entries.add(ModItems.STAFF_IRON_PINK);
                entries.add(ModItems.STAFF_IRON_BLACK);
                entries.add(ModItems.STAFF_DIAMOND)
                entries.add(ModItems.STAFF_DIAMOND_WHITE);
                entries.add(ModItems.STAFF_DIAMOND_BLUE);
                entries.add(ModItems.STAFF_DIAMOND_TURQUOISE);
                entries.add(ModItems.STAFF_DIAMOND_GREEN);
                entries.add(ModItems.STAFF_DIAMOND_RED);
                entries.add(ModItems.STAFF_DIAMOND_YELLOW);
                entries.add(ModItems.STAFF_DIAMOND_GOLD);
                entries.add(ModItems.STAFF_DIAMOND_ORANGE);
                entries.add(ModItems.STAFF_DIAMOND_GRAY);
                entries.add(ModItems.STAFF_DIAMOND_PURPLE);
                entries.add(ModItems.STAFF_DIAMOND_PINK);
                entries.add(ModItems.STAFF_DIAMOND_BLACK);
                entries.add(ModItems.STAFF_NETHERITE)
                entries.add(ModItems.STAFF_NETHERITE_WHITE);
                entries.add(ModItems.STAFF_NETHERITE_BLUE);
                entries.add(ModItems.STAFF_NETHERITE_TURQUOISE);
                entries.add(ModItems.STAFF_NETHERITE_GREEN);
                entries.add(ModItems.STAFF_NETHERITE_RED);
                entries.add(ModItems.STAFF_NETHERITE_YELLOW);
                entries.add(ModItems.STAFF_NETHERITE_GOLD);
                entries.add(ModItems.STAFF_NETHERITE_ORANGE);
                entries.add(ModItems.STAFF_NETHERITE_GRAY);
                entries.add(ModItems.STAFF_NETHERITE_PURPLE);
                entries.add(ModItems.STAFF_NETHERITE_PINK);
                entries.add(ModItems.STAFF_NETHERITE_BLACK);

            }
            .build()
    )
}
