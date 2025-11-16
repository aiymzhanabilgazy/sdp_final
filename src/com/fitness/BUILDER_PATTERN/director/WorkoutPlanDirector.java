package com.fitness.BUILDER_PATTERN.director;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.product.Exercise;

import java.util.List;

public class WorkoutPlanDirector {

    public void buildPlan(IWorkoutPlanBuilder builder,
                          String name,
                          String level,
                          String intensity,
                          int duration,
                          String goal,
                          List<Exercise> exercises) {

        builder.reset();
        builder.setName(name);
        builder.setLevel(level);
        builder.setIntensity(intensity);
        builder.setDurationMinutes(duration);
        builder.setGoal(goal);

        for (Exercise ex : exercises) {
            builder.addExercise(ex);
        }
    }
}

