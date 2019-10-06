package com.cscie97.store.model;

public interface IStoreModelService {

    Store createAStore(String storeId, String storeName, String storeAddress) throws StoreException;

    Store getStoreById(String storeId) throws StoreException;

    Aisle createAisle(String storeId, String aisleNumber, String aisleDescription, String location) throws StoreException;

    Aisle getAisleByStoreIdAndAisleNumber(String storeId, String aisleNumber) throws StoreException;

    Shelf createAShelf(String storeId, String aisleNumber, String shelfId, String shelfName, String level, String shelfDescription, String temperature) throws StoreException;

    Shelf getShelfByStoreIdAisleNumShelfId(String storeId, String aisleNumber, String shelfId) throws StoreException;

    Inventory createInventory(int inventoryId, String storeId, String aisleNumber, String shelfId, int capacity, int count, int productId) throws StoreException;

    Inventory getInventoryById(int inventoryId) throws StoreException;

    int UpdateInventoryCount(int inventoryId, int difference) throws StoreException;

    Product createAProduct(int productId, String productName, String productDescription, int size, String category, int price, String temperature);

    Product getProductById(int productId) throws StoreException;
}

