package com.example.e_sneaker;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://v1-sneakers.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static SneakersApi sneakersApi = retrofit.create(SneakersApi.class);

    public static SneakersApi getSneakersApi(){
        return sneakersApi;
    }
}
