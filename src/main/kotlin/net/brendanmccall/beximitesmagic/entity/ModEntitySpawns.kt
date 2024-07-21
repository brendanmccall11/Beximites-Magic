package net.brendanmccall.beximitesmagic.entity

import net.brendanmccall.beximitesmagic.BeximitesMagic
/*import net.brendanmccall.beximitesmagic.entity.custom.DeerEntity
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.SpawnLocationTypes
import net.minecraft.entity.SpawnRestriction
import net.minecraft.world.Heightmap
import net.minecraft.world.biome.BiomeKeys*/

object ModEntitySpawns {

    fun registerEntitySpawns() {
        BeximitesMagic.logger.info("Registering Mod Entity Spawns for ${BeximitesMagic.modID}")

        //registerDeerSpawns
    }

    /*object registerDeerSpawns {
        fun registerDeerSpawn(){
            SpawnRestriction.register(
                ModEntities.deer,
                SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                DeerEntity::canSpawn
            )

            BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.BIRCH_FOREST),
                SpawnGroup.CREATURE,
                ModEntities.deer,
                10,
                1,
                3
            )
        }
    }*/
}
