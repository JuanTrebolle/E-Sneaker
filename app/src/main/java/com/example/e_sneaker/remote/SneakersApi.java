package com.example.e_sneaker.remote;

import com.example.e_sneaker.model.Sneaker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SneakersApi {

    @GET("api/v1/sneakers/{limit}")
    Call<List<Sneaker>> getAllSneakers(@Path("limit") int limit);

    @GET("api/v1/{brand}")
    Call<List<Sneaker>> getSneakersByBrand(@Path("brand") String brand);
}
