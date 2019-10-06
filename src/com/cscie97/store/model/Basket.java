package com.cscie97.store.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private String basketId;
    private Map<Product, Integer> productsMap;

    public Basket(String basketId) {
        this.basketId = basketId;
        this.productsMap = new HashMap<>();
    }

    public void addProductToBasket(Product product, int quantity){
        if(productsMap.containsKey(product)){
            productsMap.put(product, productsMap.get(product) + quantity);
        } else {
            productsMap.put(product, quantity);
        }
    }
    public String getBasketId() {
        return basketId;
    }
}
