package com.fitness.VISITOR_PATTERN.concrete_visitors;

import com.fitness.VISITOR_PATTERN.concrete_elements.ExerciseElement;
import com.fitness.VISITOR_PATTERN.concrete_elements.WorkoutPlanElement;
import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;

public class ExerciseCountVisitor implements IWorkoutVisitor {

    private int count = 0;

    @Override
    public void visitExercise(ExerciseElement exercise) {
        count++;
    }

    @Override
    public void visitWorkoutPlan(WorkoutPlanElement plan) {
    }

    public int getCount() {
        return count;
    }
}
