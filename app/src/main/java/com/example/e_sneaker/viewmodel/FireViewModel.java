package com.example.e_sneaker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class FireViewModel extends ViewModel {
    private FireViewModel instance;
    private SneakerRepository sneakerRepository = SneakerRepository.getInstance();

    public FireViewModel getInstance(){
        if (instance == null){
            instance = new FireViewModel();
        }
        return instance;
    }

    public LiveData<List<Sneaker>> getFireSneakersList(){
        return sneakerRepository.getFireSneakers();
    }

    public void addToFireList(Sneaker sneaker){
        sneakerRepository.getFireSneakers();
    }

    public void deleteFromFireList(Sneaker sneaker){
        sneakerRepository.getCartSneakers();
    }
}
