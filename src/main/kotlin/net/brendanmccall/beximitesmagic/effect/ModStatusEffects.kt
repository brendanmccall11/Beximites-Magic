package net.brendanmccall.beximitesmagic.effect

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModStatusEffects {

    fun registerModStatusEffects() {
        BeximitesMagic.logger.info("Registering Mod Status Effects for ${BeximitesMagic.modID}")

        registerSoulEffects()
    }

    // Initialize map and list for soul effects
    private val effects = listOf(WaterSoulEffect(), IceSoulEffect(), TerraSoulEffect(), FireSoulEffect(),
        MindSoulEffect(), ChaosSoulEffect(), OrderSoulEffect(), SpacetimeSoulEffect(), LifeSoulEffect(),
        DeathSoulEffect())
    val soulEffects: MutableMap<String, StatusEffect> = mutableMapOf()

    // Helper function for getting effects from map
    fun getSoulEffect(element: String): StatusEffect? {
        return soulEffects["${element}_soul_effect"]
    }

    // Registering effects
    private fun registerSoulEffects() {
        var effectNumber = 0
        elements.drop(2).forEach { crystalElement ->
            val name = crystalElement + "_" + "soul_effect"
            soulEffects[name] = Registry.register(Registries.STATUS_EFFECT,
                Identifier(BeximitesMagic.modID, name),
                effects[effectNumber])
            effectNumber++
        }
    }
}