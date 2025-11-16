package com.fitness.OBSERVER_PATTERN.observer;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public interface WorkoutPlanObserver {
    void onPlanCreated(WorkoutPlan plan);
}
