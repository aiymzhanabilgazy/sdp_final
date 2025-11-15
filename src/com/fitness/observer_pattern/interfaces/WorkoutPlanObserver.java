
package com.fitness.observer_pattern.interfaces;

import com.fitness.builder_pattern.product.WorkoutPlan;

public interface WorkoutPlanObserver {
    void update(String message, WorkoutPlan plan);
}