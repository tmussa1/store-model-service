package com.cscie97.store.model.test;

import com.cscie97.store.model.*;

public class CreateUtil {


    public static String createStore(IStoreModelService storeModelService, String storeId, String storeName,
                                     String street, String city, String state) throws StoreException {
        Address address = new Address(street, city, state);
        Store store = storeModelService.createAStore(storeId, storeName, address);
        return DetailsUtil.outputConfirmation(store.getStoreName());
    }

    public static String createAisle(IStoreModelService storeModelService, String storeId, String aisleNumber,
                                     String aisleDescription, String location) throws StoreException {
        Aisle aisle = storeModelService.createAisle(storeId,aisleNumber, aisleDescription, location);
        return DetailsUtil.outputConfirmation(aisle.getAisleDescription());
    }

    public static String createShelf(IStoreModelService storeModelService,String storeId, String aisleNumber,
                                     String shelfId, String shelfName, String level, String shelfDescription,
                                     String temperature) throws StoreException {
        Shelf shelf = storeModelService.createAShelf(storeId, aisleNumber, shelfId,
                shelfName, level, shelfDescription, temperature);
        return DetailsUtil.outputConfirmation(shelf.getShelfName());
    }

    public static String createProduct(IStoreModelService storeModelService, String productId, String productName,
                                       String productDescription, String size, String category, String price,
                                       String temperature){
        Product product = storeModelService.createAProduct(productId, productName, productDescription,
                convertToInteger(size), category, convertToInteger(price), temperature);
        return DetailsUtil.outputConfirmation(product.getProductName());
    }


    public static String createInventory(IStoreModelService storeModelService, String inventoryId, String storeId,
                                         String aisleNumber, String shelfId, String capacity,
                                         String count, String productId) throws StoreException {
        Inventory inventory = storeModelService.createInventory(inventoryId, storeId, aisleNumber,
                shelfId, convertToInteger(capacity), convertToInteger(count), convertToInteger(productId));
        return DetailsUtil.outputConfirmation(String.valueOf(inventory.getInventoryId()));
    }

    public static String createCustomer(IStoreModelService storeModelService, String customerId, String firstName,
                                        String lastName, String type, String emailAddress, String accountAddress)
            throws StoreException {
        Customer customer = storeModelService.createCustomer(customerId, firstName, lastName, type,
                emailAddress, accountAddress);
        return DetailsUtil.outputConfirmation(customer.getFirstName());
    }

    public static String createBasketForACustomer(IStoreModelService storeModelService, String customerId, String basketId) throws StoreException {
        Basket basketForACustomer = storeModelService.createBasketForACustomer(customerId, basketId);
        return DetailsUtil.outputConfirmation(basketForACustomer.getBasketId());
    }


    public static int convertToInteger(String str){
        return Integer.parseInt(str);
    }




}
