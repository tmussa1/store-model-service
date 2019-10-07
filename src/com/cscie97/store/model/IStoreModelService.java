package com.cscie97.store.model;

import java.util.Map;

public interface IStoreModelService {

    Store createAStore(String storeId, String storeName, Address storeAddress) throws StoreException;

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

    Customer createCustomer(String customerId, String firstName, String lastName, String type, String emailAddress, String accountAddress) throws StoreException;

    Customer getCustomerById(String customerId) throws StoreException;

    InventoryLocation updateCustomerLocation(String customerId, String storeId, String aisleNumber) throws StoreException;

    Basket getBasketOfACustomer(String customerId) throws StoreException;

    Basket createBasketForACustomer(String customerId, String basketId) throws StoreException;

    Basket addItemToBasket(String basketId, String productId, int count) throws StoreException;

    Inventory getInventoryByProductId(String productId) throws StoreException;

    Basket removeItemFromBasket(String basketId, String productId, int countReturned) throws StoreException;

    Customer clearBasketAndRemoveAssociationWithACustomer(String basketId) throws StoreException;

    Map<Product, Integer> getBasketItems(String basketId) throws StoreException;
}

