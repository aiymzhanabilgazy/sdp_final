package com.fitness.factory_pattern.director;

import com.fitness.builder_pattern.builder.WorkoutPlanBuilder;
import com.fitness.builder_pattern.product.WorkoutPlan;

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
    
    public WorkoutPlan createMuscleGainPlan(WorkoutPlanBuilder builder) {
        builder.reset();
        builder.setName("Muscle Gain Program")
                .setLevel("advanced")
                .setIntensity("high")
                .setDurationMinutes(75)
                .setGoal("muscle-gain")
                .addExercise("Weighted Squats", "Leg development")
                .addExercise("Pull-ups", "Back and biceps")
                .addExercise("Overhead Press", "Shoulder development")
                .addExercise("Barbell Rows", "Back thickness");
        return builder.build();
    }
    
    public WorkoutPlan createFlexibilityPlan(WorkoutPlanBuilder builder) {
        builder.reset();
        builder.setName("Flexibility and Mobility Program")
                .setLevel("beginner")
                .setIntensity("low")
                .setDurationMinutes(30)
                .setGoal("flexibility")
                .addExercise("Dynamic Stretching", "Warm-up movements")
                .addExercise("Yoga Poses", "Improve flexibility")
                .addExercise("Foam Rolling", "Muscle recovery");
        return builder.build();
    }
}