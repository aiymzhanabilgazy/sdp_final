package com.fitness.ADAPTER_PATTERN.adapter;

import com.fitness.ADAPTER_PATTERN.adaptee.ThirdPartyHealthAPI;
import com.fitness.FACADE_PATTERN.subsystems.IWearableAPI;

public class ThirdPartyHealthAdapter implements IWearableAPI {

    private ThirdPartyHealthAPI service;

    public ThirdPartyHealthAdapter(ThirdPartyHealthAPI service) {
        this.service = service;
    }

    @Override
    public String getDeviceId() {
        return service.uid();
    }

    @Override
    public int getHeartRate() {
        return service.bpm();
    }

    @Override
    public int getSteps() {
        return service.totalStepsToday();
    }
}
