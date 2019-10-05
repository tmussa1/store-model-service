package com.cscie97.store.model;

public interface IStoreModelService {

    Store createAStore(String storeId, String storeName, String storeAddress) throws StoreException;

    Store getStoreById(String storeId);

    Aisle createAisle(String storeId, String aisleNumber, String aisleDescription, String location);

    Aisle getAisleByStoreIdAndAisleNumber(String storeId, String aisleNumber);

    Shelf createAShelf(String storeId, String aisleNumber, String shelfId, String shelfName, String level, String shelfDescription, String temperature);

    Shelf getShelfByStoreIdAisleNumShelfId(String storeId, String aisleNumber, String shelfId);

}

