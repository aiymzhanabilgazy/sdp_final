package com.fitness.OBSERVER_PATTERN.concreteObservers;

import com.fitness.OBSERVER_PATTERN.interfaces.WorkoutPlanObserver;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

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