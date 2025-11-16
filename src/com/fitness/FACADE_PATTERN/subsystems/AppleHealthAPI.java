package com.fitness.FACADE_PATTERN.subsystems;

public class AppleHealthAPI implements IWearableAPI {

    private String deviceId;
    private int heartRate;
    private int steps;

    public AppleHealthAPI(String deviceId, int heartRate, int steps) {
        this.deviceId = deviceId;
        this.heartRate = heartRate;
        this.steps = steps;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public int getHeartRate() {
        return heartRate;
    }

    @Override
    public int getSteps() {
        return steps;
    }
}
