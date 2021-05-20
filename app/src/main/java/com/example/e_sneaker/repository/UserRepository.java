package com.example.e_sneaker.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.e_sneaker.model.UserLiveData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.ui.auth.AuthUI;

public class UserRepository {
    private final UserLiveData currentUser;
    private final Application app;
    private static UserRepository instance;

    public UserRepository(Application app) {
        this.app = app;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app){
        if (instance == null){
            instance = new UserRepository(app);
        }
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return currentUser;
    }

    public String getUserId(){
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public String getUserEmail(){
        return FirebaseAuth.getInstance().getCurrentUser().getEmail();
    }

    public void signOut(){
        AuthUI.getInstance().signOut(app.getApplicationContext());
    }
}
