package net.brendanmccall.beximitesmagic

//import net.brendanmccall.beximitesmagic.block.ModBlocks
/*import net.brendanmccall.beximitesmagic.entity.ModEntities
import net.brendanmccall.beximitesmagic.entity.client.ModModelLayers
import net.brendanmccall.beximitesmagic.entity.client.PorcupineModel
import net.brendanmccall.beximitesmagic.entity.client.PorcupineRenderer*/
import net.fabricmc.api.ClientModInitializer
/*import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry*/
/*import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer*/

object BeximitesMagicClient : ClientModInitializer {

    override fun onInitializeClient() {
        // Unused renders
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.dahlia, RenderLayer.getCutout()) // Flower block
        //BlockRenderLayerMap.INSTANCE.putBlk(ModBlocks.potted_dahlia, RenderLayer.getCutout()) // Potted flower block
        // Custom entity
        /*EntityModelLayerRegistry.registerModelLayer(ModModelLayers.porcupine)
        { PorcupineModel.getTexturedModelData() }
        EntityRendererRegistry.register(ModEntities.porcupine) { context -> PorcupineRenderer(context) }*/
    }
}