package com.fitness.VISITOR_PATTERN.concrete_visitors;

import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;
import com.fitness.VISITOR_PATTERN.concrete_elements.ExerciseElement;
import com.fitness.VISITOR_PATTERN.concrete_elements.WorkoutPlanElement;

public class CaloriesSumVisitor implements IWorkoutVisitor {

    private int totalCalories = 0;

    @Override
    public void visitWorkoutPlan(WorkoutPlanElement plan) {

    }

    @Override
    public void visitExercise(ExerciseElement ex) {
        totalCalories += ex.getCaloriesBurned();
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
