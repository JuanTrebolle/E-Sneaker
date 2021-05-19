package com.example.e_sneaker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class FireViewModel extends ViewModel {
    private SneakerRepository sneakerRepository;

    public FireViewModel() {
        sneakerRepository = SneakerRepository.getInstance();
    }

    public LiveData<List<Sneaker>> getFireSneakersList(){
        return sneakerRepository.getFireSneakers();
    }

    public void addToFireList(Sneaker sneaker){
        //sneakerRepository.getFireSneakers();
        sneakerRepository.addToFireList(sneaker);
    }

    /* Done in SneakerRepository instead
    public void deleteFromFireList(Sneaker sneaker){
        //sneakerRepository.getCartSneakers();
        sneakerRepository.deleteFromFireList(sneaker);
    }*/
}
