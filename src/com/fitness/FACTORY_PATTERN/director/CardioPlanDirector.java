package com.fitness.FACTORY_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.interfaces.PlanDirector;

public class CardioPlanDirector implements PlanDirector {
    @Override
    public WorkoutPlan create(WorkoutPlanBuilder builder) {
        return builder.reset()
                .setName("Cardio Endurance Program")
                .setLevel("beginner")
                .setIntensity("medium")
                .setDurationMinutes(40)
                .setGoal("endurance")
                .addExercise("Running", "30 minutes steady state")
                .addExercise("Cycling", "Interval training")
                .addExercise("Jump Rope", "Coordination and cardio")
                .build();
    }
}
