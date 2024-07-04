package net.brendanmccall.beximitesmagic.mixin;

import net.brendanmccall.beximitesmagic.effect.WaterSoulEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public abstract class KeepEffectAfterMilkMixin {
    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void onFinishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> callbackInfo) {
        if (!world.isClient()) {
            user.getStatusEffects().removeIf(effect ->
                    !(effect.getEffectType() instanceof WaterSoulEffect)
            );
        }
        callbackInfo.setReturnValue(stack);
    }
}