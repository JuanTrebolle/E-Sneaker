package com.example.e_sneaker.dao;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SneakerDAO {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance(); //not sure if should use the root
    private DatabaseReference ref;

    private static SneakerDAO instance;
    private static Object lock = new Object();

    private List<Sneaker> allSneakers;
    private SneakerRepository sneakerRepository;

    public SneakerDAO() {
        ref = database.getReference();
        allSneakers = new ArrayList<>();
    }

    public static SneakerDAO getInstance(){
        if (instance == null){
            synchronized (lock) {
                if (instance == null) {
                    instance = new SneakerDAO();
                }
            }
        }
        return instance;
    }

    public List<Sneaker> getSneakersByBrand(String brandName){
        //TODO
        return null;
    }

    /*
    public List<Sneaker> getAllSneakers(){
        return null;
    }

    public void addAllSneakersToDB(){
        for (Sneaker sneaker : sneakerRepository.requestAllSneakers().getValue()){
            ref.child("sneakers").push().setValue(sneaker);
        }
    }*/

    public void addSneakerToFireList(Sneaker sneaker){
        //TODO
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("fire-sneakers").push().setValue(sneaker);
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
