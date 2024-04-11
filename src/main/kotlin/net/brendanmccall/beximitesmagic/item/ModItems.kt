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
        registerStaffItems();
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(BeximitesMagic.mod_id, name), item);
    }

    // Initialize map for staffs
    public val staffTypes = listOf("wood", "iron", "diamond", "netherite")
    public val staffColors = listOf("", "white", "blue", "turquoise", "green", "red", "yellow", "gold", "orange", "gray", "purple", "pink", "black")
    public val staffItems: MutableMap<String, Item> = mutableMapOf()

    // Registering Items
    fun registerStaffItems()
    {
        staffTypes.forEach() { staffType ->
            staffColors.forEach { color ->
                val name = "staff_${staffType}${if (color.isNotEmpty()) "_$color" else ""}"
                staffItems[name] = registerItem(name, Item(FabricItemSettings().maxCount(1)))
            }
        }
    }
    val shard_fire: Item = registerItem("shard_fire", Item(FabricItemSettings()));
}