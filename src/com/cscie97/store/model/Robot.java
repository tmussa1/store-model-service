package com.cscie97.store.model;

public class Robot implements ISensor, IAppliance {

    private String sensorId;
    private String sensorName;
    private InventoryLocation sensorLocation;
    private String sensorType;

    public Robot(String sensorId, String sensorName, InventoryLocation sensorLocation, String sensorType) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.sensorLocation = sensorLocation;
        this.sensorType = sensorType;
    }

    @Override
    public String getSensorId() {
        return sensorId;
    }

    @Override
    public String getSensorName() {
        return sensorName;
    }

    @Override
    public InventoryLocation getSensorLocation() {
        return getSensorLocation();
    }

    @Override
    public String getSensorType() {
        return getSensorType();
    }

    @Override
    public String getApplianceId() {
        return getSensorId();
    }

    @Override
    public String getApplianceName() {
        return getSensorName();
    }

    @Override
    public InventoryLocation getApplianceLocation() {
        return getSensorLocation();
    }

    @Override
    public String getApplianceType() {
        return getSensorType();
    }
}
