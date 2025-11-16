package com.fitness.OBSERVER_PATTERN.concreteObservers;

import com.fitness.OBSERVER_PATTERN.interfaces.WorkoutPlanObserver;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class LoggingObserver implements WorkoutPlanObserver {

    @Override
    public void update(String message, WorkoutPlan plan) {
        log(message);
        if (plan != null) log(formatPlan(plan));
    }

    private void log(String s) {
        System.out.println("[LOG] " + s);
    }

    private String formatPlan(WorkoutPlan plan) {
        return "Plan: " + plan.getName() +
                " | Level: " + plan.getLevel() +
                " | Duration: " + plan.getDurationMinutes() + "min";
    }
}
