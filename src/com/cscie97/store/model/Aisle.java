package com.cscie97.store.model;

import java.util.ArrayList;
import java.util.List;

public class Aisle {

    private String aisleNumber;
    private String aisleDescription;
    private LocationType location;
    private List<Shelf> shelves;
    private List<ISensor> sensors;
    private List<IAppliance> appliances;

    public Aisle(String aisleNumber, String aisleDescription, LocationType location) {
        this.aisleNumber = aisleNumber;
        this.aisleDescription = aisleDescription;
        this.location = location;
        this.shelves = new ArrayList<>();
        this.sensors = new ArrayList<>();
    }

    public void addShelfToAisle(Shelf shelf){
        this.shelves.add(shelf);
    }

    public void addSensorToShelf(ISensor sensor){
        this.sensors.add(sensor);
    }

    public void addApplianceToShelf(IAppliance appliance){
        this.appliances.add(appliance);
    }

    public String getAisleNumber() {
        return aisleNumber;
    }

    public String getAisleDescription() {
        return aisleDescription;
    }

    public LocationType getLocation() {
        return location;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }
}
