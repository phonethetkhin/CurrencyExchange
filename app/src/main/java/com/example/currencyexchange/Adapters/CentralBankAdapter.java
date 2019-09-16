package com.example.currencyexchange.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchange.Models.CurrencyModel;
import com.example.currencyexchange.R;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class CentralBankAdapter extends RecyclerView.Adapter<CentralBankAdapter.ViewHolder> {
    List<CurrencyModel> cmodellist;

    public CentralBankAdapter(List<CurrencyModel> cmodellist) {
        this.cmodellist = cmodellist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.centralbanklistitem,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

holder.tvCurrencyName.setText(cmodellist.get(position).getCurrencyName());
holder.imgCountryFlag.setImageResource(cmodellist.get(position).getCountryImage());
holder.tvCurrencyCode.setText("1 "+cmodellist.get(position).getCurrencyCode());
holder.tvRates.setText(cmodellist.get(position).getValue()+" MMK");


    }

    @Override
    public int getItemCount() {
        return cmodellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCountryFlag;
        TextView tvCurrencyName,tvRates,tvCurrencyCode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCountryFlag=itemView.findViewById(R.id.imgCountryFlag);
            tvCurrencyName=itemView.findViewById(R.id.tvCountryName);
            tvRates=itemView.findViewById(R.id.tvRates);
            tvCurrencyCode=itemView.findViewById(R.id.tvCurrencyCode);
        }
    }
}
