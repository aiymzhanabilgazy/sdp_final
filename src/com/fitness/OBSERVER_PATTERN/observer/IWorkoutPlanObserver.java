package com.fitness.OBSERVER_PATTERN.observer;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public interface IWorkoutPlanObserver {
    void update(WorkoutPlan plan);
}
