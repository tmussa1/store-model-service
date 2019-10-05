package com.cscie97.store.model;

public class StoreUtil {

    public static Location convertLocationToEnum(String location) {
        Location locationEnum = null;
        switch(location.toUpperCase()){
            case "FLOOR":
                locationEnum =  Location.FLOOR;
                break;
            case "STOREROOM":
                locationEnum = Location.STORE_ROOM;
                break;
            default:
                locationEnum =  Location.FLOOR;
        }
        return locationEnum;
    }

    public static Level convertLevelToEnum(String level){
        Level levelEnum = null;
        switch(level.toUpperCase()){
            case "HIGH":
                levelEnum = Level.HIGH;
                break;
            case "MEDIUM":
                levelEnum = Level.MEDIUM;
                break;
            case "LOW":
                levelEnum = Level.LOW;
                break;
            default:
                levelEnum = Level.MEDIUM;
        }
        return levelEnum;
    }

    public static Temperature convertTemperatureToEnum(String temperature){
        Temperature temperatureEnum = null;
        switch(temperature.toUpperCase()){
            case "FROZEN":
                temperatureEnum = Temperature.FROZEN;
                break;
            case"REFRIGERATED":
                temperatureEnum = Temperature.REFRIGERATED;
                break;
            case "AMBIENT":
                temperatureEnum = Temperature.AMBIENT;
                break;
            case "WARM":
                temperatureEnum = Temperature.WARM;
                break;
            case "HOT":
                temperatureEnum = Temperature.HOT;
                break;
            default:
                temperatureEnum = Temperature.AMBIENT;
        }
        return temperatureEnum;
    }
}
