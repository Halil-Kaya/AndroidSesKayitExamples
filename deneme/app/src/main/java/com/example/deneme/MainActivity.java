package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.deneme.model.User;
import com.example.deneme.service.ApiClient;
import com.example.deneme.service.RestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RestInterface restInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restInterface = ApiClient.getClient().create(RestInterface.class);
/*
        Call<User> call = restInterface.getData();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                System.out.println("veri geldi!");


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("hata" + t.getMessage());
            }
        });

    }
    */

        Call<User> call = restInterface.postData(1,"Halil Kaya");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                System.out.println("user id: " + user.getId());
                System.out.println("user name: " + user.getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }
}