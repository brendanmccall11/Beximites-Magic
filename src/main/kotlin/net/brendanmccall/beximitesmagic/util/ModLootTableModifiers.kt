package net.brendanmccall.beximitesmagic.util

/*import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.brendanmccall.beximitesmagic.item.ModItems
import net.minecraft.loot.LootPool
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.Identifier*/

// TUTORIAL FOR MODIFYING VANILLA LOOT TABLES
object ModLootTableModifiers {
    /*private val JUNGLE_TEMPLE_ID = Identifier("minecraft", "chests/jungle_temple")
    private val CREEPER_ID = Identifier("minecraft", "entities/creeper")

    fun modifyLootTables() {
        LootTableEvents.MODIFY.register { resourceManager, lootManager, id, tableBuilder, source ->
            when (id) {
                JUNGLE_TEMPLE_ID -> {
                    val poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.crystal))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                    tableBuilder.pool(poolBuilder.build())
                }
                CREEPER_ID -> {
                    val poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.getStaffItem(null, null)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                    tableBuilder.pool(poolBuilder.build())
                }
            }
        }
    }*/
}