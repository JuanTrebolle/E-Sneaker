package com.example.e_sneaker;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public LoginViewModel(Application app) {
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }
}
