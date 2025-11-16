package com.fitness.FACADE_PATTERN.facade;

import com.fitness.FACADE_PATTERN.subsystems.IWearableAPI;
import java.util.List;

public interface IWearableDeviceManager {
    void registerDevice(IWearableAPI device);
    void unregisterDevice(IWearableAPI device);

    int getAverageHeartRate();
    int getTotalSteps();
    List<String> listDeviceIds();
}
