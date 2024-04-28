package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks
import net.brendanmccall.beximitesmagic.item.ModItems.getCrystalShardItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.data.server.loottable.BlockLootTableGenerator
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider

class ModLootTableProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {

    // Helper function to create copper-like ore
    fun copperLikeOreDrops(drop: Block, item: Item?): LootTable.Builder {
        return BlockLootTableGenerator.dropsWithSilkTouch(
            drop,
            this.applyExplosionDecay(
                drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
            ).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
        )
    }

    // Generate loot table json files
    override fun generate() {
        addDrop(ModBlocks.water_crystal_ore,
            copperLikeOreDrops(ModBlocks.water_crystal_ore, getCrystalShardItem("water")))
    }
}