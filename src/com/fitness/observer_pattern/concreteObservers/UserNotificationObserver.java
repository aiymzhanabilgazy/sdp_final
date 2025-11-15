package com.fitness.observer_pattern.concreteObservers;

import com.fitness.observer_pattern.interfaces.WorkoutPlanObserver;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class UserNotificationObserver implements WorkoutPlanObserver {
    private String userName;

    public UserNotificationObserver(String userName) {
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message, WorkoutPlan plan) {
        System.out.println("Notification for " + userName + ": " + message);
        if (plan != null) {
            System.out.println("-> Plan Details: " + plan.getName() +
                             " (" + plan.getExercises().size() + " exercises)\n");
        }
    }
}