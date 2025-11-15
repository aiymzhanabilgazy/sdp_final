package com.fitness;
import com.fitness.builder_pattern.concrete_builders.BeginnerWorkoutPlanBuilder;
import com.fitness.builder_pattern.concrete_builders.CustomWorkoutPlanBuilder;
import com.fitness.builder_pattern.director.WorkoutPlanDirector;
import com.fitness.builder_pattern.product.WorkoutPlan;

public class Client {
    public static void main(String[] args) {
        WorkoutPlanDirector director = new WorkoutPlanDirector();

        WorkoutPlan beginner = new BeginnerWorkoutPlanBuilder().build();
        System.out.println(beginner);

        WorkoutPlan fatLoss = director.createFatLossPlan(new CustomWorkoutPlanBuilder());
        System.out.println(fatLoss);
    }
}
