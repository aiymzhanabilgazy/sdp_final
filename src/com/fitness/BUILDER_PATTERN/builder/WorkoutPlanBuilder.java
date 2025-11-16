package com.fitness.BUILDER_PATTERN.builder;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public interface WorkoutPlanBuilder {

    WorkoutPlanBuilder reset();  // <<<< ИСПРАВЛЕНИЕ

    WorkoutPlanBuilder setName(String name);
    WorkoutPlanBuilder setLevel(String level);
    WorkoutPlanBuilder setIntensity(String intensity);
    WorkoutPlanBuilder setDurationMinutes(int minutes);
    WorkoutPlanBuilder setGoal(String goal);
    WorkoutPlanBuilder addExercise(String name, String description);

    WorkoutPlan build();
}
