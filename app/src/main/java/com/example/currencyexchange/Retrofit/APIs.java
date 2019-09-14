package com.example.currencyexchange.Retrofit;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    @GET("latest")
    Call<JsonObject> getLatestCurrency();
}
