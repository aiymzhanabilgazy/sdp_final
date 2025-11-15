package com.fitness.observer_pattern.concreteObservers;

import com.fitness.observer_pattern.interfaces.WorkoutPlanObserver;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class ProgressTrackingObserver implements WorkoutPlanObserver {
    private int plansCreated = 0;
    private int totalExercises = 0;

    @Override
    public void update(String message, WorkoutPlan plan) {
        if (message.contains("created") && plan != null) {
            plansCreated++;
            totalExercises += plan.getExercises().size();
            
            System.out.println("Progress Update:");
            System.out.println("-> Total Plans Created: " + plansCreated);
            System.out.println("-> Total Exercises: " + totalExercises);
            System.out.println("-> Average Exercises per Plan: " +
                             (plansCreated > 0 ? totalExercises / plansCreated : 0));
        }
    }

    public int getPlansCreated() { return plansCreated; }
    public int getTotalExercises() { return totalExercises; }
}