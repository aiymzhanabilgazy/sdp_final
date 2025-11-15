package com.fitness.FACADE_PATTERN.facade;

import com.fitness.FACADE_PATTERN.subsystems.WearableAPI;
import java.util.List;

public interface WearableDeviceManager {
    void registerDevice(WearableAPI device);
    void unregisterDevice(WearableAPI device);
    int getAverageHeartRate();
    int getTotalSteps();
    List<String> listDeviceIds();
}

