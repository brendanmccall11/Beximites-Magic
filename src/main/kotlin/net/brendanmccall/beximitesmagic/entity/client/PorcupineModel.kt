package net.brendanmccall.beximitesmagic.entity.client

/*import net.brendanmccall.beximitesmagic.entity.animation.ModAnimations
import net.brendanmccall.beximitesmagic.entity.custom.PorcupineEntity
import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.SinglePartEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.MathHelper

// TUTORIAL FOR ENTITY
class PorcupineModel<T : PorcupineEntity>(root: ModelPart) : SinglePartEntityModel<T>() {
    private val porcupine: ModelPart
    private val head: ModelPart

    init {
        this.porcupine = root.getChild("porcupine")
        this.head = porcupine.getChild("body").getChild("torso").getChild("head")
    }

    companion object {
        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            val porcupine = modelPartData.addChild("porcupine", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F))

            val body = porcupine.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, -4.0f, 0.0f))

            val torso = body.addChild(
                "torso",
                ModelPartBuilder.create().uv(0, 0).cuboid(-3.0f, -3.0f, -4.0f, 6.0f, 5.0f, 8.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f)
            )

            val tail = torso.addChild(
                "tail",
                ModelPartBuilder.create(),
                ModelTransform.of(0.5f, -1.251f, 4.0f, -0.4363f, 0.0f, 0.0f)
            )

            val cube_r1 = tail.addChild(
                "cube_r1",
                ModelPartBuilder.create().uv(11, 25).cuboid(-6.0f, -0.499f, -1.0f, 7.0f, 0.0f, 7.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 0.25f, 0.0f, 0.0f, 0.9599f, 0.0f)
            )

            val cube_r2 = tail.addChild(
                "cube_r2",
                ModelPartBuilder.create().uv(11, 25).cuboid(-6.0f, 0.001f, -1.0f, 7.0f, 0.0f, 7.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 0.25f, 0.0f, 0.0f, 0.6109f, 0.0f)
            )

            val head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, -1.0f, -4.0f))

            val skull = head.addChild(
                "skull",
                ModelPartBuilder.create().uv(0, 13).cuboid(-2.0f, -2.0f, -4.0f, 4.0f, 4.0f, 4.0f, Dilation(0.0f))
                    .uv(0, 14).cuboid(1.1f, -0.75f, -3.25f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(12, 13).cuboid(1.425f, -0.975f, -3.025f, 1.0f, 1.0f, 1.0f, Dilation(-0.3f))
                    .uv(0, 14).mirrored().cuboid(-2.1f, -0.75f, -3.25f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .mirrored(false)
                    .uv(12, 13).mirrored().cuboid(-2.425f, -0.975f, -3.025f, 1.0f, 1.0f, 1.0f, Dilation(-0.3f))
                    .mirrored(false)
                    .uv(16, 18).cuboid(-1.0f, -0.25f, -5.0f, 2.0f, 2.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f)
            )

            val hair = skull.addChild(
                "hair",
                ModelPartBuilder.create().uv(0, 16).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 5.0f, 5.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, -1.0f, -4.0f, 0.5236f, 0.0f, 0.0f)
            )

            val cube_r3 = hair.addChild(
                "cube_r3",
                ModelPartBuilder.create().uv(0, 16).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 5.0f, 5.0f, Dilation(0.0f)),
                ModelTransform.of(-0.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.2618f)
            )

            val cube_r4 = hair.addChild(
                "cube_r4",
                ModelPartBuilder.create().uv(0, 16).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 5.0f, 5.0f, Dilation(0.0f)),
                ModelTransform.of(0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2618f)
            )

            val left_eyelid = skull.addChild(
                "left_eyelid",
                ModelPartBuilder.create().uv(24, 0).cuboid(0.1f, -1.75f, -7.25f, 2.0f, 2.0f, 2.0f, Dilation(-0.4f)),
                ModelTransform.pivot(-0.4f, 0.5f, 3.5f)
            )

            val right_eyelid = skull.addChild(
                "right_eyelid",
                ModelPartBuilder.create().uv(24, 0).mirrored()
                    .cuboid(-2.1f, -1.75f, -7.25f, 2.0f, 2.0f, 2.0f, Dilation(-0.4f)).mirrored(false),
                ModelTransform.pivot(0.4f, 0.5f, 3.5f)
            )

            val spikes = torso.addChild("spikes", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, -3.0f, -3.5f))

            val spike = spikes.addChild(
                "spike",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.0436f)
            )

            val spike2 = spikes.addChild(
                "spike2",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0873f)
            )

            val spike5 = spikes.addChild(
                "spike5",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.3491f)
            )

            val spike3 = spikes.addChild(
                "spike3",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.1309f)
            )

            val spike4 = spikes.addChild(
                "spike4",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.4363f)
            )

            val spikes2 = torso.addChild(
                "spikes2",
                ModelPartBuilder.create(),
                ModelTransform.of(0.5f, -3.0f, -2.5f, 0.3054f, 0.0f, 0.0f)
            )

            val spike6 = spikes2.addChild(
                "spike6",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, -1.0f)
            )

            val spike7 = spikes2.addChild(
                "spike7",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, -1.5f, 0.0f, 0.0f, 0.2618f)
            )

            val spike8 = spikes2.addChild(
                "spike8",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.4363f)
            )

            val spike9 = spikes2.addChild(
                "spike9",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, -1.5f, 0.0f, 0.0f, -0.3054f)
            )

            val spike10 = spikes2.addChild(
                "spike10",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, -1.0f, 0.0f, 0.0f, -0.6545f)
            )

            val spikes3 = torso.addChild(
                "spikes3",
                ModelPartBuilder.create(),
                ModelTransform.of(0.5f, -3.0f, -2.5f, -0.1745f, 0.0f, 0.0f)
            )

            val spike11 = spikes3.addChild(
                "spike11",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.1309f)
            )

            val spike12 = spikes3.addChild(
                "spike12",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1309f)
            )

            val spike13 = spikes3.addChild(
                "spike13",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.2618f)
            )

            val spike14 = spikes3.addChild(
                "spike14",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.0436f)
            )

            val spike15 = spikes3.addChild(
                "spike15",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -7.0f, 0.0f, 0.0f, 7.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.1745f)
            )

            val spikes4 = torso.addChild(
                "spikes4",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0f, -3.0f, -2.0f, -0.5672f, 0.0f, 0.0f)
            )

            val spike16 = spikes4.addChild(
                "spike16",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, 0.5f)
            )

            val spike17 = spikes4.addChild(
                "spike17",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1745f)
            )

            val spike18 = spikes4.addChild(
                "spike18",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.2182f)
            )

            val spike19 = spikes4.addChild(
                "spike19",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.0873f)
            )

            val spike20 = spikes4.addChild(
                "spike20",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.1309f)
            )

            val spikes5 = torso.addChild(
                "spikes5",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0f, -3.0f, 0.0f, -0.7854f, 0.0f, 0.0f)
            )

            val spike21 = spikes5.addChild(
                "spike21",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, 0.5f)
            )

            val spike22 = spikes5.addChild(
                "spike22",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.4363f)
            )

            val spike23 = spikes5.addChild(
                "spike23",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.7854f)
            )

            val spike24 = spikes5.addChild(
                "spike24",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.2618f)
            )

            val spike25 = spikes5.addChild(
                "spike25",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -6.0f, 0.0f, 0.0f, 6.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.5672f)
            )

            val spikes6 = torso.addChild(
                "spikes6",
                ModelPartBuilder.create(),
                ModelTransform.of(0.5f, -3.0f, -0.5f, -0.6545f, 0.0f, 0.0f)
            )

            val spike26 = spikes6.addChild(
                "spike26",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -5.0f, 0.0f, 0.0f, 5.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, 0.5f)
            )

            val spike27 = spikes6.addChild(
                "spike27",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -5.0f, 0.0f, 0.0f, 5.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.3491f)
            )

            val spike28 = spikes6.addChild(
                "spike28",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -5.0f, 0.0f, 0.0f, 5.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.48f)
            )

            val spike29 = spikes6.addChild(
                "spike29",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -5.0f, 0.0f, 0.0f, 5.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.2182f)
            )

            val spike30 = spikes6.addChild(
                "spike30",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -5.0f, 0.0f, 0.0f, 5.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.48f)
            )

            val spikes7 = torso.addChild(
                "spikes7",
                ModelPartBuilder.create(),
                ModelTransform.of(0.5f, -3.0f, 1.5f, -0.9599f, 0.0f, 0.0f)
            )

            val spike31 = spikes7.addChild(
                "spike31",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 4.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 0.0f, 0.5f)
            )

            val spike32 = spikes7.addChild(
                "spike32",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 4.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1309f)
            )

            val spike33 = spikes7.addChild(
                "spike33",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 4.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.3491f)
            )

            val spike34 = spikes7.addChild(
                "spike34",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 4.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.1309f)
            )

            val spike35 = spikes7.addChild(
                "spike35",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -4.0f, 0.0f, 0.0f, 4.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.3054f)
            )

            val spikes8 = torso.addChild(
                "spikes8",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0f, -3.0f, 3.0f, -1.0472f, 0.0f, 0.0f)
            )

            val spike36 = spikes8.addChild(
                "spike36",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -3.0f, 0.0f, 0.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.1309f)
            )

            val spike37 = spikes8.addChild(
                "spike37",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -3.0f, 0.0f, 0.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(1.0f, 0.0f, 0.0f)
            )

            val spike38 = spikes8.addChild(
                "spike38",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -3.0f, 0.0f, 0.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(2.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.3927f)
            )

            val spike39 = spikes8.addChild(
                "spike39",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -3.0f, 0.0f, 0.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.pivot(-1.0f, 0.0f, 0.0f)
            )

            val spike40 = spikes8.addChild(
                "spike40",
                ModelPartBuilder.create().uv(20, 0).cuboid(0.0f, -3.0f, 0.0f, 0.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.3054f)
            )

            val left_front_leg = body.addChild(
                "left_front_leg",
                ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.pivot(3.0f, 0.0f, -2.5f)
            )

            val right_front_leg = body.addChild(
                "right_front_leg",
                ModelPartBuilder.create().uv(0, 0).mirrored()
                    .cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation(0.0f)).mirrored(false),
                ModelTransform.pivot(-3.0f, 0.0f, -2.5f)
            )

            val right_back_leg = body.addChild(
                "right_back_leg",
                ModelPartBuilder.create().uv(0, 0).mirrored()
                    .cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation(0.0f)).mirrored(false),
                ModelTransform.pivot(-3.0f, 0.0f, 2.5f)
            )

            val left_back_leg = body.addChild(
                "left_back_leg",
                ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.pivot(3.0f, 0.0f, 2.5f)
            )

            return TexturedModelData.of(modelData, 32, 32)
        }
    }

    override fun setAngles(entity: T, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {
        getPart().traverse().forEach(ModelPart::resetTransform)
        setHeadAngles(netHeadYaw, headPitch)

        animateMovement(ModAnimations.PORCUPINE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f)
        updateAnimation(entity.idleAnimationState, ModAnimations.PORCUPINE_IDLE, ageInTicks, 1f)
    }

    private fun setHeadAngles(headYaw: Float, headPitch: Float) {
        val clampedHeadYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F)
        val clampedHeadPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F)

        head.yaw = clampedHeadYaw * 0.017453292F
        head.pitch = clampedHeadPitch * 0.017453292F
    }

    override fun render(matrices: MatrixStack, vertexConsumer: VertexConsumer, light: Int, overlay: Int, color: Int) {
        porcupine.render(matrices, vertexConsumer, light, overlay, color)
    }

    override fun getPart(): ModelPart = porcupine
}*/