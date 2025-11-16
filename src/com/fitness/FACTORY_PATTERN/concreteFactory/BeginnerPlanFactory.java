package com.fitness.FACTORY_PATTERN.concreteFactory;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.WorkoutPlanConcreteBuilder;
import com.fitness.FACTORY_PATTERN.factory.WorkoutPlanFactory;

public class BeginnerPlanFactory implements WorkoutPlanFactory {

    @Override
    public WorkoutPlanBuilder createBuilder() {
        return new WorkoutPlanConcreteBuilder();
    }
}
