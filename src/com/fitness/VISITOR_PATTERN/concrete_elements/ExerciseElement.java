package com.fitness.VISITOR_PATTERN.concrete_elements;

import com.fitness.VISITOR_PATTERN.elements.IWorkoutElement;
import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;
import com.fitness.BUILDER_PATTERN.product.Exercise;

public class ExerciseElement implements IWorkoutElement {

    private final Exercise exercise;

    public ExerciseElement(Exercise exercise) {
        this.exercise = exercise;
    }

    public String getName() {
        return exercise.getName();
    }

    public int getCaloriesBurned() {
        return exercise.getCalories();
    }

    @Override
    public void accept(IWorkoutVisitor visitor) {
        visitor.visitExercise(this);
    }
}
