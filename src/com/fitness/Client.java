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

import com.fitness.FACADE_PATTERN.facade.WearableDeviceFacade;
import com.fitness.FACADE_PATTERN.subsystems.*;

import com.fitness.ADAPTER_PATTERN.adaptee.ThirdPartyHealthAPI;
import com.fitness.ADAPTER_PATTERN.adapter.ThirdPartyHealthAdapter;

import com.fitness.VISITOR_PATTERN.concrete_elements.WorkoutPlanElement;
import com.fitness.VISITOR_PATTERN.concrete_visitors.CaloriesSumVisitor;
import com.fitness.VISITOR_PATTERN.concrete_visitors.ExerciseCountVisitor;
import com.fitness.VISITOR_PATTERN.concrete_visitors.MaxCaloriesVisitor;
import com.fitness.VISITOR_PATTERN.concrete_visitors.SummaryVisitor;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        WorkoutPlanDirector director = new WorkoutPlanDirector();

        // -------------------------------------------------------
        // OBSERVER SYSTEM
        // -------------------------------------------------------
        WorkoutPlanEventManager eventManager = new WorkoutPlanEventManager();
        eventManager.subscribe(new WorkoutPlanLogger());
        eventManager.subscribe(new UserNotificationObserver("Aiymzhan"));

        // -------------------------------------------------------
        // FACTORY MANAGERS
        // -------------------------------------------------------
        WorkoutPlanManager beginnerManager = new WorkoutPlanManager(new BeginnerPlanFactory(), eventManager);
        WorkoutPlanManager fatLossManager   = new WorkoutPlanManager(new FatLossPlanFactory(), eventManager);
        WorkoutPlanManager customManager    = new WorkoutPlanManager(new CustomPlanFactory(), eventManager);


        System.out.println("\n===== FACTORY + BUILDER + OBSERVER DEMO =====");

        // BEGINNER PLAN
        WorkoutPlan beginnerPlan = buildPlan(
                beginnerManager,
                director,
                "Beginner Workout Program",
                "beginner",
                "low",
                25,
                "foundation",
                List.of(
                        new Exercise("Jumping Jacks", "Light warm-up", 40),
                        new Exercise("Bodyweight Squats", "Lower body strength", 55),
                        new Exercise("Knee Push-ups", "Upper body training", 35)
                )
        );

        // FAT LOSS PLAN
        WorkoutPlan fatLossPlan = buildPlan(
                fatLossManager,
                director,
                "Fat Loss Intense Program",
                "intermediate",
                "high",
                45,
                "fat-loss",
                List.of(
                        new Exercise("Burpees", "High intensity cardio", 120),
                        new Exercise("Mountain Climbers", "Core + cardio", 80),
                        new Exercise("Jump Squats", "Explosive plyometrics", 100)
                )
        );

        System.out.println("\n=== BEGINNER PLAN ===");
        System.out.println(beginnerPlan);

        System.out.println("\n=== FAT LOSS PLAN ===");
        System.out.println(fatLossPlan);

        // ======================================================
        //                FACADE PATTERN DEMO
        // ======================================================
        System.out.println("\n===== FACADE PATTERN DEMO =====");

        WearableDeviceFacade facade = new WearableDeviceFacade();

        facade.registerDevice(new FitbitAPI("Fitbit-X12",120,7420));
        facade.registerDevice(new GarminAPI("Garmin-Pro44",122,6890));
        facade.registerDevice(new AppleHealthAPI("Apple-Health-01",130,8120));

        System.out.println("Connected devices: " + facade.listDeviceIds());
        System.out.println("Average heart rate: " + facade.getAverageHeartRate());
        System.out.println("Total steps today: " + facade.getTotalSteps());


        // ======================================================
        //                ADAPTER PATTERN DEMO
        // ======================================================
        System.out.println("\n===== ADAPTER PATTERN DEMO =====");

        ThirdPartyHealthAPI thirdPartyAPI = new ThirdPartyHealthAPI("ThirdParty-999");
        IWearableAPI adaptedDevice = new ThirdPartyHealthAdapter(thirdPartyAPI);

        facade.registerDevice(adaptedDevice);

        System.out.println("Devices after adding adapted service: " + facade.listDeviceIds());
        System.out.println("Updated average heart rate: " + facade.getAverageHeartRate());
        System.out.println("Updated total steps: " + facade.getTotalSteps());


        // ======================================================
        //                VISITOR PATTERN DEMO
        // ======================================================
        System.out.println("\n===== VISITOR PATTERN DEMO =====");

        WorkoutPlanElement beginnerElement = new WorkoutPlanElement(beginnerPlan);
        WorkoutPlanElement fatLossElement = new WorkoutPlanElement(fatLossPlan);

        // ---- 1. Total Calories Visitor
        CaloriesSumVisitor caloriesVisitor = new CaloriesSumVisitor();
        beginnerElement.accept(caloriesVisitor);
        fatLossElement.accept(caloriesVisitor);
        System.out.println("Total calories (all plans): " + caloriesVisitor.getTotalCalories());

        // ---- 2. Exercise Count Visitor
        ExerciseCountVisitor countVisitor = new ExerciseCountVisitor();
        beginnerElement.accept(countVisitor);
        fatLossElement.accept(countVisitor);
        System.out.println("Total exercises: " + countVisitor.getCount());

        // ---- 3. Max Calories Visitor
        MaxCaloriesVisitor maxVisitor = new MaxCaloriesVisitor();
        beginnerElement.accept(maxVisitor);
        fatLossElement.accept(maxVisitor);

        if (maxVisitor.getMaxExercise() != null) {
            System.out.println("Most intensive exercise: " + maxVisitor.getMaxExercise().getName() +
                    " (" + maxVisitor.getMaxExercise().getCaloriesBurned() + " calories)");
        }

        // ---- 4. Summary Visitor (for beginner plan)
        SummaryVisitor summaryVisitor = new SummaryVisitor();
        beginnerElement.accept(summaryVisitor);

        System.out.println("\nWorkout Summary:\n" + summaryVisitor.getSummary());
    }


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

