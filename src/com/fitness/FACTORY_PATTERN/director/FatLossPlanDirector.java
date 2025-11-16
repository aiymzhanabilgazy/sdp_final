package com.fitness.FACTORY_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.interfaces.PlanDirector;

public class FatLossPlanDirector implements PlanDirector {
    @Override
    public WorkoutPlan create(WorkoutPlanBuilder builder) {
        return builder.reset()
                .setName("Fat Loss Intense Program")
                .setLevel("intermediate")
                .setIntensity("high")
                .setDurationMinutes(45)
                .setGoal("fat-loss")
                .addExercise("Burpees", "High intensity fat-burning")
                .addExercise("Mountain Climbers", "Full body cardio")
                .addExercise("Jump Squats", "Explosive plyometrics")
                .build();
    }
}
