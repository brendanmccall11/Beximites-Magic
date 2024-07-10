package net.brendanmccall.beximitesmagic

//import net.brendanmccall.beximitesmagic.block.ModBlocks
import net.fabricmc.api.ClientModInitializer
/*import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer*/

object BeximitesMagicClient : ClientModInitializer {

    override fun onInitializeClient() {
        // Unused renders
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.dahlia, RenderLayer.getCutout()) // Flower block
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.potted_dahlia, RenderLayer.getCutout()) // Potted flower block
    }
}