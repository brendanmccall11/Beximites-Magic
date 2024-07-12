package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.effect.ModStatusEffects.getSoulEffect
import net.brendanmccall.beximitesmagic.item.custom.SoulItem
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
        registerSoulItems()
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of(BeximitesMagic.modID, name), item)
    }

    // Initialize maps and lists for staffs, crystals, crystal shards
    val materials = listOf("", "iron", "diamond", "netherite")
    val elements = listOf("", "standard", "water", "ice", "terra", "fire",
        "mind", "chaos", "order", "spacetime", "life", "death")
    val staffItems: MutableMap<String, Item> = mutableMapOf()
    val crystalItems: MutableMap<String, Item> = mutableMapOf()
    val crystalShardItems: MutableMap<String, Item> = mutableMapOf()
    val soulItems: MutableMap<String, Item> = mutableMapOf()

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
    fun getSoulItem(element: String): Item? {
        return soulItems["${element}_soul"]
    }

    // Registering items
    private fun registerStaffItems() {
        materials.forEach { staffMaterial ->
            elements.forEach { staffElement ->
                val name = (if (staffMaterial.isNotEmpty()) staffMaterial + "_" else "") +
                        "${if (staffElement.isNotEmpty()) staffElement + "_" else ""}staff"
                staffItems[name] = registerItem(name, Item(Item.Settings().maxCount(1)))
            }
        }
    }
    val crystal: Item = registerItem("crystal", Item(Item.Settings()))
    private fun registerCrystalItems() {
        elements.drop(2).forEach { crystalElement ->
            val name = "${crystalElement}_crystal"
            crystalItems[name] = registerItem(name, Item(Item.Settings()))
        }
    }
    private fun registerCrystalShardItems() {
        elements.drop(2).forEach { crystalElement ->
            val name = "${crystalElement}_crystal_shard"
            crystalShardItems[name] = registerItem(name, Item(Item.Settings()))
        }
    }
    private fun registerSoulItems() {
        elements.drop(2).forEach { crystalElement ->
            val name = "${crystalElement}_soul"
            soulItems[name] = registerItem(name, SoulItem(Item.Settings(), getSoulEffect(crystalElement)))
        }
    }

    // Registering unused items
    //val custom_item: Item = registerItem("custom_item", CustomItem(FabricItemSettings())) // Custom item
    /*val tomato: Item = registerItem("tomato", Item(FabricItemSettings().
        food(ModFoodComponents.tomato)))*/ // Food item
    //val coal_briquette: Item = registerItem("coal_briquette", Item(FabricItemSettings())) // Fuel item
    /*val ruby_helmet = registerItem("ruby_helmet",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, FabricItemSettings()))*/ // Helmet item
    /*val ruby_chestplate = registerItem("ruby_chestplate",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))*/ // Chestplate item
    /*val ruby_leggings = registerItem("ruby_leggings",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, FabricItemSettings()))*/ // Leggings item
    /*val ruby_boots = registerItem("ruby_boots",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, FabricItemSettings()))*/ // Boots item
    /*val bar_brawl_music_disk: Item = registerItem("bar_brawl_music_disk",
        MusicDiscItem(7, ModSounds.bar_brawl,
            FabricItemSettings().maxCount(1), 122))*/ // Music disk item
    /*val porcupine_spawn_egg: Item = registerItem("porcupine_spawn_egg",
        SpawnEggItem(ModEntities.porcupine,
            0xa86518, 0x3b260f, Item.Settings()))*/ // Spawn egg item
}