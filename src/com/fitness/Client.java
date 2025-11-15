package com.fitness;

import com.fitness.facade_pattern.facade.WorkoutPlanFacade;
import com.fitness.facade_pattern.model.WorkoutPlanConfiguration;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class Client {
    public static void main(String[] args) {
        WorkoutPlanFacade workoutFacade = new WorkoutPlanFacade();

        // Pre-defined plans
        WorkoutPlan beginner = workoutFacade.createBeginnerPlan();
        WorkoutPlan fatLoss = workoutFacade.createFatLossPlan();

        System.out.println("Beginner Plan: " + beginner);
        System.out.println("Fat Loss Plan: " + fatLoss);

        // Quick plan creation
        WorkoutPlan quickPlan = workoutFacade.createQuickPlan("intermediate", "strength", 40);
        System.out.println("Quick Plan: " + quickPlan);

        // Fully customized plan
        WorkoutPlan customPlan = workoutFacade.createCustomPlan(
                WorkoutPlanConfiguration.builder()
                        .name("My Personal Training Plan")
                        .level("advanced")
                        .intensity("high")
                        .durationMinutes(60)
                        .goal("muscle-building")
                        .addExercise("Bench Press", "Chest development")
                        .addExercise("Deadlifts", "Full body strength")
                        .addExercise("Pull-ups", "Back and arm strength")
                        .build()
        );

        System.out.println("Custom Plan: " + customPlan);
    }
}