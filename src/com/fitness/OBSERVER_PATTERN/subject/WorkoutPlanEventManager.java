package com.fitness.OBSERVER_PATTERN.subject;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.IWorkoutPlanObserver;
import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanEventManager implements IWorkoutPlanPublisher {

    private List<IWorkoutPlanObserver> observers = new ArrayList<>();

    @Override
    public void subscribe(IWorkoutPlanObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(IWorkoutPlanObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(WorkoutPlan plan) {
        for (IWorkoutPlanObserver observer : observers) {
            observer.update(plan);
        }
    }
}
