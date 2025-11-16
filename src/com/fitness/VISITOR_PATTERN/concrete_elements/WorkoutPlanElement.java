package com.fitness.VISITOR_PATTERN.concrete_elements;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;
import com.fitness.VISITOR_PATTERN.elements.IWorkoutElement;
import com.fitness.VISITOR_PATTERN.visitors.IWorkoutVisitor;

public class WorkoutPlanElement implements IWorkoutElement {

    private final WorkoutPlan plan;

    public WorkoutPlanElement(WorkoutPlan plan) {
        this.plan = plan;
    }

    public WorkoutPlan getPlan() {
        return plan;
    }

    @Override
    public void accept(IWorkoutVisitor visitor) {
        visitor.visitWorkoutPlan(this);

        // visit each exercise
        plan.getExercises().forEach(ex ->
                new ExerciseElement(ex).accept(visitor)
        );
    }
}
