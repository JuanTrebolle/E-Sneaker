package com.example.e_sneaker.dao;

import android.util.Log;

import androidx.lifecycle.LiveData;
import com.example.e_sneaker.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class UserDAO {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref;
    private static UserDAO instance;

    public UserDAO() {
        ref = database.getReference("...");
    }

    public static UserDAO getInstance(){
        if (instance == null){
            instance = new UserDAO();
        }
        return instance;
    }

    public String getUserEmail(String UID){
        String userEmail = null;
        ref.child("users").child(UID).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()){
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                //TODO
                userEmail = String.valueOf(task.getResult().getValue());
                Log.d("firebase user email", String.valueOf(task.getResult().getValue()));
            }
        });
        return userEmail;
    }

    /*void insertUser(User user){

    }*/

    /*public LiveData<List<Sneaker>> getFavoriteSneakers(){

    }

    public void setFireSneakers(LiveData<List<Sneaker>> favoriteSneakers){

    }

    public LiveData<List<Sneaker>> getCartSneakers(){

    }

    public void setCartSneakers(LiveData<List<Sneaker>> cartSneakers){

    }

    public void deleteFromCart(Sneaker sneaker){

    }*/

}
