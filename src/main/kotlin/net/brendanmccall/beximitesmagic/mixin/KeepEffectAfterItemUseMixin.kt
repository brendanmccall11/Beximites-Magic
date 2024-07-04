package net.brendanmccall.beximitesmagic.mixin

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects.getSoulEffect
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.minecraft.entity.LivingEntity
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(LivingEntity::class)
abstract class KeepEffectAfterItemUseMixin : StatusEffectRemovalInvoker {

    @Inject(method = ["clearStatusEffects"], at = [At("HEAD")], cancellable = true)
    private fun onClearStatusEffects(callbackInfo: CallbackInfoReturnable<Boolean>) {
        val self = this as LivingEntity
        elements.drop(2).forEach { crystalElement ->
            val customEffectInstance = self.getStatusEffect(getSoulEffect(crystalElement))

            if (customEffectInstance != null) {
                // Remove all effects except soul effect
                val iterator = self.activeStatusEffects.entries.iterator()
                var changed = false

                while (iterator.hasNext()) {
                    val entry = iterator.next()
                    if (entry.key != getSoulEffect(crystalElement)) {
                        iterator.remove()
                        (this as StatusEffectRemovalInvoker).invokeOnStatusEffectRemoved(entry.value)
                        changed = true
                    }
                }

                callbackInfo.returnValue = changed
                callbackInfo.cancel()
            }
        }
    }
}