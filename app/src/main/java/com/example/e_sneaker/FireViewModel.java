package com.example.e_sneaker;

import androidx.lifecycle.ViewModel;

public class FireViewModel extends ViewModel {
    private FireViewModel instance;

    public FireViewModel getInstance(){
        if (instance == null){
            instance = new FireViewModel();
        }
        return instance;
    }

    public void addToFireList(Sneaker sneaker){
        //TODO
    }

    public void deleteFromFireList(Sneaker sneaker){
        //TODO
    }
}
