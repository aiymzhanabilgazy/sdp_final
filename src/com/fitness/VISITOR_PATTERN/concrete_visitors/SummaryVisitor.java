
package com.fitness.VISITOR_PATTERN.concrete_visitors;

import com.fitness.VISITOR_PATTERN.concrete_elements.ExerciseElement;
import com.fitness.VISITOR_PATTERN.concrete_elements.WorkoutPlanElement;
import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;

public class SummaryVisitor implements IWorkoutVisitor {

    private StringBuilder summary = new StringBuilder();
    private int totalCalories = 0;
    private int exerciseCount = 0;

    @Override
    public void visitWorkoutPlan(WorkoutPlanElement plan) {
        summary.append("Workout Summary for: ")
                .append(plan.getPlan().getName()).append("\n");
    }

    @Override
    public void visitExercise(ExerciseElement exercise) {
        exerciseCount++;
        totalCalories += exercise.getCaloriesBurned();
    }

    public String getSummary() {
        summary.append("Total exercises: ").append(exerciseCount).append("\n");
        summary.append("Total calories: ").append(totalCalories).append("\n");
        return summary.toString();
    }
}
