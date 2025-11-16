package com.fitness.ADAPTER_PATTERN.client;

import com.fitness.ADAPTER_PATTERN.model.WorkoutStats;

public interface IWorkoutStatsProvider {
    WorkoutStats getStats();
}
