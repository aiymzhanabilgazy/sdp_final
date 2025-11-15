package com.fitness.VISITOR_PATTERN.elements;
import com.fitness.VISITOR_PATTERN.visitors.WorkoutVisitor;

public interface WorkoutElement {
    void accept(WorkoutVisitor visitor);
}
