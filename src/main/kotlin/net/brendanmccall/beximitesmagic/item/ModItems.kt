package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {

    fun registerModItems() {
        BeximitesMagic.logger.info("Registering Mod Items for ${BeximitesMagic.modID}")

        registerStaffItems()
        registerCrystalShardItems()
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.modID, name), item)
    }

    // Initialize map and lists for staffs, crystals, crystal shards
    public val materials = listOf("", "iron", "diamond", "netherite")
    public val elements = listOf("", "standard", "water", "ice", "terra", "fire",
        "electric", "mind", "chaos", "order", "spacetime", "life", "death")
    public val staffItems: MutableMap<String, Item> = mutableMapOf()
    public val crystalShardItems: MutableMap<String, Item> = mutableMapOf()

    // Helper functions for getting items from maps
    fun getStaffItem(material: String?, element: String?): Item? {
        if (material != null && element != null) {
            return ModItems.staffItems["${material}_${element}_staff"]
        }
        else if (material != null && element == null) {
            return ModItems.staffItems["${material}_staff"]
        }
        else {
            return ModItems.staffItems["staff"]
        }
    }
    fun getCrystalShardItem(element: String): Item? {
        return ModItems.crystalShardItems["${element}_crystal_shard"]
    }

    // Registering Items
    fun registerStaffItems() {
        materials.forEach { staffMaterial ->
            elements.forEach { staffElement ->
                val name = "${if (staffMaterial.isNotEmpty()) "$staffMaterial" + "_" else ""}" +
                        "${if (staffElement.isNotEmpty()) "$staffElement" + "_" else ""}staff"
                staffItems[name] = registerItem(name, Item(FabricItemSettings().maxCount(1)))
            }
        }
    }
    fun registerCrystalShardItems() {
        elements.drop(2).forEach { crystalElement ->
            val name = "$crystalElement" + "_" + "crystal_shard"
            crystalShardItems[name] = registerItem(name, Item(FabricItemSettings()))
        }
    }
}