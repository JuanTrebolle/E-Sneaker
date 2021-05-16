package com.example.e_sneaker.repository;

import com.example.e_sneaker.model.Sneaker;

public interface Repository {
    void requestAllSneakers();
    Sneaker getSneakerByName(String name);
    /*void addToFireList(Sneaker sneaker);
    void deleteFromFireList(Sneaker sneaker);
    void addToCart(Sneaker sneaker);
    void deleteFromCart(Sneaker sneaker);*/
}
