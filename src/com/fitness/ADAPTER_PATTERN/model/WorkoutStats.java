package com.fitness.ADAPTER_PATTERN.model;

public class WorkoutStats {

    private final String workoutName;
    private final int caloriesBurned;
    private final int durationMinutes;

    public WorkoutStats(String workoutName, int caloriesBurned, int durationMinutes) {
        this.workoutName = workoutName;
        this.caloriesBurned = caloriesBurned;
        this.durationMinutes = durationMinutes;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "\nWorkoutStats {" +
                "\n  workoutName='" + workoutName + '\'' +
                ",\n  caloriesBurned=" + caloriesBurned +
                ",\n  durationMinutes=" + durationMinutes +
                "\n}";
    }
}
