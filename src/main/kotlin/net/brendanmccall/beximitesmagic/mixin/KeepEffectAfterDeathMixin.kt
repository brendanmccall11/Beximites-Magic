package net.brendanmccall.beximitesmagic.mixin

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects.getSoulEffect
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.registry.Registries
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(ServerPlayerEntity::class)
abstract class KeepEffectAfterDeathMixin {

    private companion object {
        var storedEffectInstance: StatusEffectInstance? = null
        var storedEffectEntry: RegistryEntry<StatusEffect>? = null
    }

    @Inject(method = ["onDeath"], at = [At("HEAD")])
    private fun onPlayerDeath(ci: CallbackInfo) {
        val player = this as ServerPlayerEntity
        for (statusEffect in player.statusEffects) {
            elements.drop(2).forEach { crystalElement ->
                if (statusEffect ==
                    StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(getSoulEffect(crystalElement)),
                        -1, 0, false, false, true)) {
                    storedEffectInstance = statusEffect
                    storedEffectEntry = Registries.STATUS_EFFECT.getEntry(getSoulEffect(crystalElement))
                }
            }
        }
    }

    @Inject(method = ["copyFrom"], at = [At("TAIL")])
    private fun onPlayerRespawn(oldPlayer: ServerPlayerEntity, alive: Boolean, ci: CallbackInfo) {
        val player = this as ServerPlayerEntity

        val effect = storedEffectInstance
        val effectEntry = storedEffectEntry

        if (effect != null) {
            (player.entityWorld as ServerWorld).server.execute {
               player.addStatusEffect(
                    StatusEffectInstance(
                        effectEntry,
                        effect.duration,
                        effect.amplifier,
                        effect.isAmbient,
                        false,
                        effect.shouldShowIcon()
                    )
                )
            }
        }
    }
}