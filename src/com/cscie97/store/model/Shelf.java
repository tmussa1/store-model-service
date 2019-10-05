package com.cscie97.store.model;

public class Shelf {
    private String shelfId;
    private String shelfName;
    private Level level;
    private String shelfDescription;
    private Temperature temperature;

    public Shelf(String shelfId, String shelfName, Level level, String shelfDescription, Temperature temperature) {
        this.shelfId = shelfId;
        this.shelfName = shelfName;
        this.level = level;
        this.shelfDescription = shelfDescription;
        this.temperature = temperature;
    }

    public String getShelfId() {
        return shelfId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public Level getLevel() {
        return level;
    }

    public String getShelfDescription() {
        return shelfDescription;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}