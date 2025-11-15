package com.fitness;

import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

import com.fitness.FACTORY_PATTERN.concreteFactory.StandardWorkoutPlanFactory;
import com.fitness.FACTORY_PATTERN.manager.WorkoutPlanManager;

import com.fitness.OBSERVER_PATTERN.manager.ObservableWorkoutPlanManager;
import com.fitness.OBSERVER_PATTERN.concreteObservers.UserNotificationObserver;
import com.fitness.OBSERVER_PATTERN.concreteObservers.ProgressTrackingObserver;
import com.fitness.OBSERVER_PATTERN.concreteObservers.LoggingObserver;

import com.fitness.FACADE_PATTERN.facade.WearableDeviceFacade;
import com.fitness.FACADE_PATTERN.subsystems.*;

import com.fitness.VISITOR_PATTERN.elements.ExerciseElement;
import com.fitness.VISITOR_PATTERN.concrete_visitors.CaloriesSumVisitor;

public class Client {

    public static void main(String[] args) {
        // --------------------------------------------------------
        //  WORKOUT PLANS CREATION
        // --------------------------------------------------------

        ObservableWorkoutPlanManager manager =
                new ObservableWorkoutPlanManager(new StandardWorkoutPlanFactory());

        // Register observers
        manager.registerObserver(new UserNotificationObserver("John Doe"));
        manager.registerObserver(new ProgressTrackingObserver());
        manager.registerObserver(new LoggingObserver());

        System.out.println("Creating predefined workout plans...\n");

        // Factory creates Beginner (uses Beginner builder)
        WorkoutPlan beginner = manager.getPredefinedPlan("beginner");

        // Factory uses Director to build FatLoss plan
        WorkoutPlan fatLoss = manager.getPredefinedPlan("fatloss");

        // Builder creates custom plan
        WorkoutPlan custom = manager.createCustomPlan(
                "My Personal Plan",
                "intermediate",
                "high",
                45,
                "weight-loss"
        );

        System.out.println("\n=== Final Plans Summary ===");
        System.out.println("Beginner Plan: " + beginner.getName());
        System.out.println("Fat Loss Plan: " + fatLoss.getName());
        System.out.println("Custom Plan:   " + custom.getName());


        // --------------------------------------------------------
        // 2. FACADE — COMBINE DATA FROM MULTIPLE DEVICES
        // --------------------------------------------------------
        WearableDeviceFacade facade = new WearableDeviceFacade();
        facade.registerDevice(new FitbitAPI("fitbit-001"));
        facade.registerDevice(new GarminAPI("garmin-002"));
        facade.registerDevice(new AppleHealthAPI("apple-003"));

        System.out.println("Average Heart Rate from all devices: " +
                facade.getAverageHeartRate());
        System.out.println("Total Steps from all devices: " +
                facade.getTotalSteps());
        System.out.println("Devices connected: " + facade.listDeviceIds());


        // --------------------------------------------------------
        // 3. VISITOR — CALORIES CALCULATION
        // --------------------------------------------------------
        ExerciseElement e1 = new ExerciseElement("Burpees", 120);
        ExerciseElement e2 = new ExerciseElement("Jump Rope", 200);
        ExerciseElement e3 = new ExerciseElement("Squats", 80);

        CaloriesSumVisitor caloriesVisitor = new CaloriesSumVisitor();

        e1.accept(caloriesVisitor);
        e2.accept(caloriesVisitor);
        e3.accept(caloriesVisitor);

        System.out.println("Total calories burned today: " +
                caloriesVisitor.getTotalCalories() + " kcal");


        // --------------------------------------------------------
        // END
        // --------------------------------------------------------
        System.out.println("\n=============================================");
        System.out.println("            SYSTEM DEMO FINISHED");
        System.out.println("=============================================");
    }
}
