package com.fitness.BUILDER_PATTERN.concrete_builders;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.Exercise;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;


public class WorkoutPlanConcreteBuilder implements WorkoutPlanBuilder {

    protected WorkoutPlan plan;

    public WorkoutPlanConcreteBuilder() {
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
        reset();
        return result;
    }
}