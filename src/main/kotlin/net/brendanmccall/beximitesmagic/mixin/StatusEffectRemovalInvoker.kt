package net.brendanmccall.beximitesmagic.mixin

import net.minecraft.entity.effect.StatusEffectInstance
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Invoker
import net.minecraft.entity.LivingEntity

@Mixin(LivingEntity::class)
interface StatusEffectRemovalInvoker {
    @Invoker("onStatusEffectRemoved")
    fun invokeOnStatusEffectRemoved(statusEffectInstance: StatusEffectInstance?)
}