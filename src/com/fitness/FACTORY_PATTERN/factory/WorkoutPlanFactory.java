package com.fitness.FACTORY_PATTERN.factory;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;

public interface WorkoutPlanFactory {
    WorkoutPlanBuilder createBuilder();
}
