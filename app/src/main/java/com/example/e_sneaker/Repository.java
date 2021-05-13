package com.example.e_sneaker;

import java.util.List;

public interface Repository {
    void requestAllSneakers();
    Sneaker getSneakerByName(String name);
    /*void addToFireList(Sneaker sneaker);
    void deleteFromFireList(Sneaker sneaker);
    void addToCart(Sneaker sneaker);
    void deleteFromCart(Sneaker sneaker);*/
}
