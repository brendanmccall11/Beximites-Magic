package net.brendanmccall.beximitesmagic.datagen

import net.brendanmccall.beximitesmagic.block.ModBlocks.getOreBlock
import net.brendanmccall.beximitesmagic.item.ModItems.elements
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>)
    : FabricTagProvider.BlockTagProvider(output, registriesFuture) {

    // Generate tags
    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        // Ore blocks
        elements.drop(2).forEach { oreElement ->
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(getOreBlock(null, oreElement))
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(getOreBlock(null, oreElement))
        }
        elements.drop(2).forEach { oreElement ->
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(getOreBlock("deepslate", oreElement))
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(getOreBlock("deepslate", oreElement))
        }
        elements.drop(2).forEach { oreElement ->
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(getOreBlock("netherrack", oreElement))
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(getOreBlock("netherrack", oreElement))
        }
        elements.drop(2).forEach { oreElement ->
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(getOreBlock("end_stone", oreElement))
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(getOreBlock("end_stone", oreElement))
            /*getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,
                Identifier("fabric", "needs_tool_level_4")))
                .add(getOreBlock("end_stone", oreElement))*/
        }
    }
}