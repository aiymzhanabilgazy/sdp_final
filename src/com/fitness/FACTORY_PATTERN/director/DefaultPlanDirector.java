package com.fitness.FACTORY_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.interfaces.PlanDirector;

public class DefaultPlanDirector implements PlanDirector {
    @Override
    public WorkoutPlan create(WorkoutPlanBuilder builder) {
        return builder.reset()
                .setName("Default Workout Program")
                .setLevel("beginner")
                .setIntensity("medium")
                .setDurationMinutes(30)
                .setGoal("general-fitness")
                .addExercise("Walking", "Light cardio exercise")
                .addExercise("Stretching", "Basic flexibility")
                .build();
    }
}
