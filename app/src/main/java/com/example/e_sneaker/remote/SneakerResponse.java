package com.example.e_sneaker.remote;

import com.example.e_sneaker.model.Sneaker;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SneakerResponse {
    private long id;
    @SerializedName("sneakerName")
    private String title;
    private double retailPrice;
    private String brand;
    private Media media;

    public List<Sneaker> getSneakers(){
        //TODO
        // Need to return a list instead of only one object
        //return new Sneaker(id, title, retailPrice, brand, media.url);
        return null;
    }

    public List<Sneaker> getSneakersByBrand(String brand){
        //TODO
        //return list of all sneakers with the specific brand
        return null;
    }

    private static class Media{
        private String url;
    }
}
