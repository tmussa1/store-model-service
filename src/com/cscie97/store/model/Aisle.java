package com.cscie97.store.model;

import java.util.ArrayList;
import java.util.List;

public class Aisle {

    private String aisleNumber;
    private String aisleDescription;
    private Location location;
    private List<Shelf> shelves;

    public Aisle(String aisleNumber, String aisleDescription, Location location) {
        this.aisleNumber = aisleNumber;
        this.aisleDescription = aisleDescription;
        this.location = location;
        this.shelves = new ArrayList<>();
    }

    public void addShelfToAisle(Shelf shelf){
        this.shelves.add(shelf);
    }

    public String getAisleNumber() {
        return aisleNumber;
    }

    public String getAisleDescription() {
        return aisleDescription;
    }

    public Location getLocation() {
        return location;
    }
}
