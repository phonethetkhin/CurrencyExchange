package com.example.currencyexchange.Fragments;


import android.icu.text.MessagePattern;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.currencyexchange.Adapters.CentralBankAdapter;
import com.example.currencyexchange.Models.CurrencyModel;
import com.example.currencyexchange.R;
import com.example.currencyexchange.Retrofit.APIs;
import com.example.currencyexchange.Retrofit.RetrofitOBJ;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CentralBankFragment extends Fragment {
RecyclerView rvMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_central_bank, container, false);
        rvMain=v.findViewById(R.id.rvMain);

        APIs apis= RetrofitOBJ.getRetrofitOBJ().create(APIs.class);
        Call<JsonObject> jsonObject=apis.getLatestCurrency();
            jsonObject.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if(response.isSuccessful())
                    {

JsonObject json=response.body();
List<CurrencyModel> currencyModelList=new ArrayList<>();

                        CurrencyModel cmodel=new CurrencyModel("USD","US Dollar",R.drawable.usa,json.get("rates").getAsJsonObject().get("USD").getAsString());
                        currencyModelList.add(cmodel);

                         cmodel=new CurrencyModel("LKR","Sri Lankan Rupee",R.drawable.srilanka,json.get("rates").getAsJsonObject().get("LKR").getAsString());
                        currencyModelList.add(cmodel);

                         cmodel=new CurrencyModel("NZD","New Zealand Dollar",R.drawable.newz,json.get("rates").getAsJsonObject().get("NZD").getAsString());
                        currencyModelList.add(cmodel);


                         cmodel=new CurrencyModel("JPY","Japanese Yen",R.drawable.japanese,json.get("rates").getAsJsonObject().get("JPY").getAsString());
                        currencyModelList.add(cmodel);

                         cmodel=new CurrencyModel("CZK","Czech Koruna",R.drawable.czech,json.get("rates").getAsJsonObject().get("CZK").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("VND","Vietnamese Dong",R.drawable.vietnam,json.get("rates").getAsJsonObject().get("VND").getAsString());
                        currencyModelList.add(cmodel);


                         cmodel=new CurrencyModel("PHP","Phillipine Peso",R.drawable.phillipine,json.get("rates").getAsJsonObject().get("PHP").getAsString());
                        currencyModelList.add(cmodel);


                         cmodel=new CurrencyModel("KRW","South Korean Won",R.drawable.southkorean,json.get("rates").getAsJsonObject().get("KRW").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("HKD","Hong Kong Dollar",R.drawable.hongkong,json.get("rates").getAsJsonObject().get("HKD").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("BRL","Brazilian Real",R.drawable.brazil,json.get("rates").getAsJsonObject().get("BRL").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("MYR","Malaysian Ringgit",R.drawable.malaysia,json.get("rates").getAsJsonObject().get("MYR").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("RSD","Serbian Dinar",R.drawable.serbia,json.get("rates").getAsJsonObject().get("RSD").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("CAD","Canadian Dollar",R.drawable.canada,json.get("rates").getAsJsonObject().get("CAD").getAsString());
                        currencyModelList.add(cmodel);

                       cmodel=new CurrencyModel("GBP","Great British Pound",R.drawable.euro,json.get("rates").getAsJsonObject().get("GBP").getAsString());
                       currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("SEK","Swedish Krona",R.drawable.sweden,json.get("rates").getAsJsonObject().get("SEK").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("NOK","Norwegian Krone",R.drawable.norway,json.get("rates").getAsJsonObject().get("NOK").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("ILS","New Israeli Sheqel",R.drawable.israel,json.get("rates").getAsJsonObject().get("ILS").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("DKK","Danish Krone",R.drawable.denmark,json.get("rates").getAsJsonObject().get("DKK").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("AUD","Australian Dollar",R.drawable.australia,json.get("rates").getAsJsonObject().get("AUD").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("RUB","Russian Ruble",R.drawable.russian,json.get("rates").getAsJsonObject().get("RUB").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("KWD","Kuwaiti Dinar",R.drawable.kuwait,json.get("rates").getAsJsonObject().get("KWD").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("INR","Indian Rupee",R.drawable.india,json.get("rates").getAsJsonObject().get("INR").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("BND","Brunei Dollar",R.drawable.brunei,json.get("rates").getAsJsonObject().get("BND").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("EUR","Euro",R.drawable.euro,json.get("rates").getAsJsonObject().get("EUR").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("ZAR","South African Rand",R.drawable.southafrican,json.get("rates").getAsJsonObject().get("ZAR").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("NPR","Nepalese Rupee",R.drawable.nepal,json.get("rates").getAsJsonObject().get("NPR").getAsString());
                        currencyModelList.add(cmodel);

                       cmodel=new CurrencyModel("CNY","Chinese Yuan",R.drawable.chinese,json.get("rates").getAsJsonObject().get("CNY").getAsString());
                        currencyModelList.add(cmodel);

                        cmodel=new CurrencyModel("CHF","Swiss Franc",R.drawable.switzerland,json.get("rates").getAsJsonObject().get("CHF").getAsString());
                        currencyModelList.add(cmodel);






                        rvMain.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                        rvMain.setHasFixedSize(true);
                        rvMain.setAdapter(new CentralBankAdapter(currencyModelList));
                    }
                    else
                    {

                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });







        return v;

    }

}
