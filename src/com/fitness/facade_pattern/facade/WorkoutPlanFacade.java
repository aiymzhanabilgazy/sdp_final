package com.fitness.facade_pattern.facade;

import com.fitness.builder_pattern.builder.WorkoutPlanBuilder;
import com.fitness.builder_pattern.concrete_builders.BeginnerWorkoutPlanBuilder;
import com.fitness.builder_pattern.concrete_builders.CustomWorkoutPlanBuilder;
import com.fitness.builder_pattern.director.WorkoutPlanDirector;
import com.fitness.builder_pattern.product.WorkoutPlan;
import com.fitness.facade_pattern.model.ExerciseConfig;
import com.fitness.facade_pattern.model.WorkoutPlanConfiguration;

public class WorkoutPlanFacade {
    private final WorkoutPlanDirector director;

    public WorkoutPlanFacade() {
        this.director = new WorkoutPlanDirector();
    }

    public WorkoutPlan createBeginnerPlan() {
        return new BeginnerWorkoutPlanBuilder().build();
    }

    public WorkoutPlan createFatLossPlan() {
        return director.createFatLossPlan(new CustomWorkoutPlanBuilder());
    }

    public WorkoutPlan createCustomPlan(WorkoutPlanConfiguration configuration) {
        WorkoutPlanBuilder builder = createConfiguredBuilder(configuration);
        addExercises(builder, configuration.getExercises());
        return builder.build();
    }

    public WorkoutPlan createQuickPlan(String level, String goal, int duration) {
        String planName = String.format("%s %s Quick Workout", capitalizeFirst(level), capitalizeFirst(goal));
        String intensity = calculateIntensity(level, duration);

        WorkoutPlanConfiguration config = WorkoutPlanConfiguration.builder()
                .name(planName)
                .level(level.toLowerCase())
                .goal(goal.toLowerCase())
                .durationMinutes(duration)
                .intensity(intensity)
                .build();

        return createConfiguredBuilder(config).build();
    }

    private WorkoutPlanBuilder createConfiguredBuilder(WorkoutPlanConfiguration configuration) {
        WorkoutPlanBuilder builder = new CustomWorkoutPlanBuilder();
        builder.reset();
        builder.setName(configuration.getName())
                .setLevel(configuration.getLevel())
                .setIntensity(configuration.getIntensity())
                .setDurationMinutes(configuration.getDurationMinutes())
                .setGoal(configuration.getGoal());
        return builder;
    }

    private void addExercises(WorkoutPlanBuilder builder, java.util.List<ExerciseConfig> exercises) {
        exercises.forEach(exercise ->
                builder.addExercise(exercise.getName(), exercise.getDescription())
        );
    }

    private String calculateIntensity(String level, int duration) {
        if ("beginner".equalsIgnoreCase(level)) {
            return duration > 40 ? "medium" : "low";
        } else if ("intermediate".equalsIgnoreCase(level)) {
            return duration > 50 ? "high" : "medium";
        } else {
            return "high";
        }
    }

    private String capitalizeFirst(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}