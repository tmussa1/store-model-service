package com.cscie97.store.model.test;

import com.cscie97.store.model.IStoreModelService;
import com.cscie97.store.model.StoreException;

public class UpdateUtil {

    public String updateInventoryCount(IStoreModelService storeModelService, String inventoryId, String count) throws StoreException {
        int countInt = parseNumber(count);
        storeModelService.updateInventoryCount(inventoryId, countInt);
        return DetailsUtil.outputConfirmation(inventoryId);
    }


    private int parseNumber(String count) {
        if(count.charAt(0) == '-'){
             count = count.substring(1);
            return -Integer.parseInt(count);
        }
        return Integer.parseInt(count);
    }
}
