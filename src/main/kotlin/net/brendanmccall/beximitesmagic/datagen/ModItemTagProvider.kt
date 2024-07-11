package net.brendanmccall.beximitesmagic.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>)
    : FabricTagProvider.ItemTagProvider(output, registriesFuture) {

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        // TUTORIAL FOR ARMOR
        /*getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.ruby_helmet, ModItems.ruby_chestplate, ModItems.ruby_leggings, ModItems.ruby_boots)*/

        // TUTORIAL FOR MUSIC DISK
        /*getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
            .add(ModItems.bar_brawl_music_disk)
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
            .add(ModItems.bar_brawl_music_disk)*/
    }
}