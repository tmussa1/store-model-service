package com.cscie97.store.model.test;

import com.cscie97.store.model.*;


public class ShowUtil {

    public static String showStoreDetails(IStoreModelService storeModelService, String storeId) throws StoreException {
        Store store = storeModelService.getStoreById(storeId);
        return DetailsUtil.outputDetails("Store " , store.getStoreName(), store.getAddress().getCity(), store.getAisles());
    }

    public static String showAisleDetails(IStoreModelService storeModelService, String storeId, String aisleNumber) throws StoreException {
        Aisle aisle = storeModelService.getAisleByStoreIdAndAisleNumber(storeId, aisleNumber);
        return DetailsUtil.outputDetails("Aisle ", aisle.getAisleDescription(), aisle.getLocation().name(),aisle.getShelves());
    }

    public static String showShelfDetails(IStoreModelService storeModelService, String storeId, String aisleNumber, String shelfId) throws StoreException {
        Shelf shelf = storeModelService.getShelfByStoreIdAisleNumShelfId(storeId, aisleNumber, shelfId );
        return DetailsUtil.outputDetails("Shelf ", shelf.getShelfName(), aisleNumber, shelf.getInventoryList());
    }
}
