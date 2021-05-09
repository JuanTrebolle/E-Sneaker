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
    } // Used depending on the name format.

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    } //probably not gonna use.

    public int getImage() { //not sure about the image type
        return 0;
    }
}
