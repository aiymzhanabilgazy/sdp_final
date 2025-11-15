
package com.fitness.OBSERVER_PATTERN.interfaces;

public interface WorkoutPlanSubject {
    void registerObserver(WorkoutPlanObserver observer);
    void removeObserver(WorkoutPlanObserver observer);
    void notifyObservers(String message);
}