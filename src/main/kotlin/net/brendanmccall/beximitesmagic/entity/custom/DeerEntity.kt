package net.brendanmccall.beximitesmagic.entity.custom

import net.brendanmccall.beximitesmagic.entity.ModEntities
import net.minecraft.block.Blocks
import net.minecraft.entity.AnimationState
import net.minecraft.entity.EntityPose
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World

class DeerEntity(entityType: EntityType<out AnimalEntity>, world: World) : AnimalEntity(entityType, world) {
    /*val idleAnimationState = AnimationState()
    private var idleAnimationTimeout = 0

    private fun setupAnimationStates() {
        if (idleAnimationTimeout <= 0) {
            idleAnimationTimeout = random.nextInt(40) + 80
            idleAnimationState.start(age)
        } else {
            --idleAnimationTimeout
        }
    }

    override fun updateLimbs(posDelta: Float) {
        val f = if (pose == EntityPose.STANDING) posDelta.coerceAtMost(1.0f) * 6.0f else 0.0f
        limbAnimator.updateLimbs(f, 0.2f)
    }

    override fun tick() {
        super.tick()
        if (world.isClient) {
            setupAnimationStates()
        }
    }*/

    override fun initGoals() {
        goalSelector.add(0, SwimGoal(this))
        goalSelector.add(1, AnimalMateGoal(this, 1.15))
        goalSelector.add(2, TemptGoal(this, 1.25, Ingredient.ofItems(Items.APPLE), false))
        goalSelector.add(3, FollowParentGoal(this, 1.15))
        goalSelector.add(4, WanderAroundFarGoal(this, 1.0))
        goalSelector.add(5, LookAtEntityGoal(this, PlayerEntity::class.java, 4f))
        goalSelector.add(6, LookAroundGoal(this))
    }

    override fun isBreedingItem(stack: ItemStack): Boolean {
        return stack.isOf(Items.APPLE)
    }

    override fun createChild(world: ServerWorld, entity: PassiveEntity): PassiveEntity? {
        return ModEntities.deer.create(world)
    }

    override fun getAmbientSound(): SoundEvent? { // TODO: CHANGE LATER
        return SoundEvents.ENTITY_FOX_AMBIENT
    }

    override fun getHurtSound(source: DamageSource): SoundEvent? { // TODO: CHANGE LATER
        return SoundEvents.ENTITY_GENERIC_HURT
    }

    override fun getDeathSound(): SoundEvent? { // TODO: CHANGE LATER
        return SoundEvents.ENTITY_GENERIC_DEATH
    }

    companion object {
        fun createPorcupineAttributes(): DefaultAttributeContainer.Builder {
            return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
        }

        fun canSpawn(type: EntityType<DeerEntity>, world: ServerWorldAccess, spawnReason: SpawnReason, pos: BlockPos,
                     random: Random): Boolean {
            val blockState = world.getBlockState(pos.down())
            return blockState.isOf(Blocks.GRASS_BLOCK) && world.getBaseLightLevel(pos, 0) > 8
        }
    }
}