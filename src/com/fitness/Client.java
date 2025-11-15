package com.fitness.client;

import com.fitness.observer_pattern.manager.ObservableWorkoutPlanManager;
import com.fitness.observer_pattern.concreteObservers.UserNotificationObserver;
import com.fitness.observer_pattern.concreteObservers.ProgressTrackingObserver;
import com.fitness.observer_pattern.concreteObservers.LoggingObserver;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class Client {
    public static void main(String[] args) {
        // Create observable manager
        ObservableWorkoutPlanManager manager = new ObservableWorkoutPlanManager();

        // Register observers
        manager.registerObserver(new UserNotificationObserver("John Doe"));
        manager.registerObserver(new ProgressTrackingObserver());
        manager.registerObserver(new LoggingObserver());

        System.out.println("=== Creating Workout Plans ===\n");

        // These will trigger all observers
        WorkoutPlan beginnerPlan = manager.getPredefinedPlan("beginner");
        WorkoutPlan fatLossPlan = manager.getPredefinedPlan("fatloss");
        WorkoutPlan customPlan = manager.createCustomPlan(
                "My Personal Plan", "intermediate", "high", 45, "weight-loss"
        );

        System.out.println("\n=== Plan Details ===");
        System.out.println("Beginner Plan: " + beginnerPlan.getName());
        System.out.println("Fat Loss Plan: " + fatLossPlan.getName());
        System.out.println("Custom Plan: " + customPlan.getName());
    }
}