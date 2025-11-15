package com.fitness.observer_pattern.concreteObservers;

import com.fitness.observer_pattern.interfaces.WorkoutPlanObserver;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class LoggingObserver implements WorkoutPlanObserver {
    @Override
    public void update(String message, WorkoutPlan plan) {
        System.out.println("LOG: " + message + " | Timestamp: " + java.time.LocalDateTime.now());
        if (plan != null) {
            System.out.println("Plan: " + plan.getName() +
                             ", Level: " + plan.getLevel() + 
                             ", Duration: " + plan.getDurationMinutes() + "min");
        }
    }
}