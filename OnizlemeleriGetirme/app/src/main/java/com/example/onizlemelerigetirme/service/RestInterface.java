package com.example.onizlemelerigetirme.service;

import com.example.onizlemelerigetirme.model.Onizleme;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("api/onizleme")
    Call<List<Onizleme>> getRepo();

}
