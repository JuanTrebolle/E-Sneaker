package com.example.e_sneaker;

public class Sneaker {
    private String modelName;
    private String brand;
    private double price;
    private String description; //not sure about this

    public Sneaker(String modelName, String brand, double price) {
        this.modelName = modelName;
        this.brand = brand;
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
