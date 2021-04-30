package com.example.e_sneaker;

public class Sneaker {
    private int sneakerID;
    private String modelName;
    private String brand;
    private double price;
    private String description; //not sure about this

    public Sneaker(String modelName, int sneakerID) {
        this.modelName = modelName;
        this.sneakerID = sneakerID;
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
