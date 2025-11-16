package com.fitness.VISITOR_PATTERN.elements;

import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;

public interface IWorkoutElement {
    void accept(IWorkoutVisitor visitor);
}

