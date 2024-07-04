package net.brendanmccall.beximitesmagic.mixin;

import net.brendanmccall.beximitesmagic.effect.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class KeepEffectAfterDeathMixin {

    @Inject(method = "copyFrom", at = @At("TAIL"))
    private void onPlayerRespawn(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        ServerPlayerEntity thisPlayer = (ServerPlayerEntity)(Object)this;
        StatusEffectInstance effect = oldPlayer.getStatusEffect(ModStatusEffects.water_soul_effect);
        if (effect != null) {
            ((ServerWorld) thisPlayer.getEntityWorld()).getServer().execute(() -> {
                thisPlayer.addStatusEffect(new StatusEffectInstance(ModStatusEffects.water_soul_effect,
                        effect.getDuration(),
                        effect.getAmplifier(),
                        effect.isAmbient(),
                        false,
                        effect.shouldShowIcon()));
            });
        }
    }
}