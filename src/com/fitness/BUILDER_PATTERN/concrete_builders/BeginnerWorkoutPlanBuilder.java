package com.fitness.BUILDER_PATTERN.concrete_builders;

public class BeginnerWorkoutPlanBuilder extends CustomWorkoutPlanBuilder {

    @Override
    public void reset() {
        super.reset();

        setName("Beginner Workout Program");
        setLevel("beginner");
        setIntensity("low");
        setDurationMinutes(30);
        setGoal("foundation");

        addExercise("Jumping Jacks", "Light full-body warmup");
        addExercise("Bodyweight Squats", "Basic lower-body strength");
        addExercise("Knee Push-ups", "Beginner upper-body strength");
    }
}