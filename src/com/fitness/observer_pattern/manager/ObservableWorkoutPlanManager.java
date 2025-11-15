
package com.fitness.observer_pattern.manager;

import com.fitness.factory_pattern.interfaces.WorkoutPlanFactory;
import com.fitness.factory_pattern.concreteFactory.StandardWorkoutPlanFactory;
import com.fitness.builder_pattern.product.WorkoutPlan;
import com.fitness.builder_pattern.builder.WorkoutPlanBuilder;
import com.fitness.observer_pattern.interfaces.WorkoutPlanObserver;
import com.fitness.observer_pattern.interfaces.WorkoutPlanSubject;

import java.util.ArrayList;
import java.util.List;

public class ObservableWorkoutPlanManager implements WorkoutPlanSubject {
    private WorkoutPlanFactory factory;
    private List<WorkoutPlanObserver> observers = new ArrayList<>();

    public ObservableWorkoutPlanManager() {
        this.factory = new StandardWorkoutPlanFactory();
    }
    
    public ObservableWorkoutPlanManager(WorkoutPlanFactory factory) {
        this.factory = factory;
    }

    public void setObservers(List<WorkoutPlanObserver> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(WorkoutPlanObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WorkoutPlanObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (WorkoutPlanObserver observer : observers) {
            observer.update(message, null);
        }
    }

    private void notifyObservers(String message, WorkoutPlan plan) {
        for (WorkoutPlanObserver observer : observers) {
            observer.update(message, plan);
        }
    }

    public WorkoutPlan getPredefinedPlan(String planType) {
        WorkoutPlan plan = factory.createPlan(planType);
        notifyObservers("New workout plan created: " + planType, plan);
        return plan;
    }
    
    public WorkoutPlanBuilder getBuilderForCustomPlan() {
        notifyObservers("Custom workout builder requested");
        return factory.getBuilder("custom");
    }
    
    public WorkoutPlan createCustomPlan(String name, String level, String intensity, 
                                      int duration, String goal) {
        WorkoutPlanBuilder builder = getBuilderForCustomPlan();
        WorkoutPlan plan = builder.setName(name)
                     .setLevel(level)
                     .setIntensity(intensity)
                     .setDurationMinutes(duration)
                     .setGoal(goal)
                     .build();
        notifyObservers("Custom workout plan created: " + name, plan);
        return plan;
    }

    public void setFactory(WorkoutPlanFactory factory) {
        this.factory = factory;
        notifyObservers("Workout plan factory changed");
    }
}