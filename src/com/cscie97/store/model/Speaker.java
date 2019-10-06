package com.cscie97.store.model;

public class Speaker implements IAppliance {

    private String applianceId;
    private String applianceName;
    private InventoryLocation applianceLocation;
    private String applianceType;

    public Speaker(String applianceId, String applianceName, InventoryLocation applianceLocation) {
        this.applianceId = applianceId;
        this.applianceName = applianceName;
        this.applianceLocation = applianceLocation;
        this.applianceId = this.getClass().getName();
    }

    @Override
    public String getApplianceId() {
        return applianceId;
    }

    @Override
    public String getApplianceName() {
        return applianceName;
    }

    @Override
    public InventoryLocation getApplianceLocation() {
        return applianceLocation;
    }

    @Override
    public String getApplianceType() {
        return applianceType;
    }
}
