package com.cscie97.store.model;

public interface ISensor {

    String getSensorId();

    String getSensorName();

    InventoryLocation getSensorLocation();

    String getSensorType();
}
