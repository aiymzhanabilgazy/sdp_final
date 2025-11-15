package com.fitness.FACTORY_PATTERN.manager;

import com.fitness.FACTORY_PATTERN.interfaces.WorkoutPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.StandardWorkoutPlanFactory;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;

public class WorkoutPlanManager {
    private WorkoutPlanFactory factory;

    public WorkoutPlanManager() {
        this.factory = new StandardWorkoutPlanFactory();
    }
    
    public WorkoutPlanManager(WorkoutPlanFactory factory) {
        this.factory = factory;
    }

    public void setValue(WorkoutPlanFactory factory) {
        this.factory = factory;
    }

    public WorkoutPlan getPredefinedPlan(String planType) {
        return factory.createPlan(planType);
    }
    
    public WorkoutPlanBuilder getBuilderForCustomPlan() {
        return factory.getBuilder("custom");
    }
    
    public WorkoutPlan createCustomPlan(String name, String level, String intensity, 
                                      int duration, String goal) {
        WorkoutPlanBuilder builder = getBuilderForCustomPlan();
        return builder.setName(name)
                     .setLevel(level)
                     .setIntensity(intensity)
                     .setDurationMinutes(duration)
                     .setGoal(goal)
                     .build();
    }
}