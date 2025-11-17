package com.fitness.OBSERVER_PATTERN.subject;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.OBSERVER_PATTERN.observer.IWorkoutPlanObserver;

public interface IWorkoutPlanPublisher {

    void subscribe(IWorkoutPlanObserver observer);

    void unsubscribe(IWorkoutPlanObserver observer);

    void notifyObservers(WorkoutPlan plan);

    void notifyHeartRate(int heartRate);
}
