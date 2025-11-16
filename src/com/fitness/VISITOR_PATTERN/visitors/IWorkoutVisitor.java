package com.fitness.VISITOR_PATTERN.visitors;

import com.fitness.VISITOR_PATTERN.concrete_elements.ExerciseElement;
import com.fitness.VISITOR_PATTERN.concrete_elements.WorkoutPlanElement;

public interface IWorkoutVisitor {
    void visitWorkoutPlan(WorkoutPlanElement plan);
    void visitExercise(ExerciseElement exercise);
}
