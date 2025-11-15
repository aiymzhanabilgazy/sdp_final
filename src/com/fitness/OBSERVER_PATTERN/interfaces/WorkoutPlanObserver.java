
package com.fitness.OBSERVER_PATTERN.interfaces;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public interface WorkoutPlanObserver {
    void update(String message, WorkoutPlan plan);
}