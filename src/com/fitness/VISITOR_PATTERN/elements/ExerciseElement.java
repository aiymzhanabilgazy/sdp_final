package com.fitness.VISITOR_PATTERN.elements;

public class ExerciseElement implements WorkoutElement{
    private String name;
    private int caloriesBurned;

    public ExerciseElement(String name, int caloriesBurned) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
    }
    public String getName() {
        return name;
    }
    public int getCaloriesBurned() {
        return caloriesBurned;
    }
    @Override
    public void accept(com.fitness.VISITOR_PATTERN.visitors.WorkoutVisitor visitor) {
        visitor.visitExercise(this);
    }
    @Override
    public String toString() {
        return name + " " + caloriesBurned + " calories";
    }
}
