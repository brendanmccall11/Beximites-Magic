package net.brendanmccall.beximitesmagic.effect

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory

class SpacetimeSoulEffect : StatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFFFF) {

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return true
    }

    // Custom logic for when effect is applied
    override fun applyUpdateEffect(entity: LivingEntity?, amplifier: Int) {

    }
}