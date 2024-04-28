package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks.getOreBlock
import net.brendanmccall.beximitesmagic.item.ModItems.elements
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

    // Helper functions to create copper-like ore
    fun copperLikeOreDrops(drop: Block?, item: Item?, lowerDrop: Float, upperDrop: Float): LootTable.Builder {
        return BlockLootTableGenerator.dropsWithSilkTouch(
            drop,
            this.applyExplosionDecay(
                drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(lowerDrop, upperDrop)))
            ).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
        )
    }

    // Generate loot table json files
    override fun generate() {
        // Ore blocks
        elements.drop(2).forEach { oreElement ->
            addDrop(
                getOreBlock(null, oreElement),
                copperLikeOreDrops(getOreBlock(null, oreElement),
                    getCrystalShardItem(oreElement), 1.0f, 2.0f))
        }
        elements.drop(2).forEach { oreElement ->
            addDrop(
                getOreBlock("deepslate", oreElement),
                copperLikeOreDrops(getOreBlock("deepslate", oreElement),
                    getCrystalShardItem(oreElement), 1.0f, 2.0f))
        }
        elements.drop(2).forEach { oreElement ->
            addDrop(
                getOreBlock("nether", oreElement),
                copperLikeOreDrops(getOreBlock("nether", oreElement),
                    getCrystalShardItem(oreElement), 2.0f, 3.0f))
        }
        elements.drop(2).forEach { oreElement ->
            addDrop(
                getOreBlock("end", oreElement),
                copperLikeOreDrops(getOreBlock("end", oreElement),
                    getCrystalShardItem(oreElement), 3.0f, 4.0f))
        }
    }
}