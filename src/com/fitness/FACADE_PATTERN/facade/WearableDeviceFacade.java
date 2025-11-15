package com.fitness.FACADE_PATTERN.facade;

import com.fitness.FACADE_PATTERN.subsystems.WearableAPI;

import java.util.ArrayList;
import java.util.List;
public class WearableDeviceFacade implements WearableDeviceManager {

    private List<WearableAPI> devices = new ArrayList<>();

    @Override
    public void registerDevice(WearableAPI device) {
        if (device != null && !devices.contains(device)) {
            devices.add(device);
        }
    }

    @Override
    public void unregisterDevice(WearableAPI device) {
        devices.remove(device);
    }

    @Override
    public int getAverageHeartRate() {
        if (devices.isEmpty()) return 0;
        int sum = 0;
        for (WearableAPI d : devices) {
            sum += d.getHeartRate();
        }
        return sum / devices.size();
    }

    @Override
    public int getTotalSteps() {
        int sum = 0;
        for (WearableAPI d : devices) {
            sum += d.getSteps();
        }
        return sum;
    }

    @Override
    public List<String> listDeviceIds() {
        List<String> ids = new ArrayList<>();
        for (WearableAPI d : devices) {
            ids.add(d.getDeviceId());
        }
        return ids;
    }
}

