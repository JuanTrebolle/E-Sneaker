package com.example.e_sneaker;

public class CartViewModel {
    private CartViewModel instance;

    public CartViewModel getInstance(){
        if (instance == null){
            instance = new CartViewModel();
        }
        return instance;
    }

    public void addToCartList(Sneaker sneaker){
        //TODO
    }

    public void deleteFromCartList(Sneaker sneaker){
        //TODO
    }
}
