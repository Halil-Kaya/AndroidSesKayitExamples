package com.example.deneme.service;

import com.example.deneme.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RestInterface {

    @GET("api/test")
    Call<User> getData();

    @Multipart
    @POST("api/test")
    Call<User> postData(
            @Part("id") int id,
            @Part("name") String name
    );

}
