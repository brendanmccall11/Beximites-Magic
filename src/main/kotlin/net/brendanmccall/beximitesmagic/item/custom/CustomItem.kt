package net.brendanmccall.beximitesmagic.item.custom

import net.minecraft.item.Item

class CustomItem(settings: Settings) : Item(settings) {

    // TUTORIAL FOR TOOLTIP
    /*override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext?
    ) {
        tooltip.add(Text.translatable("tooltip.beximitesmagic.custom_item.tooltip"));
        super.appendTooltip(stack, world, tooltip, context)
    }*/
}