package com.example.e_sneaker.model;

import com.example.e_sneaker.model.Sneaker;

import java.util.List;

//@Entity(tableName = "user_table")
public class User {
    //@PrimaryKey(autoGenerate = true)
    private long userID;
    private String name;
    private String lastName;
    private String email;
    private int shoeSize;
    private List<Sneaker> fireSneakers;
    private List<Sneaker> cartSneakers;

    public User(int userID) {
        this.userID = userID;
    }

    public long getUserID() {
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
        return fireSneakers;
    }

    public void setFavoriteSneakers(List<Sneaker> favoriteSneakers) {
        this.fireSneakers = favoriteSneakers;
    }

    public List<Sneaker> getCartSneakers() {
        return cartSneakers;
    }

    public void setCartSneakers(List<Sneaker> cartSneakers) {
        this.cartSneakers = cartSneakers;
    }
}
