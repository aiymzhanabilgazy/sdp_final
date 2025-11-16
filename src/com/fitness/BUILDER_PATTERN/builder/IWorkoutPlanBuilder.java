package com.fitness.BUILDER_PATTERN.builder;

import com.fitness.BUILDER_PATTERN.product.Exercise;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public interface IWorkoutPlanBuilder {
    void reset();

    void setName(String name);
    void setLevel(String level);
    void setIntensity(String intensity);
    void setDurationMinutes(int minutes);
    void setGoal(String goal);
    void addExercise(Exercise exercise);

    WorkoutPlan getResult();
}
