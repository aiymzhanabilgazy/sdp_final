package com.fitness.BUILDER_PATTERN.product;

public class Exercise {

    private String name;
    private String description;
    private int calories;

    public Exercise(String name, String description, int calories) {
        this.name = name;
        this.description = description;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " (" + description + ", " + calories + " kcal)";
    }
}
