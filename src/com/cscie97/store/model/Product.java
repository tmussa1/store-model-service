package com.cscie97.store.model;

public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private String category;
    private int price;
    private double volume;
    private Temperature temperature;

    public Product(int productId, String productName, String productDescription, String category, int price, double volume, Temperature temperature) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.price = price;
        this.volume = volume;
        this.temperature = temperature;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getVolume() {
        return volume;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}
