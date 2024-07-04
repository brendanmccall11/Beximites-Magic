package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.effect.ModStatusEffects
import net.brendanmccall.beximitesmagic.item.custom.SoulItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {

    fun registerModItems() {
        BeximitesMagic.logger.info("Registering Mod Items for ${BeximitesMagic.modID}")

        registerStaffItems()
        registerCrystalItems()
        registerCrystalShardItems()
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.modID, name), item)
    }

    // Initialize maps and lists for staffs, crystals, crystal shards
    val materials = listOf("", "iron", "diamond", "netherite")
    val elements = listOf("", "standard", "water", "ice", "terra", "fire",
        "mind", "chaos", "order", "spacetime", "life", "death")
    val staffItems: MutableMap<String, Item> = mutableMapOf()
    val crystalItems: MutableMap<String, Item> = mutableMapOf()
    val crystalShardItems: MutableMap<String, Item> = mutableMapOf()

    // Helper functions for getting items from maps
    fun getStaffItem(material: String?, element: String?): Item? {
        return if (material != null && element != null) {
            staffItems["${material}_${element}_staff"]
        }
        else if (material != null) {
            staffItems["${material}_staff"]
        }
        else if (element != null) {
            staffItems["${element}_staff"]
        }
        else {
            staffItems["staff"]
        }
    }
    fun getCrystalItem(element: String): Item? {
        return crystalItems["${element}_crystal"]
    }
    fun getCrystalShardItem(element: String): Item? {
        return crystalShardItems["${element}_crystal_shard"]
    }

    // Registering Items
    private fun registerStaffItems() {
        materials.forEach { staffMaterial ->
            elements.forEach { staffElement ->
                val name = "${if (staffMaterial.isNotEmpty()) "$staffMaterial" + "_" else ""}" +
                        "${if (staffElement.isNotEmpty()) "$staffElement" + "_" else ""}staff"
                staffItems[name] = registerItem(name, Item(FabricItemSettings().maxCount(1)))
            }
        }
    }
    val crystal: Item = registerItem("crystal", Item(FabricItemSettings()))
    private fun registerCrystalItems() {
        elements.drop(2).forEach { crystalElement ->
            val name = "$crystalElement" + "_" + "crystal"
            crystalItems[name] = registerItem(name, Item(FabricItemSettings()))
        }
    }
    private fun registerCrystalShardItems() {
        elements.drop(2).forEach { crystalElement ->
            val name = "$crystalElement" + "_" + "crystal_shard"
            crystalShardItems[name] = registerItem(name, Item(FabricItemSettings()))
        }
    }
    val water_soul: Item = registerItem("water_soul", SoulItem(FabricItemSettings(),
        ModStatusEffects.water_soul_effect))

    // Registering unused items
    //val custom_item: Item = registerItem("custom_item", CustomItem(FabricItemSettings())) // Custom item
    /*val tomato: Item = registerItem("tomato", Item(FabricItemSettings().
        food(ModFoodComponents.tomato)))*/ // Food item
    //val coal_briquette: Item = registerItem("coal_briquette", Item(FabricItemSettings())) // Fuel item
}