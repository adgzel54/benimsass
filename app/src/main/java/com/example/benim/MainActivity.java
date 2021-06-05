package com.example.benim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<KriptoModel> kriptoModels;
    private String BASE_URL = "https://jsonplaceholder.typicode.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RAdapter rAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData();






    }
    private void loadData() {
        CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);
        Call<List<KriptoModel>> call = cryptoAPI.getData();
        call.enqueue(new Callback<List<KriptoModel>>() {
            @Override
            public void onResponse(Call<List<KriptoModel>> call, Response<List<KriptoModel>> response) {
                if (response.isSuccessful())  {
                    List<KriptoModel> responseList = response.body();
                    kriptoModels = new ArrayList<>(responseList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rAdapter = new RAdapter(kriptoModels);
                    recyclerView.setAdapter(rAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<KriptoModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}