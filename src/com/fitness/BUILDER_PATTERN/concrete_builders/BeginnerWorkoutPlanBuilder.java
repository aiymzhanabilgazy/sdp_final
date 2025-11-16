package com.fitness.BUILDER_PATTERN.concrete_builders;

public class BeginnerWorkoutPlanBuilder extends CustomWorkoutPlanBuilder {
    private String name = "Beginner Workout Program";
    private String level = "beginner";
    private String intensity = "low";
    private int duration = 30;
    private String goal = "foundation";

    @Override
    public void reset() {
        super.reset();

        setName(name);
        setLevel(level);
        setIntensity(intensity);
        setDurationMinutes(duration);
        setGoal(goal);

        addExercise("Jumping Jacks", "Light full-body warmup");
        addExercise("Bodyweight Squats", "Basic lower-body strength");
        addExercise("Knee Push-ups", "Beginner upper-body strength");

    }
}