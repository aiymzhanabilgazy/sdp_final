package com.fitness;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.director.WorkoutPlanDirector;
import com.fitness.BUILDER_PATTERN.product.Exercise;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

import com.fitness.FACTORY_PATTERN.concreteFactory.BeginnerPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.CustomPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.FatLossPlanFactory;
import com.fitness.FACTORY_PATTERN.manager.WorkoutPlanManager;

import com.fitness.OBSERVER_PATTERN.subject.WorkoutPlanEventManager;
import com.fitness.OBSERVER_PATTERN.concreteObserver.WorkoutPlanLogger;
import com.fitness.OBSERVER_PATTERN.concreteObserver.UserNotificationObserver;

import com.fitness.FACADE_PATTERN.facade.IWearableDeviceManager;
import com.fitness.FACADE_PATTERN.facade.WearableDeviceFacade;
import com.fitness.FACADE_PATTERN.subsystems.AppleHealthAPI;
import com.fitness.FACADE_PATTERN.subsystems.FitbitAPI;
import com.fitness.FACADE_PATTERN.subsystems.GarminAPI;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        WorkoutPlanDirector director = new WorkoutPlanDirector();

        // -------------------------------------------------------
        // OBSERVER SYSTEM
        // -------------------------------------------------------
        WorkoutPlanEventManager eventManager = new WorkoutPlanEventManager();
        eventManager.subscribe(new WorkoutPlanLogger());
        eventManager.subscribe(new UserNotificationObserver("Aymzhan"));

        // -------------------------------------------------------
        // FACTORY + MANAGERS
        // -------------------------------------------------------
        WorkoutPlanManager beginnerManager =
                new WorkoutPlanManager(new BeginnerPlanFactory(), eventManager);

        WorkoutPlanManager fatLossManager =
                new WorkoutPlanManager(new FatLossPlanFactory(), eventManager);

        WorkoutPlanManager customManager =
                new WorkoutPlanManager(new CustomPlanFactory(), eventManager);

        // -------------------------------------------------------
        // HELPER FUNCTION FOR CLEAN BUILDS
        // -------------------------------------------------------
        System.out.println("\n===== FACTORY + BUILDER + OBSERVER DEMO =====");

        WorkoutPlan beginnerPlan = buildPlan(
                beginnerManager,
                director,
                "Beginner Workout Program",
                "beginner",
                "low",
                25,
                "foundation",
                List.of(
                        new Exercise("Jumping Jacks", "Light warm-up"),
                        new Exercise("Bodyweight Squats", "Lower body strength"),
                        new Exercise("Knee Push-ups", "Upper body training")
                )
        );

        WorkoutPlan fatLossPlan = buildPlan(
                fatLossManager,
                director,
                "Fat Loss Intense Program",
                "intermediate",
                "high",
                45,
                "fat-loss",
                List.of(
                        new Exercise("Burpees", "High intensity cardio"),
                        new Exercise("Mountain Climbers", "Core + cardio"),
                        new Exercise("Jump Squats", "Explosive plyometrics")
                )
        );


        // -------------------------------------------------------
        // DISPLAY RESULTS
        // -------------------------------------------------------
        System.out.println("\n=== BEGINNER PLAN ===");
        System.out.println(beginnerPlan);

        System.out.println("\n=== FAT LOSS PLAN ===");
        System.out.println(fatLossPlan);
        // ===================================================================
        //                         FACADE PATTERN (NEW SECTION)
        // ===================================================================
        System.out.println("\n===== FACADE PATTERN DEMO =====");

        IWearableDeviceManager facade = new WearableDeviceFacade();

        // Register wearable devices (subsystem objects)
        facade.registerDevice(new FitbitAPI("Fitbit-X12", 128, 7450));
        facade.registerDevice(new GarminAPI("Garmin-Pro44", 122, 6800));
        facade.registerDevice(new AppleHealthAPI("Apple-Health-01", 136, 8200));

        // Client receives simplified API
        System.out.println("Connected devices: " + facade.listDeviceIds());
        System.out.println("Average heart rate: " + facade.getAverageHeartRate());
        System.out.println("Total steps today: " + facade.getTotalSteps());
    }


    // ============================================================
    // CLEAN BUILDER + FACTORY WORKFLOW (helper)
    // ============================================================
    private static WorkoutPlan buildPlan(
            WorkoutPlanManager manager,
            WorkoutPlanDirector director,
            String name,
            String level,
            String intensity,
            int duration,
            String goal,
            List<Exercise> exercises
    ) {

        IWorkoutPlanBuilder builder = manager.newPlanBuilder();

        director.buildPlan(
                builder,
                name,
                level,
                intensity,
                duration,
                goal,
                exercises
        );

        return manager.finalizePlan(builder);


    }
}