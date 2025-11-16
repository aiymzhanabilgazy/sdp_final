package com.fitness.OBSERVER_PATTERN.manager;

import com.fitness.FACTORY_PATTERN.concreteFactory.StandardWorkoutPlanFactory;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.FACTORY_PATTERN.interfaces.WorkoutPlanFactory;
import com.fitness.OBSERVER_PATTERN.config.NotificationEvent;
import com.fitness.OBSERVER_PATTERN.interfaces.WorkoutPlanObserver;
import com.fitness.OBSERVER_PATTERN.interfaces.WorkoutPlanSubject;
import com.fitness.OBSERVER_PATTERN.util.MessageFormatter;

import java.util.ArrayList;
import java.util.List;

public class ObservableWorkoutPlanManager implements WorkoutPlanSubject {

    private WorkoutPlanFactory factory;
    private List<WorkoutPlanObserver> observers = new ArrayList<>();

    public ObservableWorkoutPlanManager(StandardWorkoutPlanFactory standardWorkoutPlanFactory) {
        this.factory = new StandardWorkoutPlanFactory();
    }

    public WorkoutPlan getPredefinedPlan(String type) {
        WorkoutPlan plan = factory.createPlan(type);
        notifyEvent(NotificationEvent.PLAN_CREATED, plan, null);
        return plan;
    }

    public WorkoutPlanBuilder getBuilderForCustomPlan() {
        notifyEvent(NotificationEvent.BUILDER_REQUESTED, null, null);
        return factory.getBuilder("custom");
    }

    public WorkoutPlan createCustomPlan(String name, String level, String intensity, int duration, String goal) {
        WorkoutPlanBuilder builder = getBuilderForCustomPlan();
        WorkoutPlan plan = builder
                .setName(name)
                .setLevel(level)
                .setIntensity(intensity)
                .setDurationMinutes(duration)
                .setGoal(goal).build();

        notifyEvent(NotificationEvent.CUSTOM_PLAN_CREATED, plan, null);
        return plan;
    }

    public void setFactory(WorkoutPlanFactory factory) {
        this.factory = factory;
        notifyEvent(NotificationEvent.FACTORY_CHANGED, null, null);
    }

    private void notifyEvent(NotificationEvent event, WorkoutPlan plan, String custom) {
        String msg = MessageFormatter.format(event, plan, custom);
        for (WorkoutPlanObserver o : observers) o.update(msg, plan);
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
    public void notifyObservers(String msg) {
        notifyEvent(NotificationEvent.GENERIC, null, msg);
    }
}
