package com.cscie97.store.model.test;

import com.cscie97.store.model.*;

public class CreateUtil {

    private IStoreModelService storeModelService;


    public static String createStore(IStoreModelService storeModelService, String storeId, String storeName, String street, String city, String state) throws StoreException {
        Address address = new Address(street, city, state);
        Store store = storeModelService.createAStore(storeId, storeName, address);
        return DetailsUtil.outputConfirmation(store.getStoreName());
    }

    public static String createAisle(IStoreModelService storeModelService, String storeId, String aisleNumber, String aisleDescription, String location) throws StoreException {
        Aisle aisle = storeModelService.createAisle(storeId,aisleNumber, aisleDescription, location);
        return DetailsUtil.outputConfirmation(aisle.getAisleDescription());
    }

    public static String createShelf(IStoreModelService storeModelService,String storeId, String aisleNumber, String shelfId, String shelfName, String level, String shelfDescription, String temperature) throws StoreException {
        Shelf shelf = storeModelService.createAShelf(storeId, aisleNumber, shelfId, shelfName, level, shelfDescription, temperature);
        return DetailsUtil.outputConfirmation(shelf.getShelfName());
    }

    public static String createProduct(IStoreModelService storeModelService, String productId, String productName, String productDescription, String size, String category, String price, String temperature){
        int prdSize = Integer.parseInt(size);
        int prdPrice = Integer.parseInt(price);
        int prdId = Integer.parseInt(productId);
        Product product = storeModelService.createAProduct(prdId, productName, productDescription, prdSize, category, prdPrice, temperature);
        return DetailsUtil.outputConfirmation(product.getProductName());
    }





}
