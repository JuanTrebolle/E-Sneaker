package com.example.e_sneaker.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.e_sneaker.dao.SneakerDAO;
import com.example.e_sneaker.dao.UserDAO;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.remote.ServiceGenerator;
import com.example.e_sneaker.remote.SneakersApi;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SneakerRepository {
    private UserDAO userDAO;
    private SneakerDAO sneakerDAO;
    private MutableLiveData<List<Sneaker>> allSneakers;
    private MutableLiveData<List<Sneaker>> sneakersByBrand;
    private MutableLiveData<List<Sneaker>> fireSneakers;
    private MutableLiveData<List<Sneaker>> cartSneakers;
    private SneakersApi sneakersApi;

    private static SneakerRepository instance;

    private SneakerRepository(){
        userDAO = UserDAO.getInstance();
        sneakerDAO = SneakerDAO.getInstance();
        allSneakers = new MutableLiveData<>();
        sneakersByBrand = new MutableLiveData<>();
        fireSneakers = new MutableLiveData<>();
        cartSneakers = new MutableLiveData<>();
        sneakersApi = ServiceGenerator.getSneakersApi();
        requestAllSneakers();
    }

    public static synchronized SneakerRepository getInstance(){
        if (instance == null){
            instance = new SneakerRepository();
        }
        return instance;
    }

    //API REQUESTS
    public MutableLiveData<List<Sneaker>> requestAllSneakers(){
        Call<List<Sneaker>> call = sneakersApi.getAllSneakers(100); //requesting 100 sneakers
        call.enqueue(new Callback<List<Sneaker>>() {
            @Override
            public void onResponse(Call<List<Sneaker>> call, Response<List<Sneaker>> response) {
                if (response.code() == 200){
                    allSneakers.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Sneaker>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Log.i("Retrofit", t.getMessage());
                t.printStackTrace();
            }
        });
        return allSneakers;
    }

    public void requestSneakersByBrand(String brand){
        Call<List<Sneaker>> call = sneakersApi.getSneakersByBrand(brand);
        call.enqueue(new Callback<List<Sneaker>>() {
            @Override
            public void onResponse(Call<List<Sneaker>> call, Response<List<Sneaker>> response) {
                if (response.code() == 200){
                    //sneakersByBrand = response.body().getSneakersByBrand(brand);
                    sneakersByBrand.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Sneaker>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Log.i("Retrofit", t.getMessage());
                t.printStackTrace();
            }
        });
    }


    //CALLS TO DAO

    /*public MutableLiveData<List<Sneaker>> getAllSneakers(){
        return allSneakers;
    }

    public MutableLiveData<List<Sneaker>> getSneakersByBrand(String brand){
        return sneakersByBrand;
    }*/

    public void addToFireList(Sneaker sneaker) {
        sneakerDAO.addSneakerToFireList(sneaker);
    }

    public void deleteFromFireList(Sneaker sneaker) {
        sneakerDAO.deleteSneakerFromFireList(sneaker);
    }

    public void addToCart(Sneaker sneaker) {
        sneakerDAO.addSneakerToCartList(sneaker);
    }

    public void deleteFromCart(Sneaker sneaker) {
        //Look into async commands e.g. new InsertSneakerAsync(sneakerDAO).execute(sneaker);
        sneakerDAO.deleteSneakerFromCartList(sneaker);
    }
}
