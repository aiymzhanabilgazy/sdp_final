package com.fitness.BUILDER_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class WorkoutPlanDirector {

    public WorkoutPlan createFatLossPlan(WorkoutPlanBuilder builder) {

        builder.reset();
        builder.setName("Fat Loss Intense Program")
                .setLevel("intermediate")
                .setIntensity("high")
                .setDurationMinutes(45)
                .setGoal("fat-loss")
                .addExercise("Burpees", "High intensity fat-burning")
                .addExercise("Mountain Climbers", "Full body cardio")
                .addExercise("Jump Squats", "Explosive plyometrics");

        return builder.build();
    }
}