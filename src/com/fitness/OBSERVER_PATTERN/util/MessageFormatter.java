package com.fitness.OBSERVER_PATTERN.util;

import com.fitness.OBSERVER_PATTERN.config.NotificationEvent;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

public class MessageFormatter {

    public static String format(NotificationEvent event, WorkoutPlan plan, String customMessage) {
        return switch (event) {
            case PLAN_CREATED -> "A predefined plan was created: " + plan.getName();
            case CUSTOM_PLAN_CREATED -> "A custom plan was created: " + plan.getName();
            case BUILDER_REQUESTED -> "A custom builder was requested";
            case FACTORY_CHANGED -> "Workout plan factory has been updated";
            case GENERIC -> customMessage != null ? customMessage : "Update received";
        };
    }
}
