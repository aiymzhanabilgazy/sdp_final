package com.fitness.factory_pattern.interfaces;

import com.fitness.builder_pattern.builder.WorkoutPlanBuilder;
import com.fitness.builder_pattern.product.WorkoutPlan;

public interface WorkoutPlanFactory {
    WorkoutPlan createPlan(String planType);
    WorkoutPlanBuilder getBuilder(String builderType);
}