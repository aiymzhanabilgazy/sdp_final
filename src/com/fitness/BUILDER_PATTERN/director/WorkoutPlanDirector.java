package com.fitness.BUILDER_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class WorkoutPlanDirector {
    private String name = "Fat Loss Intense Program";
    private String level = "intermediate";
    private String intensity = "high";
    private int duration = 45;
    private String goal = "fat-loss";

    public WorkoutPlan createFatLossPlan(WorkoutPlanBuilder builder) {
        builder.reset();

        builder.setName(name)
                .setLevel(level)
                .setIntensity(intensity)
                .setDurationMinutes(duration)
                .setGoal(goal)
                .addExercise("Burpees", "High intensity fat-burning")
                .addExercise("Mountain Climbers", "Full body cardio")
                .addExercise("Jump Squats", "Explosive plyometrics");

        return builder.build();
    }
}