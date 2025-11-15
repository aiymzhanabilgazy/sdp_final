package com.fitness.FACADE_PATTERN.subsystems;

public class FitbitAPI implements WearableAPI {

    private String deviceId;

    public FitbitAPI(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public int getHeartRate() {
        // симуляция получения данных
        return 128;
    }

    @Override
    public int getSteps() {
        // симулируем
        return 7400;
    }
}

