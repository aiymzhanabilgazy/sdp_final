package com.fitness.VISITOR_PATTERN.visitors;
import com.fitness.VISITOR_PATTERN.elements.ExerciseElement;

public interface WorkoutVisitor {
    void visitExercise(ExerciseElement exercise);
}
