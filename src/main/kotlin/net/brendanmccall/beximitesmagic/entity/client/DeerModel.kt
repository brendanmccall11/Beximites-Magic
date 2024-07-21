package net.brendanmccall.beximitesmagic.entity.client

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.SinglePartEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.Entity
import net.minecraft.util.math.MathHelper
import net.brendanmccall.beximitesmagic.entity.animation.ModAnimations
import net.brendanmccall.beximitesmagic.entity.custom.DeerEntity

class DeerModel<T : DeerEntity>(root: ModelPart) : SinglePartEntityModel<T>() {
    private val deer: ModelPart
    private val head: ModelPart

    init {
        this.deer = root.getChild("deer")
        this.head = deer.getChild("head")
    }

    companion object {
        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            val deer = modelPartData.addChild("deer", ModelPartBuilder.create(),
                ModelTransform.pivot(0.0f, 24.0f, 0.0f))

            val head = deer.addChild("head", ModelPartBuilder.create()
                .uv(28, 6)
                .cuboid(-1.0f, -4.25f, -5.0f, 2.0f, 2.0f, 3.0f)
                .uv(0, 16)
                .cuboid(-2.0f, -6.0f, -2.5f, 4.0f, 4.0f, 5.0f),
                ModelTransform.pivot(0.0f, -11.0f, -3.0f))

            val neck = head.addChild("neck", ModelPartBuilder.create(),
                ModelTransform.pivot(0.0f, -1.0f, 1.0f))

            neck.addChild("secondary_neck_r1", ModelPartBuilder.create()
                .uv(16, 30)
                .cuboid(-1.0f, 3.0f, -0.5f, 1.0f, 7.0f, 1.0f),
                ModelTransform.of(0.5f, -7.0f, -3.5f, 0.3054f, 0.0f, 0.0f))
            neck.addChild("main_neck_r1", ModelPartBuilder.create()
                .uv(18, 16)
                .cuboid(-2.0f, 4.0f, -2.5f, 3.0f, 6.0f, 3.0f),
                ModelTransform.of(0.5f, -6.0f, -0.5f, 0.3054f, 0.0f, 0.0f))

            val antlers = head.addChild("antlers", ModelPartBuilder.create(),
                ModelTransform.pivot(0.5f, 5.0f, 3.0f))
            antlers.addChild("cube_r1", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(1.0f, -5.0f, -1.0f, 0.0f, 5.0f, 4.0f),
                ModelTransform.of(-0.5f, -11.5f, -1.25f, 0.1745f, -0.1745f, 0.0f))
            antlers.addChild("cube_r2", ModelPartBuilder.create()
                .uv(0, 21)
                .cuboid(1.0f, -5.0f, -1.0f, 0.0f, 5.0f, 4.0f),
                ModelTransform.of(-2.5f, -11.5f, -1.25f, 0.1745f, 0.1745f, 0.0f))
            antlers.addChild("cube_r3", ModelPartBuilder.create()
                .uv(8, 21)
                .cuboid(1.0f, -5.0f, -1.0f, 0.0f, 5.0f, 4.0f)
                .uv(16, 21)
                .cuboid(-1.5f, -5.0f, -1.0f, 0.0f, 5.0f, 4.0f),
                ModelTransform.of(-0.25f, -11.5f, -1.25f, 0.1745f, 0.0f, 0.0f))
            antlers.addChild("cube_r4", ModelPartBuilder.create()
                .uv(27, 16)
                .cuboid(-1.0f, -2.0f, -1.0f, 1.0f, 1.0f, 2.0f)
                .uv(13, 16)
                .cuboid(-3.0f, -2.0f, -1.0f, 1.0f, 1.0f, 2.0f),
                ModelTransform.of(1.0f, -11.0f, -0.25f, 1.7453f, 0.0f, 0.0f))

            val ears = head.addChild("ears", ModelPartBuilder.create(),
                ModelTransform.pivot(0.0f, 10.0f, 4.0f))
            ears.addChild("left_ear_r1", ModelPartBuilder.create()
                .uv(30, 19)
                .cuboid(-1.0f, -2.0f, -1.0f, 1.0f, 1.0f, 2.0f)
                .uv(30, 22)
                .cuboid(-6.0f, -2.0f, -1.0f, 1.0f, 1.0f, 2.0f),
                ModelTransform.of(3.0f, -15.0f, -0.75f, 0.6545f, 0.0f, 0.0f))

            val body = deer.addChild("body", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-3.0f, -11.0f, -2.0f, 6.0f, 5.0f, 11.0f)
                .uv(8, 30)
                .cuboid(0.75f, -7.0f, -1.75f, 2.0f, 7.0f, 2.0f)
                .uv(0, 30)
                .cuboid(-2.75f, -7.0f, 6.75f, 2.0f, 7.0f, 2.0f)
                .uv(24, 25)
                .cuboid(0.75f, -7.0f, 6.75f, 2.0f, 7.0f, 2.0f)
                .uv(23, 0)
                .cuboid(-2.75f, -7.0f, -1.75f, 2.0f, 7.0f, 2.0f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f))

            body.addChild("tail_r1", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-1.0f, -2.0f, 0.0f, 2.0f, 2.0f, 2.0f),
                ModelTransform.of(0.0f, -8.5f, 7.25f, -0.48f, 0.0f, 0.0f))

            return TexturedModelData.of(modelData, 64, 64)
        }
    }

    override fun setAngles(entity: T, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float,
                           headPitch: Float) {
        getPart().traverse().forEach(ModelPart::resetTransform)
        setHeadAngles(netHeadYaw, headPitch)

        //animateMovement(ModAnimations.DEER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f)
        //updateAnimation(entity.idleAnimationState, ModAnimations.DEER_IDLE, ageInTicks, 1f)
    }

    private fun setHeadAngles(headYaw: Float, headPitch: Float) {
        val clampedHeadYaw = MathHelper.clamp(headYaw, -20.0F, 20.0F) // Horizontal Rotation
        val clampedHeadPitch = MathHelper.clamp(headPitch, -10.0F, 10.0F) // Vertical Rotation

        head.yaw = clampedHeadYaw * 0.017453292F
        head.pitch = clampedHeadPitch * 0.017453292F
    }

    override fun render(matrices: MatrixStack, vertexConsumer: VertexConsumer, light: Int, overlay: Int, color: Int) {
        deer.render(matrices, vertexConsumer, light, overlay, color)
    }

    override fun getPart(): ModelPart = deer
}