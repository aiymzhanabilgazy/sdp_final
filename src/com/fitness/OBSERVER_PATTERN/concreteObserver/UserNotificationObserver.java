package com.fitness.OBSERVER_PATTERN.concreteObserver;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.IWorkoutPlanObserver;

public class UserNotificationObserver implements IWorkoutPlanObserver {

    private String username;

    public UserNotificationObserver(String username) {
        this.username = username;
    }

    @Override
    public void update(WorkoutPlan plan) {
        System.out.println("[NOTIFY] " + username +
                ", your new workout plan is ready: " + plan.getName());
    }
}
