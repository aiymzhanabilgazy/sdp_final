
package com.fitness.VISITOR_PATTERN.concrete_visitors;

import com.fitness.VISITOR_PATTERN.concrete_elements.ExerciseElement;
import com.fitness.VISITOR_PATTERN.concrete_elements.WorkoutPlanElement;
import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;

public class MaxCaloriesVisitor implements IWorkoutVisitor {

    private ExerciseElement maxExercise;
    private int maxCalories = 0;

    @Override
    public void visitExercise(ExerciseElement exercise) {
        if (exercise.getCaloriesBurned() > maxCalories) {
            maxCalories = exercise.getCaloriesBurned();
            maxExercise = exercise;
        }
    }

    @Override
    public void visitWorkoutPlan(WorkoutPlanElement plan) {
        // обработка не нужна
    }

    public ExerciseElement getMaxExercise() {
        return maxExercise;
    }
}
