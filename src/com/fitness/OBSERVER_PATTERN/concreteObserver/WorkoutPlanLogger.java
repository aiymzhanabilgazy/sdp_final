package com.fitness.OBSERVER_PATTERN.concreteObserver;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.WorkoutPlanObserver;

public class WorkoutPlanLogger implements WorkoutPlanObserver {

    @Override
    public void onPlanCreated(WorkoutPlan plan) {
        System.out.println("[LOG] Workout plan created: " + plan.getName());
    }
}
