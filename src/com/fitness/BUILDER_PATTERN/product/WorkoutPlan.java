package com.fitness.BUILDER_PATTERN.product;
import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan {

    private String name;
    private String level;
    private String intensity;
    private int durationMinutes;
    private String goal;
    private List<Exercise> exercises = new ArrayList<>();

    public String getName() { return name; }
    public String getLevel() { return level; }
    public String getIntensity() { return intensity; }
    public int getDurationMinutes() { return durationMinutes; }
    public String getGoal() { return goal; }
    public List<Exercise> getExercises() { return exercises; }

    public void setName(String name) { this.name = name; }
    public void setLevel(String level) { this.level = level; }
    public void setIntensity(String intensity) { this.intensity = intensity; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setGoal(String goal) { this.goal = goal; }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    @Override
    public String toString() {
        return "\nWorkoutPlan {" +
                "\n  name='" + name + '\'' +
                ",\n  level='" + level + '\'' +
                ",\n  intensity='" + intensity + '\'' +
                ",\n  duration=" + durationMinutes +
                ",\n  goal='" + goal + '\'' +
                ",\n  exercises=" + exercises +
                "\n}";
    }
}