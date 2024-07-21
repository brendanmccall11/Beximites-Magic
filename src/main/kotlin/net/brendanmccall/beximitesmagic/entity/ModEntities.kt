package net.brendanmccall.beximitesmagic.entity

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.entity.custom.DeerEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModEntities {

    fun registerModEntities() {
        BeximitesMagic.logger.info("Registering Mod Entities for ${BeximitesMagic.modID}")

        //FabricDefaultAttributeRegistry.register(porcupine, PorcupineEntity.createPorcupineAttributes())
        FabricDefaultAttributeRegistry.register(deer, DeerEntity.createPorcupineAttributes())
    }

    /*val porcupine: EntityType<PorcupineEntity> = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(BeximitesMagic.modID, "porcupine"),
        EntityType.Builder.create(::PorcupineEntity, SpawnGroup.CREATURE).dimensions(1.0f, 1.0f).build())*/
    val deer: EntityType<DeerEntity> = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(BeximitesMagic.modID, "deer"),
        EntityType.Builder.create(::DeerEntity, SpawnGroup.CREATURE).dimensions(0.8f, 2.0f).build())
}