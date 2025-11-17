package com.fitness.OBSERVER_PATTERN.concreteObserver;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.IWorkoutPlanObserver;

public class UserNotificationObserver implements IWorkoutPlanObserver {

    private String username;
    private String targetType;

    public UserNotificationObserver(String username,String targetType) {
        this.username = username;
        this.targetType = targetType;
    }

    @Override
    public void update(WorkoutPlan plan) {
        if (plan.getLevel().equalsIgnoreCase(targetType) ||
                plan.getGoal().equalsIgnoreCase(targetType)) {
            System.out.println("[NOTIFY] " + username + ", your new workout plan is ready: " + plan.getName());
        }
    }
    @Override
    public void onHeartRateUpdate(int hr) {
        System.out.println("[HEART-RATE] " + username + ", your current heart rate is: " + hr + " bpm");
    }
}
