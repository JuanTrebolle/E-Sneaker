package com.example.e_sneaker;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import java.util.ArrayList;
import java.util.List;

public class StoreViewModel extends /*AndroidViewModel*/ ViewModel {
    /*private MutableLiveData<List<Sneaker>> sneakers;
    private MutableLiveData<List<Sneaker>> fireSneakerList;
    private MutableLiveData<List<Sneaker>> cartSneakerList;*/
    private Repository repository;
    private FireViewModel fireViewModel;
    private CartViewModel cartViewModel;

    public StoreViewModel(Application application) {
        /*sneakers = new MutableLiveData<>();
        fireSneakerList = new MutableLiveData<>();
        cartSneakerList = new MutableLiveData<>();*/
        //super(application);
        super();
        fireViewModel.getInstance();
        cartViewModel.getInstance();
    }

    public void getAllSneakers(){
        repository.requestAllSneakers();
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
