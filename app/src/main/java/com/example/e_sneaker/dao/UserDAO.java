package com.example.e_sneaker.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDAO {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref;

    private static UserDAO instance;
    private static Object lock = new Object();

    public UserDAO() {
        ref = database.getReference();
    }

    public static UserDAO getInstance(){
        if (instance == null){
            synchronized (lock) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }
}
