package com.example.e_sneaker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "sneaker_table")
public class Sneaker {
    //@PrimaryKey(autoGenerate = true)
    private long sneakerID;
    private String modelName;
    private String brand;
    private double price;
    private String description; //probably not gonna use.
    private String imageUrl;

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

    //@ColumnInfo(typeAffinity = ColumnInfo.BLOB) // BLOB is used to store image data into the db.
    public String getImage() { //not sure about the image type
        return imageUrl;
    }
}
