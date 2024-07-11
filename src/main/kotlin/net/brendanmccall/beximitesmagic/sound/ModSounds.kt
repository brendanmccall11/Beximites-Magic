package net.brendanmccall.beximitesmagic.sound

import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object ModSounds {

    fun registerSounds() {
        BeximitesMagic.logger.info("Registering Mod Sounds for ${BeximitesMagic.modID}")
    }

    private fun registerSoundEvent(name: String): SoundEvent {
        val id = Identifier(BeximitesMagic.modID, name)
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id))
    }

    // TUTORIAL FOR SOUNDS
    /*val custom_block_break = registerSoundEvent("custom_block_break") // Custom block sound
    val custom_block_step = registerSoundEvent("custom_block_step") // Custom block sound
    val custom_block_place = registerSoundEvent("custom_block_place") // Custom block sound
    val custom_block_hit = registerSoundEvent("custom_block_hit") // Custom block sound
    val custom_block_fall = registerSoundEvent("custom_block_fall") // Custom block sound
    val bar_brawl = registerSoundEvent("bar_brawl") // Music disk sound

    val custom_block_sounds = BlockSoundGroup(
        1f, 1f,
        custom_block_break, custom_block_step, custom_block_place,
        custom_block_hit, custom_block_fall
    )*/
}