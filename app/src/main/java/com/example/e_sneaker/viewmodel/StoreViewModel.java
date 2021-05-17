package com.example.e_sneaker.viewmodel;

import android.app.Application;

//import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import java.util.ArrayList;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class StoreViewModel extends ViewModel {
    private MutableLiveData<List<Sneaker>> allSneakers;
    private MutableLiveData<List<Sneaker>> fireSneakerList;
    private MutableLiveData<List<Sneaker>> cartSneakerList;
    private SneakerRepository sneakerRepository;
    private FireViewModel fireViewModel;
    private CartViewModel cartViewModel;

    public StoreViewModel() {
        super();
        allSneakers = new MutableLiveData<>();
        //TODO observe lists
        fireSneakerList = new MutableLiveData<>();
        cartSneakerList = new MutableLiveData<>();
        fireViewModel.getInstance();
        cartViewModel.getInstance();
    }

    public void getAllSneakers(){
        sneakerRepository.requestAllSneakers();
    }

    public void addSneakerToFire(Sneaker sneaker){
        /*List<Sneaker> newList = fireSneakerList.getValue();
        newList.add(sneaker);
        fireSneakerList.setValue(newList);*/

        //repository.addToFireList(sneaker);
        fireViewModel.addToFireList(sneaker);
    }

    public void addSneakerToCart(Sneaker sneaker){
        /*List<Sneaker> newList = cartSneakerList.getValue();
        newList.add(sneaker);
        cartSneakerList.setValue(newList);*/

        //repository.addToCart(sneaker);
        cartViewModel.addToCartList(sneaker);
    }
}
