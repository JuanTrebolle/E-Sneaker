package com.example.e_sneaker.viewmodel;

//import android.app.Application;

//import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import java.util.ArrayList;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class StoreViewModel extends ViewModel {
    private MutableLiveData<List<Sneaker>> allSneakers;
    private SneakerRepository sneakerRepository;
    private FireViewModel fireViewModel;
    private CartViewModel cartViewModel;

    public StoreViewModel() {
        super();
        sneakerRepository = SneakerRepository.getInstance();
        allSneakers = sneakerRepository.requestAllSneakers();
        fireViewModel.getInstance();
        cartViewModel.getInstance();
    }

    public MutableLiveData<List<Sneaker>> getAllSneakers() {
        return allSneakers;
    }

    public void addSneakerToFire(Sneaker sneaker){
        /*List<Sneaker> newList = fireSneakerList.getValue();
        newList.add(sneaker);
        fireSneakerList.setValue(newList);*/

        //repository.addToFireList(sneaker);
        fireViewModel.addToFireList(sneaker);
    }

    public LiveData<List<Sneaker>> getFireSneakers(){
        return sneakerRepository.getFireSneakers();
    }

    public void addSneakerToCart(Sneaker sneaker){
        /*List<Sneaker> newList = cartSneakerList.getValue();
        newList.add(sneaker);
        cartSneakerList.setValue(newList);*/

        //repository.addToCart(sneaker);
        cartViewModel.addToCartList(sneaker);
    }

    public LiveData<List<Sneaker>> getCartSneakers(){
        return sneakerRepository.getCartSneakers();
    }
}
