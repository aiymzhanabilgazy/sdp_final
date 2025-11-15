package com.fitness.VISITOR_PATTERN.concrete_visitors;
import com.fitness.VISITOR_PATTERN.visitors.WorkoutVisitor;
import com.fitness.VISITOR_PATTERN.elements.ExerciseElement;

public class CaloriesSumVisitor implements WorkoutVisitor {
    private int totalCalories = 0;

    @Override
    public void visitExercise(ExerciseElement exercise) {
        totalCalories += exercise.getCaloriesBurned();
    }
    public int getTotalCalories() {
        return totalCalories;
    }
}
