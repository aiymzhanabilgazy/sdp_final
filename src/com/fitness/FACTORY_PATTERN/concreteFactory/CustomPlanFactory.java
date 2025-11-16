package com.fitness.FACTORY_PATTERN.concreteFactory;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.CustomWorkoutPlanBuilder;
import com.fitness.FACTORY_PATTERN.factory.IWorkoutPlanFactory;

public class CustomPlanFactory implements IWorkoutPlanFactory {

    @Override
    public IWorkoutPlanBuilder createBuilder() {
        return new CustomWorkoutPlanBuilder();
    }
}
