package com.fitness.FACTORY_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.interfaces.PlanDirector;

public class StrengthPlanDirector implements PlanDirector {
    @Override
    public WorkoutPlan create(WorkoutPlanBuilder builder) {
        return builder.reset()
                .setName("Strength Building Program")
                .setLevel("intermediate")
                .setIntensity("high")
                .setDurationMinutes(60)
                .setGoal("strength")
                .addExercise("Barbell Squats", "Heavy compound movement")
                .addExercise("Bench Press", "Upper body strength")
                .addExercise("Deadlifts", "Posterior chain development")
                .build();
    }
}
