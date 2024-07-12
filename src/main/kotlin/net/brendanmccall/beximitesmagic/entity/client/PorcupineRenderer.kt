package net.brendanmccall.beximitesmagic.entity.client

/*import net.brendanmccall.beximitesmagic.BeximitesMagic
import net.brendanmccall.beximitesmagic.entity.custom.PorcupineEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

// TUTORIAL FOR ENTITY
class PorcupineRenderer(context: EntityRendererFactory.Context) :
    MobEntityRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity>>(
        context,
        PorcupineModel(context.getPart(ModModelLayers.porcupine)),
        0.6f
    ) {

    companion object {
        private val TEXTURE = Identifier.of(BeximitesMagic.modID, "textures/entity/porcupine.png")
    }

    override fun getTexture(entity: PorcupineEntity): Identifier {
        return TEXTURE
    }

    override fun render(
        mobEntity: PorcupineEntity,
        f: Float,
        g: Float,
        matrixStack: MatrixStack,
        vertexConsumerProvider: VertexConsumerProvider,
        i: Int
    ) {
        if (mobEntity.isBaby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f)
        } else {
            matrixStack.scale(1f, 1f, 1f)
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i)
    }
}*/