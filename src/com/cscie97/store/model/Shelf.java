package com.cscie97.store.model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private String shelfId;
    private String shelfName;
    private Level level;
    private String shelfDescription;
    private Temperature temperature;
    private List<Inventory> inventoryList;

    public Shelf(String shelfId, String shelfName, Level level, String shelfDescription, Temperature temperature) {
        this.shelfId = shelfId;
        this.shelfName = shelfName;
        this.level = level;
        this.shelfDescription = shelfDescription;
        this.temperature = temperature;
        this.inventoryList = new ArrayList<>();
    }

    public void addInventoryToShelf(Inventory inventory) throws StoreException {
        Inventory inventoryExisting = getInventoryInTheShelfByInventoryId(inventory.getInventoryId());
        if(inventoryExisting != null){
            this.inventoryList.set(inventoryList.indexOf(inventoryExisting), inventory);
        } else {
            this.inventoryList.add(inventory);
        }
    }

    public Inventory getInventoryInTheShelfByInventoryId(int inventoryId) throws StoreException {
        Inventory inventory = this.inventoryList.stream()
                .filter(anInventory -> anInventory.getInventoryId() == inventoryId)
                .findAny().get();
        if(inventory == null){
            throw new StoreException("An inventory with the requested id doesn't exist");
        }
        return inventory;
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

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }
}