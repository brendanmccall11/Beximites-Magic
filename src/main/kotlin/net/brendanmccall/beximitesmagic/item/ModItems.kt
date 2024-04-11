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
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.modID, name), item)
    }

    // Initialize map for staffs
    public val staffMaterials = listOf("", "iron", "diamond", "netherite")
    public val staffElements = listOf("", "standard", "water", "ice", "terra", "fire",
        "electric", "mind", "chaos", "order", "spacetime", "life", "death")
    public val staffItems: MutableMap<String, Item> = mutableMapOf()

    // Registering Items
    fun registerStaffItems()
    {
        staffMaterials.forEach() { staffMaterial ->
            staffElements.forEach { staffElement ->
                val name = "${if (staffMaterial.isNotEmpty()) "$staffMaterial" + "_" else ""}" +
                        "${if (staffElement.isNotEmpty()) "$staffElement" + "_" else ""}staff"
                staffItems[name] = registerItem(name, Item(FabricItemSettings().maxCount(1)))
            }
        }
    }
    val water_crystal_shard: Item = registerItem("water_crystal_shard", Item(FabricItemSettings()))
    val fire_crystal_shard: Item = registerItem("fire_crystal_shard", Item(FabricItemSettings()))
}