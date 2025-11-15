package com.fitness.FACADE_PATTERN.subsystems;

public class GarminAPI implements WearableAPI {

    private String deviceId;

    public GarminAPI(String deviceId) {
        this.deviceId = deviceId;
    }
    @Override
    public String getDeviceId() {
        return deviceId;
    }
    @Override
    public int getHeartRate() {
        return 122;
    }
    @Override
    public int getSteps() {
        return 6300;
    }
}
