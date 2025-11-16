package com.fitness.FACADE_PATTERN.facade;

import com.fitness.FACADE_PATTERN.subsystems.IWearableAPI;
import java.util.ArrayList;
import java.util.List;

public class WearableDeviceFacade implements IWearableDeviceManager {
    private List<IWearableAPI> devices = new ArrayList<>();

    @Override
    public void registerDevice(IWearableAPI device) {
        if (device != null && !devices.contains(device)) {
            devices.add(device);
        }
    }
    @Override
    public void unregisterDevice(IWearableAPI device) {
        devices.remove(device);
    }

    @Override
    public int getAverageHeartRate() {
        if (devices.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (IWearableAPI d : devices) {
            sum += d.getHeartRate();
        }
        return sum / devices.size();
    }

    @Override
    public int getTotalSteps() {
        int total = 0;
        for (IWearableAPI d : devices) {
            total += d.getSteps();
        }
        return total;
    }

    @Override
    public List<String> listDeviceIds() {
        List<String> ids = new ArrayList<>();
        for (IWearableAPI d : devices) {
            ids.add(d.getDeviceId());
        }
        return ids;
    }
}


