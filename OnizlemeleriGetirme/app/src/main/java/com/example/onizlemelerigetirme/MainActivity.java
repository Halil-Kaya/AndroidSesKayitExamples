package com.example.onizlemelerigetirme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.onizlemelerigetirme.model.Onizleme;
import com.example.onizlemelerigetirme.service.ApiClient;
import com.example.onizlemelerigetirme.service.RestInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RestInterface restInterface = ApiClient.getClient().create(RestInterface.class);

        Call<List<Onizleme>> call = restInterface.getRepo();
        call.enqueue(new Callback<List<Onizleme>>() {
            @Override
            public void onResponse(Call<List<Onizleme>> call, Response<List<Onizleme>> response) {
                Toast.makeText(MainActivity.this,"islemBasarili",Toast.LENGTH_SHORT).show();
                System.out.println(response);
                List<Onizleme> onizlemes = response.body();

                for(Onizleme onizleme : onizlemes){

                    System.out.println("onizlemeId: " + onizleme.getOnIzlemeId());
                    System.out.println("onizlemeUr: l" + onizleme.getUrl());
                    System.out.println("onizleme boyut: " + onizleme.getBoyut());

                    System.out.println("onizleme altyapi ad: " + onizleme.getAltyapiAltyapi().getAd());
                    System.out.println("onizleme-altyapi boyut: " + onizleme.getAltyapiAltyapi().getBoyut());
                    System.out.println("onizleme-altyapi foto-url: " + onizleme.getAltyapiAltyapi().getFotoUrl());
                    System.out.println("onizleme-altyapi music-url: " + onizleme.getAltyapiAltyapi().getUrl());
                    System.out.println("--------------------------------------------------------------");
                }


            }

            @Override
            public void onFailure(Call<List<Onizleme>> call, Throwable t) {

            }
        });

    }
}