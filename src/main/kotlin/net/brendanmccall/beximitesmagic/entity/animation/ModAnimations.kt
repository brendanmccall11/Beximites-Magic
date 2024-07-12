package net.brendanmccall.beximitesmagic.entity.animation

/*import net.minecraft.client.render.entity.animation.Animation
import net.minecraft.client.render.entity.animation.AnimationHelper
import net.minecraft.client.render.entity.animation.Keyframe
import net.minecraft.client.render.entity.animation.Transformation*/

// TUTORIAL FOR ENTITY
object ModAnimations {
    /*val PORCUPINE_WALK: Animation = Animation.Builder.create(2.5f).looping()
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.4167667f, AnimationHelper.createTranslationalVector(0f, 0f, -0.15f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.9583434f, AnimationHelper.createTranslationalVector(0f, 0f, -0.05f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0.05f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.125f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_front_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0834333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.625f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.0834335f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_front_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.20834334f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5416766f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0834333f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.2916767f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_back_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.3433333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.2916765f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_back_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.3433333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.875f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5834333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.0834335f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        ).build()
    val PORCUPINE_IDLE: Animation = Animation.Builder.create(2f).looping()
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f, AnimationHelper.createTranslationalVector(0f, 0.35f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.875f, AnimationHelper.createTranslationalVector(0f, 0.4f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createTranslationalVector(0f, 0.4f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, 0.35f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "skull",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.3433333f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, 0.2f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.9583433f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "skull",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f, AnimationHelper.createRotationalVector(2f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f, AnimationHelper.createRotationalVector(2f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(-2f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createRotationalVector(-2f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_front_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.7083434f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_front_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.9167666f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.7916767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_back_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.125f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.7916767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_back_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.2916767f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.9167667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        ).build()
    val PORCUPINE_ATTACK: Animation = Animation.Builder.create(2f).looping()
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.6766666f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createTranslationalVector(0f, 0.5f, -1f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createTranslationalVector(0f, 0.5f, -1f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5416767f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.4167667f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5416767f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.6766667f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "skull",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5416767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "skull",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.4167667f, AnimationHelper.createRotationalVector(15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createRotationalVector(15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createRotationalVector(15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5416767f, AnimationHelper.createRotationalVector(15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.6766667f, AnimationHelper.createRotationalVector(15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.875f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "hair",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.25, 1.25, 1.25),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.25, 1.25, 1.25),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes2",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.25, 1.25, 1.25),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.25, 1.25, 1.25),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes3",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes4",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes5",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes6",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes7",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "spikes8",
            Transformation(
                Transformation.Targets.SCALE,
                Keyframe(
                    1f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0416767f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createScalingVector(1.15, 1.15, 1.15),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createScalingVector(1.0, 1.0, 1.0),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_front_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_front_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_front_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_front_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_back_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_back_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_back_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_back_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        ).build()
    val PORCUPINE_SIT: Animation = Animation.Builder.create(2f).looping()
        .addBoneAnimation(
            "porcupine",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, -0.3f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.4583433f, AnimationHelper.createTranslationalVector(0f, 0.3f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.125f, AnimationHelper.createTranslationalVector(0f, 0.5f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.7916767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2f, AnimationHelper.createTranslationalVector(0f, -0.3f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "torso",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "skull",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_front_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_front_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_back_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createTranslationalVector(0f, -0.75f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "right_back_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_back_leg",
            Transformation(
                Transformation.Targets.TRANSLATE,
                Keyframe(
                    0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f, AnimationHelper.createTranslationalVector(0f, -0.75f, 0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.9583433f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "left_back_leg",
            Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        ).build()*/
}