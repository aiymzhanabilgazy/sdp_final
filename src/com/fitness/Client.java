package com.fitness;

import com.fitness.BUILDER_PATTERN.builder.IWorkoutPlanBuilder;
import com.fitness.BUILDER_PATTERN.director.WorkoutPlanDirector;
import com.fitness.BUILDER_PATTERN.product.Exercise;
import com.fitness.BUILDER_PATTERN.product.WorkoutPlan;

// FACTORY + OBSERVER
import com.fitness.FACTORY_PATTERN.concreteFactory.BeginnerPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.CustomPlanFactory;
import com.fitness.FACTORY_PATTERN.concreteFactory.FatLossPlanFactory;
import com.fitness.FACTORY_PATTERN.manager.WorkoutPlanManager;

import com.fitness.OBSERVER_PATTERN.subject.WorkoutPlanEventManager;
import com.fitness.OBSERVER_PATTERN.concreteObserver.WorkoutPlanLogger;
import com.fitness.OBSERVER_PATTERN.concreteObserver.UserNotificationObserver;

// FACADE
import com.fitness.FACADE_PATTERN.facade.WearableDeviceFacade;
import com.fitness.FACADE_PATTERN.subsystems.IWearableAPI;
import com.fitness.FACADE_PATTERN.subsystems.FitbitAPI;
import com.fitness.FACADE_PATTERN.subsystems.GarminAPI;
import com.fitness.FACADE_PATTERN.subsystems.AppleHealthAPI;

// ADAPTER
import com.fitness.ADAPTER_PATTERN.adaptee.ThirdPartyHealthAPI;
import com.fitness.ADAPTER_PATTERN.adapter.ThirdPartyHealthAdapter;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        // ==========================================================
        //                 OBSERVER SYSTEM
        // ==========================================================
        WorkoutPlanEventManager eventManager = new WorkoutPlanEventManager();
        eventManager.subscribe(new WorkoutPlanLogger());
        eventManager.subscribe(new UserNotificationObserver("Aymzhan"));


        // ==========================================================
        //                 FACTORY MANAGERS
        // ==========================================================
        WorkoutPlanManager beginnerManager =
                new WorkoutPlanManager(new BeginnerPlanFactory(), eventManager);

        WorkoutPlanManager fatLossManager =
                new WorkoutPlanManager(new FatLossPlanFactory(), eventManager);

        WorkoutPlanManager customManager =
                new WorkoutPlanManager(new CustomPlanFactory(), eventManager);


        // ==========================================================
        //                 BUILDER + FACTORY DEMO
        // ==========================================================
        WorkoutPlanDirector director = new WorkoutPlanDirector();

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


        // ==========================================================
        //                     SHOW RESULTS
        // ==========================================================
        System.out.println("\n=== BEGINNER PLAN ===");
        System.out.println(beginnerPlan);

        System.out.println("\n=== FAT LOSS PLAN ===");
        System.out.println(fatLossPlan);

        // ==========================================================
        //                     FACADE PATTERN DEMO
        // ==========================================================
        System.out.println("\n===== FACADE PATTERN DEMO =====");

        WearableDeviceFacade facade = new WearableDeviceFacade();

        facade.registerDevice(new FitbitAPI("Fitbit-X12",120,12));
        facade.registerDevice(new GarminAPI("Garmin-Pro44",240,13));
        facade.registerDevice(new AppleHealthAPI("Apple-Health-01",100,100));

        System.out.println("Connected devices: " + facade.listDeviceIds());
        System.out.println("Average heart rate: " + facade.getAverageHeartRate());
        System.out.println("Total steps today: " + facade.getTotalSteps());


        // ==========================================================
        //                     ADAPTER PATTERN DEMO
        // ==========================================================
        System.out.println("\n===== ADAPTER PATTERN DEMO =====");

        // сторонний несовместимый сервис
        ThirdPartyHealthAPI externalAPI = new ThirdPartyHealthAPI("ThirdParty-999");

        // адаптер под IWearableAPI
        IWearableAPI adaptedDevice = new ThirdPartyHealthAdapter(externalAPI);

        // подключаем в фасад
        facade.registerDevice(adaptedDevice);

        System.out.println("Devices after adding adapted service: " + facade.listDeviceIds());
        System.out.println("Updated average heart rate: " + facade.getAverageHeartRate());
        System.out.println("Updated total steps: " + facade.getTotalSteps());
    }


    // ===========================================================================
    //                         HELPER METHOD FOR BUILDER WORKFLOW
    // ===========================================================================
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
        director.buildPlan(builder, name, level, intensity, duration, goal, exercises);
        return manager.finalizePlan(builder);
    }
}