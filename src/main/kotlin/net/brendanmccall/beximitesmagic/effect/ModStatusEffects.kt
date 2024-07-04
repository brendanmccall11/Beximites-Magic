package net.brendanmccall.beximitesmagic.effect

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModStatusEffects {

    fun registerModStatusEffects() {
        BeximitesMagic.logger.info("Registering Mod Status Effects for ${BeximitesMagic.modID}")
    }

    @JvmField
    val water_soul_effect = Registry.register(Registries.STATUS_EFFECT,
        Identifier("beximitesmagic", "water_soul_effect"),
        WaterSoulEffect())
}