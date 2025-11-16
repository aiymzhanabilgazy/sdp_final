package com.fitness.FACTORY_PATTERN.manager;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.factory.IWorkoutPlanFactory;
import com.fitness.OBSERVER_PATTERN.subject.IWorkoutPlanPublisher;

public class WorkoutPlanManager {

    private IWorkoutPlanFactory factory;
    private IWorkoutPlanPublisher publisher;

    public WorkoutPlanManager(IWorkoutPlanFactory factory, IWorkoutPlanPublisher publisher) {
        this.factory = factory;
        this.publisher = publisher;
    }

    public IWorkoutPlanBuilder newPlanBuilder() {
        return factory.createBuilder();
    }

    public WorkoutPlan finalizePlan(IWorkoutPlanBuilder builder) {
        WorkoutPlan plan = builder.getResult();
        publisher.notifyObservers(plan);
        return plan;
    }
}
