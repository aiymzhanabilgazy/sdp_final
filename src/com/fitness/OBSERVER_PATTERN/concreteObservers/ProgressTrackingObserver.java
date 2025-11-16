package com.fitness.OBSERVER_PATTERN.concreteObservers;

import com.fitness.OBSERVER_PATTERN.interfaces.WorkoutPlanObserver;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class ProgressTrackingObserver implements WorkoutPlanObserver {

    private int plansCreated = 0;
    private int totalExercises = 0;

    @Override
    public void update(String message, WorkoutPlan plan) {
        if (plan == null) return;

        plansCreated++;
        totalExercises += plan.getExercises().size();

        print("Progress Update:");
        print("Total Plans: " + plansCreated);
        print("Total Exercises: " + totalExercises);
        print("Avg Exercises/Plan: " + (totalExercises / plansCreated));
    }

    private void print(String s) {
        System.out.println("[PROGRESS] " + s);
    }
}
