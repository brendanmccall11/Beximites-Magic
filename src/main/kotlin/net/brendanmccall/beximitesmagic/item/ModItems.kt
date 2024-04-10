package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {

    fun registerModItems() {
        BeximitesMagic.logger.info("Registering Mod Items for ${BeximitesMagic.mod_id}");
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.mod_id, name), item);
    }

    // Registering Items
    val STAFF_WOOD: Item = registerItem("staff_wood", Item(FabricItemSettings()));
    val STAFF_WOOD_WHITE: Item = registerItem("staff_wood_white", Item(FabricItemSettings()));
    val STAFF_WOOD_BLUE: Item = registerItem("staff_wood_blue", Item(FabricItemSettings()));
    val STAFF_WOOD_TURQUOISE: Item = registerItem("staff_wood_turquoise", Item(FabricItemSettings()));
    val STAFF_WOOD_GREEN: Item = registerItem("staff_wood_green", Item(FabricItemSettings()));
    val STAFF_WOOD_RED: Item = registerItem("staff_wood_red", Item(FabricItemSettings()));
    val STAFF_WOOD_YELLOW: Item = registerItem("staff_wood_yellow", Item(FabricItemSettings()));
    val STAFF_WOOD_GOLD: Item = registerItem("staff_wood_gold", Item(FabricItemSettings()));
    val STAFF_WOOD_ORANGE: Item = registerItem("staff_wood_orange", Item(FabricItemSettings()));
    val STAFF_WOOD_GRAY: Item = registerItem("staff_wood_gray", Item(FabricItemSettings()));
    val STAFF_WOOD_PURPLE: Item = registerItem("staff_wood_purple", Item(FabricItemSettings()));
    val STAFF_WOOD_PINK: Item = registerItem("staff_wood_pink", Item(FabricItemSettings()));
    val STAFF_WOOD_BLACK: Item = registerItem("staff_wood_black", Item(FabricItemSettings()));
    val STAFF_IRON: Item = registerItem("staff_iron", Item(FabricItemSettings()));
    val STAFF_IRON_WHITE: Item = registerItem("staff_iron_white", Item(FabricItemSettings()));
    val STAFF_IRON_BLUE: Item = registerItem("staff_iron_blue", Item(FabricItemSettings()));
    val STAFF_IRON_TURQUOISE: Item = registerItem("staff_iron_turquoise", Item(FabricItemSettings()));
    val STAFF_IRON_GREEN: Item = registerItem("staff_iron_green", Item(FabricItemSettings()));
    val STAFF_IRON_RED: Item = registerItem("staff_iron_red", Item(FabricItemSettings()));
    val STAFF_IRON_YELLOW: Item = registerItem("staff_iron_yellow", Item(FabricItemSettings()));
    val STAFF_IRON_GOLD: Item = registerItem("staff_iron_gold", Item(FabricItemSettings()));
    val STAFF_IRON_ORANGE: Item = registerItem("staff_iron_orange", Item(FabricItemSettings()));
    val STAFF_IRON_GRAY: Item = registerItem("staff_iron_gray", Item(FabricItemSettings()));
    val STAFF_IRON_PURPLE: Item = registerItem("staff_iron_purple", Item(FabricItemSettings()));
    val STAFF_IRON_PINK: Item = registerItem("staff_iron_pink", Item(FabricItemSettings()));
    val STAFF_IRON_BLACK: Item = registerItem("staff_iron_black", Item(FabricItemSettings()));
    val STAFF_DIAMOND: Item = registerItem("staff_diamond", Item(FabricItemSettings()));
    val STAFF_DIAMOND_WHITE: Item = registerItem("staff_diamond_white", Item(FabricItemSettings()));
    val STAFF_DIAMOND_BLUE: Item = registerItem("staff_diamond_blue", Item(FabricItemSettings()));
    val STAFF_DIAMOND_TURQUOISE: Item = registerItem("staff_diamond_turquoise", Item(FabricItemSettings()));
    val STAFF_DIAMOND_GREEN: Item = registerItem("staff_diamond_green", Item(FabricItemSettings()));
    val STAFF_DIAMOND_RED: Item = registerItem("staff_diamond_red", Item(FabricItemSettings()));
    val STAFF_DIAMOND_YELLOW: Item = registerItem("staff_diamond_yellow", Item(FabricItemSettings()));
    val STAFF_DIAMOND_GOLD: Item = registerItem("staff_diamond_gold", Item(FabricItemSettings()));
    val STAFF_DIAMOND_ORANGE: Item = registerItem("staff_diamond_orange", Item(FabricItemSettings()));
    val STAFF_DIAMOND_GRAY: Item = registerItem("staff_diamond_gray", Item(FabricItemSettings()));
    val STAFF_DIAMOND_PURPLE: Item = registerItem("staff_diamond_purple", Item(FabricItemSettings()));
    val STAFF_DIAMOND_PINK: Item = registerItem("staff_diamond_pink", Item(FabricItemSettings()));
    val STAFF_DIAMOND_BLACK: Item = registerItem("staff_diamond_black", Item(FabricItemSettings()));
    val STAFF_NETHERITE: Item = registerItem("staff_netherite", Item(FabricItemSettings()));
    val STAFF_NETHERITE_WHITE: Item = registerItem("staff_netherite_white", Item(FabricItemSettings()));
    val STAFF_NETHERITE_BLUE: Item = registerItem("staff_netherite_blue", Item(FabricItemSettings()));
    val STAFF_NETHERITE_TURQUOISE: Item = registerItem("staff_netherite_turquoise", Item(FabricItemSettings()));
    val STAFF_NETHERITE_GREEN: Item = registerItem("staff_netherite_green", Item(FabricItemSettings()));
    val STAFF_NETHERITE_RED: Item = registerItem("staff_netherite_red", Item(FabricItemSettings()));
    val STAFF_NETHERITE_YELLOW: Item = registerItem("staff_netherite_yellow", Item(FabricItemSettings()));
    val STAFF_NETHERITE_GOLD: Item = registerItem("staff_netherite_gold", Item(FabricItemSettings()));
    val STAFF_NETHERITE_ORANGE: Item = registerItem("staff_netherite_orange", Item(FabricItemSettings()));
    val STAFF_NETHERITE_GRAY: Item = registerItem("staff_netherite_gray", Item(FabricItemSettings()));
    val STAFF_NETHERITE_PURPLE: Item = registerItem("staff_netherite_purple", Item(FabricItemSettings()));
    val STAFF_NETHERITE_PINK: Item = registerItem("staff_netherite_pink", Item(FabricItemSettings()));
    val STAFF_NETHERITE_BLACK: Item = registerItem("staff_netherite_black", Item(FabricItemSettings()));
}