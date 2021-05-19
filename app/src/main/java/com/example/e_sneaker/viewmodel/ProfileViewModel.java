package com.example.e_sneaker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.e_sneaker.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public ProfileViewModel(Application app) {
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public String getUserEmail(){
        return userRepository.getUserEmail();
    }

    public String getUserId(){
        return userRepository.getUserId();
    }

    public void signOut() {
        userRepository.signOut();
    }
}
