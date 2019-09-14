package com.example.currencyexchange.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitOBJ {
    public static final String BASE_URL="http://forex.cbm.gov.mm/api/";
    public static Retrofit retrofit=null;

    public static Retrofit getRetrofitOBJ()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
