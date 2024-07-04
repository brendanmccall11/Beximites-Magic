package net.brendanmccall.beximitesmagic.item.custom

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects.soulEffects
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Rarity
import net.minecraft.world.World

class SoulItem(
    settings: Settings,
    private val statusEffect: StatusEffect?,
) : Item(settings.food(
    FoodComponent.Builder()
        .hunger(0)
        .saturationModifier(0.0f)
        .alwaysEdible()
        .statusEffect(
            StatusEffectInstance(
                statusEffect, -1, 0, false, false, true),
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

    override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
        val result = super.finishUsing(stack, world, user)

        if (!world.isClient) {
            // Remove all soul effects except the one just applied
            soulEffects.values.forEach { effect ->
                if (effect != statusEffect) {
                    user.removeStatusEffect(effect)
                }
            }
        }

        return result
    }
}