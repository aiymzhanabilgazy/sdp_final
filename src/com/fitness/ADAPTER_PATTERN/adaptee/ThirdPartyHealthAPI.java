package com.fitness.ADAPTER_PATTERN.adaptee;

public class ThirdPartyHealthAPI {

    private String uid;

    public ThirdPartyHealthAPI(String uid) {
        this.uid = uid;
    }
    public String uid() {
        return uid;
    }
    public int bpm() {
        return 132;
    }
    public int totalStepsToday() {
        return 9050;
    }
}
