package com.example.currencyexchange.Retrofit;

import com.example.currencyexchange.Models.SpinnerModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIs {
    @GET("latest")
    Call<JsonObject> getLatestCurrency();

@GET("latest")
    Call<JsonObject> getInternationalCurrencyRates(
@Query("base") String Base


);

@GET("latest")
    Call<JsonObject> getSpecificExchangeRate(
            @Query("base") String base,
            @Query("symbols") String symbols

);



}
