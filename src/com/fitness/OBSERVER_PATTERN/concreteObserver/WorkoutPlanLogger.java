package com.fitness.OBSERVER_PATTERN.concreteObserver;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.IWorkoutPlanObserver;

public class WorkoutPlanLogger implements IWorkoutPlanObserver {

    @Override
    public void update(WorkoutPlan plan) {
        System.out.println("[LOGGER] New plan created : " + plan.getName());
    }
    @Override
    public void onHeartRateUpdate(int heartRate) {
        System.out.println("[LOGGER] Heart rate updated: " + heartRate);
    }

}
