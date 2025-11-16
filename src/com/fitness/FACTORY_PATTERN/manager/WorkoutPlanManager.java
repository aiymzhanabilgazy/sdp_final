package com.fitness.FACTORY_PATTERN.manager;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.factory.WorkoutPlanFactory;
import com.fitness.OBSERVER_PATTERN.subject.WorkoutPlanEventManager;

public class WorkoutPlanManager {

    private final WorkoutPlanFactory factory;
    private final WorkoutPlanEventManager eventManager;

    public WorkoutPlanManager(WorkoutPlanFactory factory, WorkoutPlanEventManager eventManager) {
        this.factory = factory;
        this.eventManager = eventManager;
    }

    public WorkoutPlanBuilder newPlanBuilder() {
        return factory.createBuilder();
    }

    public WorkoutPlan buildPlan(WorkoutPlanBuilder builder) {
        WorkoutPlan plan = builder.build();
        eventManager.notifyAll(plan);
        return plan;
    }
}
