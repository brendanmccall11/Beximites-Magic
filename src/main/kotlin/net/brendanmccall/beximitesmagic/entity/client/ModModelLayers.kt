package net.brendanmccall.beximitesmagic.entity.client

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier

class ModModelLayers {

    companion object{
        //val porcupine: EntityModelLayer = EntityModelLayer(Identifier.of(BeximitesMagic.modID, "porcupine"), "main")
        val deer: EntityModelLayer = EntityModelLayer(Identifier.of(BeximitesMagic.modID, "deer"), "main")
    }
}