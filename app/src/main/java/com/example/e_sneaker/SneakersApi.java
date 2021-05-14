package com.example.e_sneaker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SneakersApi {

    //@GET("https://v1-sneakers.p.rapidapi.com/v1/sneakers")

    @GET("api/v1/sneakers")
    Call<List<Sneaker>> getAllSneakers(@Path("limit") int limit);

    @GET("api/v1/{brand}")
    Call<List<Sneaker>> getSneakersByBrand(@Path("brand") String brand);

    /*@GET("api/v1/sneakers/{name}")
    Call<SneakerResponse> getSneakerByName(@Path("name") String name);*/
}
