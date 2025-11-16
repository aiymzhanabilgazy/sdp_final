package com.fitness.FACTORY_PATTERN.concreteFactory;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.BeginnerWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.CustomWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.director.*;
import com.fitness.FACTORY_PATTERN.interfaces.PlanDirector;
import com.fitness.FACTORY_PATTERN.interfaces.WorkoutPlanFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class StandardWorkoutPlanFactory implements WorkoutPlanFactory {
    private final Map<String, Supplier<WorkoutPlanBuilder>> builderRegistry = new HashMap<>();
    private final Map<String, PlanDirector> planRegistry = new HashMap<>();

    public StandardWorkoutPlanFactory() {
        registerBuilder("beginner", BeginnerWorkoutPlanBuilder::new);
        registerBuilder("custom", CustomWorkoutPlanBuilder::new);
        registerBuilder("fatloss", CustomWorkoutPlanBuilder::new);
        registerBuilder("strength", CustomWorkoutPlanBuilder::new);
        registerBuilder("cardio", CustomWorkoutPlanBuilder::new);

        registerPlan("beginner", new DefaultPlanDirector());
        registerPlan("custom", new DefaultPlanDirector());
        registerPlan("fatloss", new FatLossPlanDirector());
        registerPlan("strength", new StrengthPlanDirector());
        registerPlan("cardio", new CardioPlanDirector());
        registerPlan("default", new DefaultPlanDirector());
    }

    private void registerBuilder(String key, Supplier<WorkoutPlanBuilder> supplier) {
        builderRegistry.put(key.toLowerCase(), supplier);
    }

    private void registerPlan(String key, PlanDirector director) {
        planRegistry.put(key.toLowerCase(), director);
    }

    @Override
    public WorkoutPlan createPlan(String planType) {
        String key = planType.toLowerCase();

        WorkoutPlanBuilder builder =
                builderRegistry.getOrDefault(key, builderRegistry.get("custom")).get();

        PlanDirector director =
                planRegistry.getOrDefault(key, planRegistry.get("default"));

        return director.create(builder);
    }

    @Override
    public WorkoutPlanBuilder getBuilder(String type) {
        return builderRegistry
                .getOrDefault(type.toLowerCase(), builderRegistry.get("custom"))
                .get();
    }
}
