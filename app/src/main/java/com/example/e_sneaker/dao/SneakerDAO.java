package com.example.e_sneaker.dao;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SneakerDAO {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance("https://e-sneaker-d1f9b-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference ref;

    private static SneakerDAO instance;
    private static Object lock = new Object();

    private MutableLiveData<List<Sneaker>> fireSneakers;
    private MutableLiveData<List<Sneaker>> cartSneakers;

    private SneakerRepository sneakerRepository;

    public SneakerDAO() {
        ref = database.getReference();

        fireSneakers = new MutableLiveData<>();
        cartSneakers = new MutableLiveData<>();

        //ValueEventListener - get all data from reference
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("fire-sneakers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Sneaker> currentFireSneakers = new ArrayList<>();
                try {
                    Iterator<DataSnapshot> iterator = snapshot.getChildren().iterator();
                    DataSnapshot subSnapshot;
                    //Iterate though all elements in the fire-sneakers list from the specific user.
                    while (iterator.hasNext()){
                        subSnapshot = iterator.next();
                        currentFireSneakers.add(subSnapshot.getValue(Sneaker.class));
                    }
                } catch (Exception e){
                    Log.e("Firebase error", e.getMessage());
                }
                fireSneakers.setValue(currentFireSneakers);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("FAIL" + error.getMessage());
            }
        });

        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("cart-sneakers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Sneaker> currentCartSneakers = new ArrayList<>();
                try{
                    Iterator<DataSnapshot> iterator = snapshot.getChildren().iterator();
                    DataSnapshot subSnapshot;
                    //Iterate though all elements in the fire-sneakers list from the specific user.
                    while (iterator.hasNext()){
                        subSnapshot = iterator.next();
                        currentCartSneakers.add(subSnapshot.getValue(Sneaker.class));
                    }
                }catch (Exception e){
                    Log.e("Firebase error", e.getMessage());
                }
                cartSneakers.setValue(currentCartSneakers);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("FAIL" + error.getMessage());
            }
        });
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

    public void addSneakerToFireList(Sneaker sneaker){
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("fire-sneakers").child(String.valueOf(sneaker.getSneakerID())).setValue(sneaker);
    }

    public void deleteSneakerFromFireList(Sneaker sneaker){
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("fire-sneakers").child(String.valueOf(sneaker.getSneakerID())).removeValue();
    }

    public void addSneakerToCartList(Sneaker sneaker){
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("cart-sneakers").child(String.valueOf(sneaker.getSneakerID())).setValue(sneaker);
    }

    public void deleteSneakerFromCartList(Sneaker sneaker){
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("cart-sneakers").child(String.valueOf(sneaker.getSneakerID())).removeValue();
    }

    public MutableLiveData<List<Sneaker>> getFireSneakers() {
        return fireSneakers;
    }

    public MutableLiveData<List<Sneaker>> getCartSneakers() {
        return cartSneakers;
    }

    /*public Sneaker getSneakerByName(String name){ //For future

    }*/
}
