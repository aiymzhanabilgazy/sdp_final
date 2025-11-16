package com.fitness.FACTORY_PATTERN.interfaces;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public interface PlanDirector {
    WorkoutPlan create(WorkoutPlanBuilder builder);
}
