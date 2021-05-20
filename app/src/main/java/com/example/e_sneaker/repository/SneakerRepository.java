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
        Call<List<Sneaker>> call = sneakersApi.getAllSneakers(50); //minLimit=10 - maxLimit=100
        call.enqueue(new Callback<List<Sneaker>>() {
            @Override
            public void onResponse(Call<List<Sneaker>> call, Response<List<Sneaker>> response) {
                if (response.code() == 200){
                    allSneakers.setValue(response.body());
                } else {
                    ArrayList<Sneaker> trySneaker = new ArrayList<>();

                    trySneaker.add(new Sneaker(1, "Jordan 1 Retro High Pollen", 170, "Jordan", "https://images.stockx.com/images/Air-Jordan-1-Retro-High-Pollen.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1619481956"));
                    trySneaker.add(new Sneaker(12, "adidas Yeezy 500 Taupe Light", 200, "Adidas", "https://images.stockx.com/images/adidas-Yeezy-500-Taupe-Light.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1620285344"));
                    trySneaker.add(new Sneaker(123, "Court Borough Low 2 Black University Red (GS)", 65, "Nike", "https://images.stockx.com/images/Nike-Court-Borough-Low-2-Black-University-Red-GS-Product.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1620407068"));
                    trySneaker.add(new Sneaker(1234, "adidas Yeezy Boost 700 Enflame Amber", 240,"Adidas", "https://images.stockx.com/images/adidas-Yeezy-Boost-700-Enflame-Amber.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1620285285"));
                    trySneaker.add(new Sneaker(12345, "Nike Air Force 1 Low Fresh", 110, "Nike", "https://images.stockx.com/images/Nike-Air-Force-1-Low-Fresh.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1620868623"));
                    trySneaker.add(new Sneaker(123456, "Reebok Club C Power Rangers Yellow", 95, "Reebok", "https://images.stockx.com/images/Reebok-Club-C-Power-Rangers-Yellow.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1620285324"));
                    trySneaker.add(new Sneaker(1234567, "Vans Old Skool Parks Project Checkerboard", 70, "Vans", "https://images.stockx.com/images/Vans-Old-Skool-Parks-Project-Checkerboard.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1621038021"));
                    trySneaker.add(new Sneaker(12345678, "Reebok Club C Cardi Aqua Dust (GS)", 100, "Reebok", "https://images.stockx.com/images/Reebok-Club-C-Cardi-Aqua-Dust-GS.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1621038012"));
                    trySneaker.add(new Sneaker(123456789, "Nike LeBron 18 Light Blue Multicolor", 200, "Nike", "https://images.stockx.com/images/Nike-LeBron-18-Light-Blue-Multicolor.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1621004190"));
                    trySneaker.add(new Sneaker(1234567890, "Jordan 5 Retro Low Wings", 190, "Jordan", "https://images.stockx.com/images/Air-Jordan-5-Retro-Low-Class-of-2020-2021.jpg?fit=fill&bg=FFFFFF&w=300&h=214&auto=format,compress&trim=color&q=90&dpr=2&updated_at=1620083215"));

                    allSneakers.setValue(trySneaker);
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

    //FIRE-SNEAKERS
    public MutableLiveData<List<Sneaker>> getFireSneakers() {
        return sneakerDAO.getFireSneakers();
    }

    public void addToFireList(Sneaker sneaker) {
        sneakerDAO.addSneakerToFireList(sneaker);
    }

    public void deleteFromFireList(Sneaker sneaker) {
        sneakerDAO.deleteSneakerFromFireList(sneaker);
    }

    //CART-SNEAKERS
    public MutableLiveData<List<Sneaker>> getCartSneakers() {
        return sneakerDAO.getCartSneakers();
    }

    public void addToCart(Sneaker sneaker) {
        sneakerDAO.addSneakerToCartList(sneaker);
    }

    public void deleteFromCart(Sneaker sneaker) {
        //Look into async commands e.g. new InsertSneakerAsync(sneakerDAO).execute(sneaker);
        sneakerDAO.deleteSneakerFromCartList(sneaker);
    }
}
