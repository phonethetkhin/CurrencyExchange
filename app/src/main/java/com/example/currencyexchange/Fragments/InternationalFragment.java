package com.example.currencyexchange.Fragments;


import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyexchange.Adapters.InternationalAdapter;
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
public class InternationalFragment extends Fragment {
RecyclerView rvInternational;
TextView tvNoconnection;
SwipeRefreshLayout srflInternational;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_international, container, false);
        rvInternational=v.findViewById(R.id.rvInternational);
        tvNoconnection=v.findViewById(R.id.tvNoconnection);
        srflInternational=v.findViewById(R.id.srflInternational);
if(Network())
{
    tvNoconnection.setVisibility(View.GONE);
    rvInternational.setVisibility(View.VISIBLE);
    MainFunction();
}
else
{
    tvNoconnection.setVisibility(View.VISIBLE);
    rvInternational.setVisibility(View.GONE);
    Toast.makeText(getContext(), "No Internet Connection!!! ", Toast.LENGTH_LONG).show();
}
srflInternational.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        srflInternational.setRefreshing(true);
        if(Network())
        {
            tvNoconnection.setVisibility(View.GONE);
            rvInternational.setVisibility(View.VISIBLE);
            MainFunction();
        }
        else
        {
            tvNoconnection.setVisibility(View.VISIBLE);
            rvInternational.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No Internet Connection!!!! ", Toast.LENGTH_LONG).show();
        }
        srflInternational.setRefreshing(false);
    }
});



        return v;
    }
   public boolean Network()
   {
       ConnectivityManager cManager= (ConnectivityManager) getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);
       return cManager.getActiveNetworkInfo()!=null &&cManager.getActiveNetworkInfo().isConnected();
   }
public void MainFunction()
{
    APIs apis= RetrofitOBJ.getRetrofitOBJ("https://api.exchangeratesapi.io/").create(APIs.class);
    Call<JsonObject> jsonObjectCall=apis.getInternationalCurrencyRates("USD");
    jsonObjectCall.enqueue(new Callback<JsonObject>() {
        @Override
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if(response.isSuccessful())
            {
                JsonObject jsonObject=response.body();
                List<CurrencyModel> currencyModelList=new ArrayList<>();

                CurrencyModel cmodel=new CurrencyModel("CAD","Canadian Dollar",R.drawable.canada,jsonObject.get("rates").getAsJsonObject().get("CAD").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("HKD","Hong Kong Dollar",R.drawable.hongkong,jsonObject.get("rates").getAsJsonObject().get("HKD").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("ISK","Icelandic Krona",R.drawable.iceland,jsonObject.get("rates").getAsJsonObject().get("ISK").getAsString());
                currencyModelList.add(cmodel);
                cmodel=new CurrencyModel("PHP","Phillipine Peso",R.drawable.phillipine,jsonObject.get("rates").getAsJsonObject().get("PHP").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("DKK","Danish Krone",R.drawable.denmark,jsonObject.get("rates").getAsJsonObject().get("DKK").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("HUF","Hungarian Forint",R.drawable.hungarian,jsonObject.get("rates").getAsJsonObject().get("DKK").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("CZK","Czech Koruna",R.drawable.czech,jsonObject.get("rates").getAsJsonObject().get("CZK").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("GBP","Pound Sterling",R.drawable.gbp,jsonObject.get("rates").getAsJsonObject().get("GBP").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("RON","Romanian Leu",R.drawable.romanian,jsonObject.get("rates").getAsJsonObject().get("RON").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("SEK","Swedish Krona",R.drawable.sweden,jsonObject.get("rates").getAsJsonObject().get("SEK").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("IDR","Indonesian Rupiah",R.drawable.indone,jsonObject.get("rates").getAsJsonObject().get("IDR").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("INR","Indian Rupee",R.drawable.india,jsonObject.get("rates").getAsJsonObject().get("INR").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("BRL","Brazilian Real",R.drawable.brazil,jsonObject.get("rates").getAsJsonObject().get("BRL").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("RUB","Russian Ruble",R.drawable.russian,jsonObject.get("rates").getAsJsonObject().get("RUB").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("HRK","Croatian Kuna",R.drawable.croatia,jsonObject.get("rates").getAsJsonObject().get("HRK").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("JPY","Japanese Yen",R.drawable.japanese,jsonObject.get("rates").getAsJsonObject().get("JPY").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("THB","Thai Buck",R.drawable.thai,jsonObject.get("rates").getAsJsonObject().get("THB").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("CHF","Swiss Franc",R.drawable.switzerland,jsonObject.get("rates").getAsJsonObject().get("CHF").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("EUR","Euro",R.drawable.euro,jsonObject.get("rates").getAsJsonObject().get("EUR").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("MYR","Malaysian Ringgit",R.drawable.malaysia,jsonObject.get("rates").getAsJsonObject().get("MYR").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("BGN","Bulgarian Lev",R.drawable.bulgarian,jsonObject.get("rates").getAsJsonObject().get("BGN").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("TRY","Turkish Lira",R.drawable.turkey,jsonObject.get("rates").getAsJsonObject().get("TRY").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("CNY","Chinese Yuan",R.drawable.chinese,jsonObject.get("rates").getAsJsonObject().get("CNY").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("NOK","Norwegian Krone",R.drawable.norway,jsonObject.get("rates").getAsJsonObject().get("NOK").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("NZD","New Zealand Dollar",R.drawable.newz,jsonObject.get("rates").getAsJsonObject().get("NZD").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("ZAR","South African Rand",R.drawable.southafrican,jsonObject.get("rates").getAsJsonObject().get("ZAR").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("MXN","Mexican Peso",R.drawable.mexican,jsonObject.get("rates").getAsJsonObject().get("MXN").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("SGD","Singapore Dollar",R.drawable.singapore,jsonObject.get("rates").getAsJsonObject().get("SGD").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("AUD","Australian Dollar",R.drawable.australia,jsonObject.get("rates").getAsJsonObject().get("AUD").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("ILS","New Israeli Sheqel",R.drawable.israel,jsonObject.get("rates").getAsJsonObject().get("ILS").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("KRW","South Korean Won",R.drawable.southkorean,jsonObject.get("rates").getAsJsonObject().get("KRW").getAsString());
                currencyModelList.add(cmodel);

                cmodel=new CurrencyModel("PLN","Polish Zloty",R.drawable.poland,jsonObject.get("rates").getAsJsonObject().get("PLN").getAsString());
                currencyModelList.add(cmodel);

                rvInternational.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                rvInternational.setHasFixedSize(true);
                rvInternational.setAdapter(new InternationalAdapter(currencyModelList));
            }
            else
            {
                Toast.makeText(getContext(), "Error Occured!!!!!"+response.code(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<JsonObject> call, Throwable t) {
//            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
        }
    });

}

}
