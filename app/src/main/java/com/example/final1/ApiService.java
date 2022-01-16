package com.example.final1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.6:80/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("/AndroidApi")
    Call<List<ProductModel>> getProduct();


}