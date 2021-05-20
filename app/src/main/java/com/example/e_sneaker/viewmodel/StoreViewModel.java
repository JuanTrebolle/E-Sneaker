package com.example.e_sneaker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class StoreViewModel extends ViewModel {
    private MutableLiveData<List<Sneaker>> allSneakers;
    private SneakerRepository sneakerRepository;

    public StoreViewModel() {
        super();
        sneakerRepository = SneakerRepository.getInstance();
        allSneakers = sneakerRepository.requestAllSneakers();
    }

    public LiveData<List<Sneaker>> getAllSneakers() {
        return allSneakers;
    }

    public LiveData<List<Sneaker>> getFireSneakers(){
        return sneakerRepository.getFireSneakers();
    }
}
