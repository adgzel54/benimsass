package com.example.benim;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    @GET("posts")
    Call<List<KriptoModel>> getData();
}
