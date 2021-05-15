package com.example.e_sneaker;

import android.app.Application;
import android.content.Intent;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import static androidx.core.content.ContextCompat.startActivity;

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
