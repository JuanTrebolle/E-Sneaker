package com.example.e_sneaker;

import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import java.util.ArrayList;
import java.util.List;

public class StoreViewModel extends ViewModel {
    /*private MutableLiveData<List<Sneaker>> sneakers;
    private MutableLiveData<List<Sneaker>> fireSneakerList;
    private MutableLiveData<List<Sneaker>> cartSneakerList;*/
    private Repository repository;

    public StoreViewModel() {
        /*sneakers = new MutableLiveData<>();
        fireSneakerList = new MutableLiveData<>();
        cartSneakerList = new MutableLiveData<>();*/
    }

    public LiveData<List<Sneaker>> getAllSneakers(){
        return repository.getAllSneakers();
    }

    public void addSneakerToFire(Sneaker sneaker){
        /*List<Sneaker> newList = fireSneakerList.getValue();
        newList.add(sneaker);
        fireSneakerList.setValue(newList);*/
        repository.addToFireList();
    }

    public void addSneakerToCart(Sneaker sneaker){
        /*List<Sneaker> newList = cartSneakerList.getValue();
        newList.add(sneaker);
        cartSneakerList.setValue(newList);*/
        repository.addToCart();
    }
}
