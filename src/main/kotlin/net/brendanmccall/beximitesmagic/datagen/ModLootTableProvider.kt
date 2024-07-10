package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks.getOreBlock
import net.brendanmccall.beximitesmagic.block.ModBlocks.oreTypes
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

    // Helper function to create copper-like ore
    private fun copperLikeOreDrops(drop: Block?, item: Item?, lowerDrop: Float, upperDrop: Float): LootTable.Builder {
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
        // 0-1 drops
        elements.forEachIndexed { i, oreElement ->
            if (i in 2..3) {
                addDrop(
                    getOreBlock("netherrack", oreElement),
                    copperLikeOreDrops(getOreBlock("netherrack", oreElement),
                        getCrystalShardItem(oreElement), 0.0f, 1.0f))
            }
            if (i in 4..5) {
                addDrop(
                    getOreBlock("end_stone", oreElement),
                    copperLikeOreDrops(getOreBlock("end_stone", oreElement),
                        getCrystalShardItem(oreElement), 0.0f, 1.0f))
            }
        }
        addDrop(
            getOreBlock("netherrack", "spacetime"),
            copperLikeOreDrops(getOreBlock("netherrack", "spacetime"),
                getCrystalShardItem("spacetime"), 0.0f, 1.0f))
        // 1 drop
        elements.forEachIndexed { i, oreElement ->
            if (i in 2..3) {
                addDrop(
                    getOreBlock("end_stone", oreElement),
                    copperLikeOreDrops(getOreBlock("end_stone", oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 1.0f))
            }
            if (i == 4) {
                addDrop(
                    getOreBlock("netherrack", oreElement),
                    copperLikeOreDrops(getOreBlock("netherrack", oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 1.0f))
            }
            if ((i == 5) || (i == 9)) {
                addDrop(
                    getOreBlock(null, oreElement),
                    copperLikeOreDrops(getOreBlock(null, oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 1.0f))
                addDrop(
                    getOreBlock("deepslate", oreElement),
                    copperLikeOreDrops(getOreBlock("deepslate", oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 1.0f))
            }
            if ((i in 6 .. 8) || (i in  10 .. 11)) {
                addDrop(
                    getOreBlock(null, oreElement),
                    copperLikeOreDrops(getOreBlock(null, oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 1.0f))
                oreTypes.drop(1).forEach { oreType ->
                    addDrop(
                        getOreBlock(oreType, oreElement),
                        copperLikeOreDrops(getOreBlock(oreType, oreElement),
                            getCrystalShardItem(oreElement), 1.0f, 1.0f))
                }
            }
        }
        // 1-2 drops
        elements.forEachIndexed { i, oreElement ->
            if (i in 2..4) {
                addDrop(
                    getOreBlock(null, oreElement),
                    copperLikeOreDrops(getOreBlock(null, oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 2.0f))
                addDrop(
                    getOreBlock("deepslate", oreElement),
                    copperLikeOreDrops(getOreBlock("deepslate", oreElement),
                        getCrystalShardItem(oreElement), 1.0f, 2.0f))
            }
        }
        addDrop(
            getOreBlock("netherrack", "fire"),
            copperLikeOreDrops(getOreBlock("deepslate", "fire"),
                getCrystalShardItem("fire"), 1.0f, 2.0f))
        addDrop(
            getOreBlock("end_stone", "spacetime"),
            copperLikeOreDrops(getOreBlock("end_stone", "spacetime"),
                getCrystalShardItem("spacetime"), 1.0f, 2.0f))

        // Unused loot tables
        //addDrop(ModBlocks.dahlia) // Flower block
        //addPottedPlantDrops(ModBlocks.potted_dahlia) // Potted flower block
    }
}