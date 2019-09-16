package com.example.currencyexchange.Fragments;


import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyexchange.Adapters.SpinnerAdapter;
import com.example.currencyexchange.Models.ConvertModel;
import com.example.currencyexchange.Models.CurrencyModel;
import com.example.currencyexchange.Models.SpinnerModel;
import com.example.currencyexchange.R;
import com.example.currencyexchange.Retrofit.APIs;
import com.example.currencyexchange.Retrofit.RetrofitOBJ;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConverterFragment extends Fragment {
Spinner spnCurrency1,spnCurrency2;
SwipeRefreshLayout srflConverter;
TextView tvHeader,tvFinaloutput,tvNoconnetion;
TextInputEditText tietValue;
Button btnConvert;
List<SpinnerModel> spinnerModelList=new ArrayList<>();
    double Amount;
    double Rates;
    double FinalOutput;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_converter, container, false);
        spnCurrency1=v.findViewById(R.id.spnCurrency1);
        spnCurrency2=v.findViewById(R.id.spnCurrency2);
        tietValue=v.findViewById(R.id.tietValue);
        tvHeader=v.findViewById(R.id.tvHeader);
        tvFinaloutput=v.findViewById(R.id.tvFinalOutput);
        btnConvert=v.findViewById(R.id.btnConvert);
        tvNoconnetion=v.findViewById(R.id.tvNoconnection);
        srflConverter=v.findViewById(R.id.srflConverter);

if(Network())
{
    tvNoconnetion.setVisibility(View.GONE);
    tvHeader.setVisibility(View.VISIBLE);
    spnCurrency1.setVisibility(View.VISIBLE);
    spnCurrency2.setVisibility(View.VISIBLE);
    tietValue.setVisibility(View.VISIBLE);
    btnConvert.setVisibility(View.VISIBLE);

    MainFunction();
}
else
{
    tvNoconnetion.setVisibility(View.VISIBLE);
    tvHeader.setVisibility(View.GONE);
    spnCurrency1.setVisibility(View.GONE);
    spnCurrency2.setVisibility(View.GONE);
    tietValue.setVisibility(View.GONE);
    btnConvert.setVisibility(View.GONE);
    Toast.makeText(getContext(), "No Internet Connection !!!! ", Toast.LENGTH_LONG).show();
}
srflConverter.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        srflConverter.setRefreshing(true);
        if(Network())
        {
            tvNoconnetion.setVisibility(View.GONE);
            tvHeader.setVisibility(View.VISIBLE);
            spnCurrency1.setVisibility(View.VISIBLE);
            spnCurrency2.setVisibility(View.VISIBLE);
            tietValue.setVisibility(View.VISIBLE);
            btnConvert.setVisibility(View.VISIBLE);

            MainFunction();
        }
        else
        {
            tvNoconnetion.setVisibility(View.VISIBLE);
            tvHeader.setVisibility(View.GONE);
            spnCurrency1.setVisibility(View.GONE);
            spnCurrency2.setVisibility(View.GONE);
            tietValue.setVisibility(View.GONE);
            btnConvert.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No Internet Connection !!!! ", Toast.LENGTH_LONG).show();
        }
        srflConverter.setRefreshing(false);
    }
});


        return v;
    }
    public void MainFunction()
    {
        CurrencyCode();


        spnCurrency1.setAdapter(new SpinnerAdapter(getContext(),R.layout.spinnerlistitem,R.id.tvSpinnerItem,spinnerModelList));
        spnCurrency2.setAdapter(new SpinnerAdapter(getContext(),R.layout.spinnerlistitem,R.id.tvSpinnerItem,spinnerModelList));
        spnCurrency1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onResponse();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnCurrency2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onResponse();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void onResponse()
    {
        APIs apicall=RetrofitOBJ.getRetrofitOBJ("https://api.exchangeratesapi.io/").create(APIs.class);
        final Call<JsonObject> jsonobjcall=apicall.getSpecificExchangeRate(spinnerModelList.get(spnCurrency1.getSelectedItemPosition()).getCurrencyCode(),spinnerModelList.get(spnCurrency2.getSelectedItemPosition()).getCurrencyCode());
        jsonobjcall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful())
                {
                    final JsonObject jsonObject=response.body();
                    final String to=spinnerModelList.get(spnCurrency2.getSelectedItemPosition()).getCurrencyCode();

                    btnConvert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(tietValue.getText().toString().trim().length()<=0)
                            {
                                Toast.makeText(getContext(), "Fill Value!!!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Amount = Double.parseDouble(tietValue.getText().toString());
                                Rates=jsonObject.get("rates").getAsJsonObject().get(to).getAsDouble();

                                FinalOutput = Rates * Amount;
                                tvFinaloutput.setText(FinalOutput + " " +to);
                            }
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    private void CurrencyCode() {
        SpinnerModel smodel=new SpinnerModel("USD",R.drawable.usa);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("CAD",R.drawable.canada);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("HKD",R.drawable.hongkong);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("ISK",R.drawable.iceland);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("PHP",R.drawable.phillipine);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("DKK",R.drawable.denmark);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("HUF",R.drawable.hungarian);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("CZK",R.drawable.czech);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("GBP",R.drawable.gbp);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("RON",R.drawable.romanian);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("SEK",R.drawable.sweden);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("IDR",R.drawable.indone);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("INR",R.drawable.india);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("BRL",R.drawable.brazil);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("RUB",R.drawable.russian);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("HRK",R.drawable.croatia);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("JPY",R.drawable.japanese);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("THB",R.drawable.thai);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("CHF",R.drawable.switzerland);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("EUR",R.drawable.euro);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("MYR",R.drawable.malaysia);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("BGN",R.drawable.bulgarian);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("TRY",R.drawable.turkey);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("CNY",R.drawable.chinese);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("NOK",R.drawable.norway);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("NZD",R.drawable.newz);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("ZAR",R.drawable.southafrican);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("MXN",R.drawable.mexican);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("SGD",R.drawable.singapore);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("AUD",R.drawable.australia);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("ILS",R.drawable.israel);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("KRW",R.drawable.southkorean);
        spinnerModelList.add(smodel);

        smodel=new SpinnerModel("PLN",R.drawable.poland);
        spinnerModelList.add(smodel);




    }
    public boolean Network()
    {
        ConnectivityManager cManager= (ConnectivityManager) getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);
        return cManager.getActiveNetworkInfo()!=null &&cManager.getActiveNetworkInfo().isConnected();
    }

}
