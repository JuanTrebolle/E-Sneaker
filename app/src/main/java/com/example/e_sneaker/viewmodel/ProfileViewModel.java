package com.example.e_sneaker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.e_sneaker.repository.UserRepository;

public class ProfileViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public ProfileViewModel(Application app) {
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public String getUserEmail(){
        //TODO
        return null;
    }

    public String getUserName(){
        //TODO
        return null;
    }

    public void signOut() {
        userRepository.signOut();
    }
}
