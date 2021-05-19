package com.example.e_sneaker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class CartViewModel extends ViewModel {
    private CartViewModel instance;
    SneakerRepository sneakerRepository;

    public CartViewModel() {
        sneakerRepository = SneakerRepository.getInstance();
    }

    public CartViewModel getInstance(){
        if (instance == null){
            instance = new CartViewModel();
        }
        return instance;
    }

    public LiveData<List<Sneaker>> getCartSneakersList(){
        return sneakerRepository.getCartSneakers();
    }

    public void addToCartList(Sneaker sneaker){
        sneakerRepository.addToCart(sneaker);
    }

    public void deleteFromCartList(Sneaker sneaker){
        sneakerRepository.deleteFromCart(sneaker);
    }
}
