package com.example.e_sneaker.dao;

import com.example.e_sneaker.model.Sneaker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class SneakerDAO {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref;

    private static SneakerDAO instance;

    public SneakerDAO() {
        ref = database.getReference("...");
    }

    public static SneakerDAO getInstance(){
        if (instance == null){
            instance = new SneakerDAO();
        }
        return instance;
    }

    //@Query("SELECT * FROM sneaker_table")
    public List<Sneaker> getAllSneakers(){
        //TODO
        return null;
    }

    //@Query("SELECT * FROM sneaker_table WHERE brand = :brandName")
    public List<Sneaker> getSneakersByBrand(String brandName){
        //TODO
        return null;
    }

    public void addSneakerToFireList(Sneaker sneaker){
        //TODO
    }

    public void deleteSneakerFromFireList(Sneaker sneaker){
        //TODO
    }

    public void addSneakerToCartList(Sneaker sneaker){
        //TODO
    }

    public void deleteSneakerFromCartList(Sneaker sneaker){
        //TODO
    }


    /*@Query("SELECT modelName, brand, price, image FROM sneaker_table WHERE modelName = :name") //not sure if gonna be used
    public Sneaker getSneakerByName(String name){

    }*/
}
