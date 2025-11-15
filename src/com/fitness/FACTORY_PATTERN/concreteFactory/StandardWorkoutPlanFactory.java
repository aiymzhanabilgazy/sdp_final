package com.fitness.FACTORY_PATTERN.concreteFactory;

import com.fitness.BUILDER_PATTERN.builder.WorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.BeginnerWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.concrete_builders.CustomWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.director.WorkoutPlanDirector;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.FACTORY_PATTERN.interfaces.WorkoutPlanFactory;

public class StandardWorkoutPlanFactory implements WorkoutPlanFactory {

    private final WorkoutPlanDirector director;

    public StandardWorkoutPlanFactory() {
        this.director = new WorkoutPlanDirector();
    }

    @Override
    public WorkoutPlan createPlan(String planType) {
        WorkoutPlanBuilder builder = getBuilder(planType);

        switch (planType.toLowerCase()) {
            case "beginner":
                return ((BeginnerWorkoutPlanBuilder) builder).build();

            case "fatloss":
                return director.createFatLossPlan(builder);

            case "custom":
                // Return empty custom builder for manual configuration
                return builder.build();

            case "strength":
                return createStrengthPlan(builder);

            case "cardio":
                return createCardioPlan(builder);

            default:
                return createDefaultPlan(builder); // Return default plan instead of throwing exception
        }
    }

    @Override
    public WorkoutPlanBuilder getBuilder(String builderType) {
        switch (builderType.toLowerCase()) {
            case "beginner":
                return new BeginnerWorkoutPlanBuilder();

            case "fatloss":
            case "strength":
            case "cardio":
            case "custom":
                return new CustomWorkoutPlanBuilder();

            default:
                return new CustomWorkoutPlanBuilder(); // Return default builder instead of throwing exception
        }
    }

    private WorkoutPlan createStrengthPlan(WorkoutPlanBuilder builder) {
        builder.reset();
        builder.setName("Strength Building Program")
                .setLevel("intermediate")
                .setIntensity("high")
                .setDurationMinutes(60)
                .setGoal("strength")
                .addExercise("Barbell Squats", "Heavy compound movement")
                .addExercise("Bench Press", "Upper body strength")
                .addExercise("Deadlifts", "Posterior chain development");
        return builder.build();
    }

    private WorkoutPlan createCardioPlan(WorkoutPlanBuilder builder) {
        builder.reset();
        builder.setName("Cardio Endurance Program")
                .setLevel("beginner")
                .setIntensity("medium")
                .setDurationMinutes(40)
                .setGoal("endurance")
                .addExercise("Running", "30 minutes steady state")
                .addExercise("Cycling", "Interval training")
                .addExercise("Jump Rope", "Coordination and cardio");
        return builder.build();
    }

    private WorkoutPlan createDefaultPlan(WorkoutPlanBuilder builder) {
        builder.reset();
        builder.setName("Default Workout Program")
                .setLevel("beginner")
                .setIntensity("medium")
                .setDurationMinutes(30)
                .setGoal("general-fitness")
                .addExercise("Walking", "Light cardio exercise")
                .addExercise("Stretching", "Basic flexibility");
        return builder.build();
    }
}