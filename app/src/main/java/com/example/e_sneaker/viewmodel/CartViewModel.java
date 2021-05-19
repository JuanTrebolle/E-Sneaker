package com.example.e_sneaker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class CartViewModel extends ViewModel {
    SneakerRepository sneakerRepository;

    public CartViewModel() {
        sneakerRepository = SneakerRepository.getInstance();
    }

    public LiveData<List<Sneaker>> getCartSneakersList(){
        return sneakerRepository.getCartSneakers();
    }

    public void addToCartList(Sneaker sneaker){
        sneakerRepository.addToCart(sneaker);
    }

    /* Done in SneakerRepository instead
    public void deleteFromCartList(Sneaker sneaker){
        sneakerRepository.deleteFromCart(sneaker);
    }*/
}
