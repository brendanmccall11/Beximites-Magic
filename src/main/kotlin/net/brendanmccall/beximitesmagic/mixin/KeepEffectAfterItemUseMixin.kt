package net.brendanmccall.beximitesmagic.mixin

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects.getSoulEffect
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.minecraft.entity.LivingEntity
import net.minecraft.registry.Registries
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(LivingEntity::class)
abstract class KeepEffectAfterItemUseMixin {

    @Inject(method = ["clearStatusEffects"], at = [At("HEAD")], cancellable = true)
    private fun onClearStatusEffects(callbackInfo: CallbackInfoReturnable<Boolean>) {
        val self = this as LivingEntity
        var changed = false

        elements.drop(2).forEach { crystalElement ->
            val soulEffect = Registries.STATUS_EFFECT.getEntry(getSoulEffect(crystalElement))
            if (self.hasStatusEffect(soulEffect)) {
                // Remove all effects except soul effect
                val effectsToRemove = self.activeStatusEffects.entries
                    .filter { it.key != soulEffect }
                    .map { it.value }

                effectsToRemove.forEach { effect ->
                    self.removeStatusEffect(effect.effectType)
                    changed = true
                }

                callbackInfo.returnValue = changed
                callbackInfo.cancel()
                return
            }
        }
    }
}