package com.fitness.OBSERVER_PATTERN.subject;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.WorkoutPlanObserver;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanEventManager {

    private final List<WorkoutPlanObserver> observers = new ArrayList<>();

    public void subscribe(WorkoutPlanObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(WorkoutPlanObserver observer) {
        observers.remove(observer);
    }

    public void notifyAll(WorkoutPlan plan) {
        for (WorkoutPlanObserver obs : observers) {
            obs.onPlanCreated(plan);
        }
    }
}
