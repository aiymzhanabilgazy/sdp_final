package com.fitness.facade_pattern.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanConfiguration {
    private String name;
    private String level;
    private String intensity;
    private int durationMinutes;
    private String goal;
    private final List<ExerciseConfig> exercises;

    public WorkoutPlanConfiguration() {
        this.exercises = new ArrayList<>();
    }

    public static class Builder {
        private final WorkoutPlanConfiguration config;

        public Builder() {
            config = new WorkoutPlanConfiguration();
        }

        public Builder name(String name) {
            config.name = name;
            return this;
        }

        public Builder level(String level) {
            config.level = level;
            return this;
        }

        public Builder intensity(String intensity) {
            config.intensity = intensity;
            return this;
        }

        public Builder durationMinutes(int duration) {
            config.durationMinutes = duration;
            return this;
        }

        public Builder goal(String goal) {
            config.goal = goal;
            return this;
        }

        public Builder addExercise(String name, String description) {
            config.exercises.add(new ExerciseConfig(name, description));
            return this;
        }

        public WorkoutPlanConfiguration build() {
            return config;
        }
    }

    // Getters
    public String getName() { return name; }
    public String getLevel() { return level; }
    public String getIntensity() { return intensity; }
    public int getDurationMinutes() { return durationMinutes; }
    public String getGoal() { return goal; }
    public List<ExerciseConfig> getExercises() { return exercises; }

    public static Builder builder() {
        return new Builder();
    }
}