package com.example.e_sneaker;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SneakerRepository implements Repository{
    /*private UserDAO userDAO;
    private SneakerDAO sneakerDAO;*/
    private MutableLiveData<List<Sneaker>> allSneakers;
    private MutableLiveData<List<Sneaker>> sneakersByBrand;
    private MutableLiveData<List<Sneaker>> fireSneakers;
    private MutableLiveData<List<Sneaker>> cartSneakers;
    private SneakersApi sneakersApi;

    private static SneakerRepository instance;

    private SneakerRepository(/*Application application*/){
        /*ESneakerDatabase database = ESneakerDatabase.getInstance(application); //Room needs app context
        userDAO = database.userDAO();
        sneakerDAO = database.sneakerDAO();*/
        allSneakers = new MutableLiveData<>();
        sneakersByBrand = new MutableLiveData<>();
        fireSneakers = new MutableLiveData<>();
        cartSneakers = new MutableLiveData<>();
        /*sneakersByBrand = new ArrayList<>();
        fireSneakers = new ArrayList<>();
        cartSneakers = new ArrayList<>();*/
        sneakersApi = ServiceGenerator.getSneakersApi();
        requestAllSneakers();
    }

    public static synchronized SneakerRepository getInstance(){
        if (instance == null){
            instance = new SneakerRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Sneaker>> getAllSneakers(){
        return allSneakers;
    }

    public void requestAllSneakers(){
        Call<List<Sneaker>> call = sneakersApi.getAllSneakers(100);
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
        //return (List<Sneaker>) allSneakers;
    }

    public MutableLiveData<List<Sneaker>> getSneakersByBrand(){
        return sneakersByBrand;
    }

    /*public List<Sneaker> requestSneakersByBrand(String brand){
        Call<SneakerResponse> call = sneakersApi.getSneakersByBrand(brand);
        call.enqueue(new Callback<SneakerResponse>() {
            @Override
            public void onResponse(Call<SneakerResponse> call, Response<SneakerResponse> response) {
                if (response.code() == 200){
                    //sneakersByBrand = response.body().getSneakersByBrand(brand);
                }
            }

            @Override
            public void onFailure(Call<SneakerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Log.i("Retrofit", t.getMessage());
                t.printStackTrace();
            }
        });
        return null;
    }*/

    public Sneaker getSneakerByName(String name){
        /*for (int i = 0; i < fireSneakers) {
            if (item.getModelName().equals(name)){
                return item;
            }
        }*/
        return null;
    }

    /*@Override
    public void addToFireList(Sneaker sneaker) {
        fireSneakers.add(sneaker);
    }

    @Override
    public void deleteFromFireList(Sneaker sneaker) {
        for (Sneaker item : fireSneakers) {
            if (item.equals(sneaker)){
                fireSneakers.remove(sneaker);
            }
        }
    }

    @Override
    public void addToCart(Sneaker sneaker) {
        cartSneakers.add(sneaker);
    }

    @Override
    public void deleteFromCart(Sneaker sneaker) {
        //Look into async commands e.g. new InsertSneakerAsync(sneakerDAO).execute(sneaker);
        for (Sneaker item : cartSneakers) {
            if (item.equals(sneaker)){
                cartSneakers.remove(sneaker);
            }
        }
    }*/
}
