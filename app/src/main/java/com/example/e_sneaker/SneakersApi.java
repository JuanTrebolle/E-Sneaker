package com.example.e_sneaker;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SneakersApi {

    //@GET("https://v1-sneakers.p.rapidapi.com/v1/sneakers")
    @GET("api/v1/sneakers")
    Call<SneakerResponse> getAllSneakers();

    @GET("api/v1/{brand}")
    Call<SneakerResponse> getSneakersByBrand(@Path("brand") String brand);

    /*@GET("api/v1/sneakers/{name}")
    Call<SneakerResponse> getSneakerByName(@Path("name") String name);*/
}
