package com.fitness.builder_pattern.concrete_builders;

import com.fitness.builder_pattern.builder.WorkoutPlanBuilder;
import com.fitness.builder_pattern.product.Exercise;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class CustomWorkoutPlanBuilder implements WorkoutPlanBuilder {

    protected WorkoutPlan plan;

    public CustomWorkoutPlanBuilder() {
        reset();
    }

    @Override
    public void reset() {
        plan = new WorkoutPlan();
    }

    @Override
    public WorkoutPlanBuilder setName(String name) {
        plan.setName(name);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setLevel(String level) {
        plan.setLevel(level);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setIntensity(String intensity) {
        plan.setIntensity(intensity);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setDurationMinutes(int minutes) {
        plan.setDurationMinutes(minutes);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setGoal(String goal) {
        plan.setGoal(goal);
        return this;
    }

    @Override
    public WorkoutPlanBuilder addExercise(String name, String description) {
        plan.addExercise(new Exercise(name, description));
        return this;
    }

    @Override
    public WorkoutPlan build() {
        WorkoutPlan result = plan;
        reset(); // allows builder reuse
        return result;
    }
}