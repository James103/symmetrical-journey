package org.mycf.symmetrical.journey.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.world.World;
import org.mycf.symmetrical.journey.entities.goals.parrot.EatSeedsGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParrotEntity.class)
public abstract class MixinParrotEntity extends TameableShoulderEntity{
    protected MixinParrotEntity(EntityType<? extends TameableShoulderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    protected void initGoalsMixed(CallbackInfo ci){
        this.goalSelector.add(1, new EatSeedsGoal((ParrotEntity)(Object)this, 1.2000000476837158D, 12, 5));
    }

}
