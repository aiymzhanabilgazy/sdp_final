package com.fitness.BUILDER_PATTERN.concrete_builders;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.BUILDER_PATTERN.product.Exercise;

public class CustomWorkoutPlanBuilder implements IWorkoutPlanBuilder {
    private WorkoutPlan plan;

    @Override
    public void reset() {
        plan = new WorkoutPlan();
    }
    @Override
    public void setName(String name) {
        plan.setName(name);
    }

    @Override
    public void setLevel(String level) {
        plan.setLevel(level);
    }

    @Override
    public void setIntensity(String intensity) {
        plan.setIntensity(intensity);
    }

    @Override
    public void setDurationMinutes(int minutes) {
        plan.setDurationMinutes(minutes);
    }

    @Override
    public void setGoal(String goal) {
        plan.setGoal(goal);
    }

    @Override
    public void addExercise(Exercise exercise) {
        plan.addExercise(exercise);
    }

    @Override
    public WorkoutPlan getResult() {
        return plan;
    }
}
