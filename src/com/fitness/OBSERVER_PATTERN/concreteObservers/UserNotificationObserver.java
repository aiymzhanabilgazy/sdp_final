package com.fitness.OBSERVER_PATTERN.concreteObservers;

import com.fitness.OBSERVER_PATTERN.interfaces.WorkoutPlanObserver;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class UserNotificationObserver implements WorkoutPlanObserver {

    private String userName;

    public UserNotificationObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message, WorkoutPlan plan) {
        notifyUser(message);
        if (plan != null) notifyUser(formatPlan(plan));
    }

    private void notifyUser(String text) {
        System.out.println("[NOTIFY] " + userName + ": " + text);
    }

    private String formatPlan(WorkoutPlan plan) {
        return "Plan: " + plan.getName() +
                " | Exercises: " + plan.getExercises().size() + "\n";
    }
}
