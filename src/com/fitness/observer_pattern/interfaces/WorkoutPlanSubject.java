
package com.fitness.observer_pattern.interfaces;

import com.fitness.observer_pattern.interfaces.WorkoutPlanObserver;

public interface WorkoutPlanSubject {
    void registerObserver(WorkoutPlanObserver observer);
    void removeObserver(WorkoutPlanObserver observer);
    void notifyObservers(String message);
}