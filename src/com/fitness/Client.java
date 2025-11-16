package com.fitness;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.concreteFactory.BeginnerPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.CustomPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.FatLossPlanFactory;
import com.fitness.FACTORY_PATTERN.manager.WorkoutPlanManager;
import com.fitness.OBSERVER_PATTERN.subject.WorkoutPlanEventManager;
import com.fitness.OBSERVER_PATTERN.concreteObserver.WorkoutPlanLogger;

public class Client {

    public static void main(String[] args) {

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
