package com.fitness;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.WorkoutPlanConcreteBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class Client{
    public static void main(String[] args) {
        WorkoutPlanBuilder builder = new WorkoutPlanConcreteBuilder();

        WorkoutPlan beginnerPlan = builder
                .setName("Beginner Workout Program")
                .setLevel("beginner")
                .setIntensity("low")
                .setDurationMinutes(25)
                .setGoal("foundation")
                .addExercise("Jumping Jacks", "Light full-body warm-up")
                .addExercise("Bodyweight Squats", "Lower body strength")
                .addExercise("Knee Push-ups", "Beginner upper-body training")
                .build();

        System.out.println("=== BEGINNER PLAN ===");
        System.out.println(beginnerPlan);

        WorkoutPlan fatLossPlan = builder
                .setName("Fat Loss Intense Program")
                .setLevel("intermediate")
                .setIntensity("high")
                .setDurationMinutes(45)
                .setGoal("fat-loss")
                .addExercise("Burpees", "High intensity cardio")
                .addExercise("Mountain Climbers", "Core + cardio")
                .addExercise("Jump Squats", "Explosive plyometrics")
                .build();

        System.out.println("\n=== FAT LOSS PLAN ===");
        System.out.println(fatLossPlan);

    }
}
