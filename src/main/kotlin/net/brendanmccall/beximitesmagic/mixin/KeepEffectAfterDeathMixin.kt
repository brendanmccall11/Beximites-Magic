package net.brendanmccall.beximitesmagic.mixin

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects.getSoulEffect
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(ServerPlayerEntity::class)
abstract class KeepEffectAfterDeathMixin {

    @Inject(method = ["copyFrom"], at = [At("TAIL")])
    private fun onPlayerRespawn(oldPlayer: ServerPlayerEntity, alive: Boolean, ci: CallbackInfo) {
        val thisPlayer = this as ServerPlayerEntity
        elements.drop(2).forEach { crystalElement ->
            val effect = oldPlayer.getStatusEffect(getSoulEffect(crystalElement))
            if (effect != null) {
                (thisPlayer.entityWorld as ServerWorld).server.execute {
                    thisPlayer.addStatusEffect(StatusEffectInstance(
                        getSoulEffect(crystalElement),
                        effect.duration,
                        effect.amplifier,
                        effect.isAmbient,
                        false,
                        effect.shouldShowIcon()
                    ))
                }
            }
        }
    }
}