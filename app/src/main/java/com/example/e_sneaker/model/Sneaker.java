package com.example.e_sneaker.model;

public class Sneaker{
    private long sneakerID;
    private String modelName;
    private String brand;
    private double price;
    private String imageUrl;

    public Sneaker() {
    }

    public Sneaker(long sneakerID, String modelName, double price, String brand, String imageUrl) {
        this.modelName = modelName;
        this.sneakerID = sneakerID;
    }

    public long getSneakerID() {
        return sneakerID;
    }

    public void setSneakerID(int sneakerID) {
        this.sneakerID = sneakerID;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    } // Used depending on the name format.

    public double getPrice() {
        return price;
    }

    public String getImage() { //not sure about the image type
        return imageUrl;
    }
}
