package net.brendanmccall.beximitesmagic.item.custom

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Rarity

class SoulItem(settings: Settings,
               statusEffect: StatusEffect,
) : Item(settings.food(
    FoodComponent.Builder()
        .hunger(0)
        .saturationModifier(0.0f)
        .alwaysEdible()
        .statusEffect(
            StatusEffectInstance(statusEffect, -1, 0, false, false, true),
            1.0f
        )
        .build()
)) {

    override fun hasGlint(stack: ItemStack?): Boolean {
        return true
    }

    override fun getRarity(stack: ItemStack?): Rarity {
        return Rarity.EPIC
    }

}