package net.brendanmccall.beximitesmagic.item

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.FoodComponent

object ModFoodComponents {
    // TODO: Transfer some aspects to SoulItem class
    val water_soul: FoodComponent = FoodComponent.Builder().hunger(0).saturationModifier(0.0f).alwaysEdible()
        .statusEffect(StatusEffectInstance(ModStatusEffects.water_soul_effect,
            -1, 0, false, false, true), 1.0f).build()
}