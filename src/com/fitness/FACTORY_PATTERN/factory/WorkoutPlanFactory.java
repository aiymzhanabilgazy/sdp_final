package com.fitness.FACTORY_PATTERN.factory;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;

public interface WorkoutPlanFactory {
    IWorkoutPlanBuilder createBuilder();
}
