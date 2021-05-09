package com.example.e_sneaker;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface Repository {
    LiveData<List<Sneaker>> getAllSneakers();
    void addToFireList();
    void deleteFromFireList();
    void addToCart();
    void deleteFromCart();
}
