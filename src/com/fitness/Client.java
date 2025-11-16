package com.fitness;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.BeginnerWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.CustomWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.director.WorkoutPlanDirector;
import com.fitness.BUILDER_PATTERN.product.Exercise;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import java.util.List;

import com.fitness.FACTORY_PATTERN.concreteFactory.BeginnerPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.CustomPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.FatLossPlanFactory;
import com.fitness.FACTORY_PATTERN.manager.WorkoutPlanManager;
import com.fitness.OBSERVER_PATTERN.subject.WorkoutPlanEventManager;
import com.fitness.OBSERVER_PATTERN.concreteObserver.WorkoutPlanLogger;

public class Client {

    public static void main(String[] args) {
        WorkoutPlanDirector director = new WorkoutPlanDirector();
        IWorkoutPlanBuilder beginnerBuilder = new BeginnerWorkoutPlanBuilder();

        List<Exercise> beginnerExercises = List.of(
                new Exercise("Jumping Jacks","Light warm-up"),
                new Exercise("Bodyweight Squats", "Basic lower body strength"),
                new Exercise("Knee Push-ups", "Beginner upper body training")
        );
        director.buildPlan(
                beginnerBuilder,
                "Beginner Workout Program",
                "beginner",
                "low",
                25,
                "foundation",
                beginnerExercises
        );
        WorkoutPlan beginnerPlan = beginnerBuilder.getResult();
        System.out.println("\n===== BEGINNER PLAN =====");
        System.out.println(beginnerPlan);

        IWorkoutPlanBuilder customBuilder = new CustomWorkoutPlanBuilder();

        List<Exercise> fatLossExercises = List.of(
                new Exercise("Burpees", "High intensity cardio"),
                new Exercise("Mountain Climbers", "Core + cardio"),
                new Exercise("Jump Squats", "Explosive plyometrics")
        );

        director.buildPlan(
                customBuilder,
                "Fat Loss Intense Program",
                "intermediate",
                "high",
                45,
                "fat-loss",
                fatLossExercises
        );

        WorkoutPlan fatLossPlan = customBuilder.getResult();
        System.out.println("\n===== FAT LOSS PLAN =====");
        System.out.println(fatLossPlan);




        WorkoutPlanEventManager eventManager = new WorkoutPlanEventManager();
        eventManager.subscribe(new WorkoutPlanLogger());

        // ------------------------------------------------------
        // 1) BEGINNER PLAN
        // ------------------------------------------------------
        WorkoutPlanManager beginnerManager =
                new WorkoutPlanManager(new BeginnerPlanFactory(), eventManager);

        WorkoutPlan beginnerPlan = beginnerManager
                .newPlanBuilder()
                .build();

        System.out.println("\n=== BEGINNER PLAN ===");
        System.out.println(beginnerPlan);


        // ------------------------------------------------------
        // 2) FAT LOSS PLAN
        // ------------------------------------------------------
        WorkoutPlanManager fatLossManager =
                new WorkoutPlanManager(new FatLossPlanFactory(), eventManager);

        WorkoutPlan fatLossPlan = fatLossManager
                .newPlanBuilder()
                .build();

        System.out.println("\n=== FAT LOSS PLAN ===");
        System.out.println(fatLossPlan);


        // ------------------------------------------------------
        // 3) CUSTOM USER PLAN
        // ------------------------------------------------------
        WorkoutPlanManager customManager =
                new WorkoutPlanManager(new CustomPlanFactory(), eventManager);

        WorkoutPlan customPlan = customManager.newPlanBuilder()
                .setName("Mansur’s Custom Strength Program")
                .setLevel("advanced")
                .setIntensity("high")
                .setDurationMinutes(90)
                .setGoal("strength")
                .addExercise("Deadlift", "Strong posterior chain")
                .addExercise("Bench Press", "Chest building")
                .addExercise("Pull-ups", "Back & biceps")
                .addExercise("Plank", "Core stability")
                .build();

        System.out.println("\n=== CUSTOM PLAN ===");
        System.out.println(customPlan);
    }
}
