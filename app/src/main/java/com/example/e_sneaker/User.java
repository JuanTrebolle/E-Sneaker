package com.example.e_sneaker;

import java.util.List;

public class User {
    private int userID;
    private String name;
    private String lastName;
    private String email;
    // TODO: how to manage password??
    private int shoeSize;
    private List<Sneaker> favoriteSneakers;
    private List<Sneaker> cartSneakers;

    public User(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public List<Sneaker> getFavoriteSneakers() {
        return favoriteSneakers;
    }

    public List<Sneaker> getCartSneakers() {
        return cartSneakers;
    }
}
