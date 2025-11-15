package com.fitness.FACADE_PATTERN.subsystems;

public class AppleHealthAPI implements WearableAPI {

    private String deviceId;

    public AppleHealthAPI(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public int getHeartRate() {
        return 135;
    }

    @Override
    public int getSteps() {
        return 8100;
    }
}

