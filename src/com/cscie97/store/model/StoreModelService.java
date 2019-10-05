package com.cscie97.store.model;

import java.util.ArrayList;
import java.util.List;

public class StoreModelService implements IStoreModelService {

    List<Customer> customers;
    List<Store> stores;

    public StoreModelService() {
        this.customers = new ArrayList<Customer>();
        this.stores = new ArrayList<Store>();
    }


    @Override
    public Store createAStore(String storeId, String storeName, String storeAddress) throws StoreException {
        String [] addressArray = storeAddress.split(" ");
        Address address = new Address(addressArray[0], addressArray[1], addressArray[2]);
        checkValidityOfStoreId(storeId);
        return new Store(storeId, storeName, address);
    }

    private void checkValidityOfStoreId(String storeId) throws StoreException {
        Store duplicateStore = this.stores.stream().filter(store -> store.getStoreId().equals(storeId)).findAny().get();

        if(duplicateStore != null){
            throw new StoreException("Duplicate Store with the ID provided exists. Store creation failed");
        }
    }

    @Override
    public Store getStoreById(String storeId){
        return this.stores.stream().filter(store -> store.getStoreId().equals(storeId)).findAny().get();
    }

    @Override
    public Aisle createAisle(String storeId, String aisleNumber, String aisleDescription, String location) {
        Store store = getStoreById(storeId);
        Location locationEnum = StoreUtil.convertLocationToEnum(location);
        Aisle aisle = new Aisle(aisleNumber, aisleDescription,locationEnum);
        store.addAisleToAStore(aisle);
        return aisle;
    }

    @Override
    public Aisle getAisleByStoreIdAndAisleNumber(String storeId, String aisleNumber) {
        Store store = getStoreById(storeId);
        return store.getAisles().stream().filter(aisle -> aisle.getAisleNumber().equals(aisleNumber)).findAny().get();
    }

    @Override
    public Shelf createAShelf(String storeId, String aisleNumber, String shelfId, String shelfName, String level, String shelfDescription, String temperature) {
        Aisle aisle = getAisleByStoreIdAndAisleNumber(storeId, aisleNumber);
        Level levelEnum = StoreUtil.convertLevelToEnum(level);
        Temperature temperatureEnum = StoreUtil.convertTemperatureToEnum(temperature);
        Shelf shelf = new Shelf(shelfId, shelfName,levelEnum,shelfDescription,temperatureEnum);
        aisle.addShelfToAisle(shelf);
        return shelf;
    }

    @Override
    public Shelf getShelfByStoreIdAisleNumShelfId(String storeId, String aisleNumber, String shelfId) {
        Aisle aisle = getAisleByStoreIdAndAisleNumber(storeId, aisleNumber);
        return aisle.getShelves().stream().filter(shelf -> shelf.getShelfId().equals(shelfId)).findAny().get();
    }




}
