package com.fitness.BUILDER_PATTERN.builder;

public interface WorkoutPlanBuilder {
    void reset();

    WorkoutPlanBuilder setName(String name);
    WorkoutPlanBuilder setLevel(String level);
    WorkoutPlanBuilder setIntensity(String intensity);
    WorkoutPlanBuilder setDurationMinutes(int minutes);
    WorkoutPlanBuilder setGoal(String goal);
    WorkoutPlanBuilder addExercise(String name, String description);

    com.fitness.BUILDER_PATTERN.product.WorkoutPlan build();
}
