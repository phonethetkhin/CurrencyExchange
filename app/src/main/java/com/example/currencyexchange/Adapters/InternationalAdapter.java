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

import java.util.List;

public class InternationalAdapter extends RecyclerView.Adapter<InternationalAdapter.ViewHolder> {
List<CurrencyModel> currencyModelList;

    public InternationalAdapter(List<CurrencyModel> currencyModelList) {
        this.currencyModelList = currencyModelList;
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
    holder.imgFlag.setImageResource(currencyModelList.get(position).getCountryImage());
    holder.tvCurrencyCode.setText(" 1 USD");
    holder.tvCurrencyName.setText(currencyModelList.get(position).getCurrencyName());
    holder.tvRates.setText(currencyModelList.get(position).getValue()+" "+currencyModelList.get(position).getCurrencyCode());
    }

    @Override
    public int getItemCount() {
        return currencyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgFlag;
        TextView tvCurrencyCode,tvCurrencyName,tvRates;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgFlag=v.findViewById(R.id.imgCountryFlag);
            tvCurrencyCode=v.findViewById(R.id.tvCurrencyCode);
            tvCurrencyName=v.findViewById(R.id.tvCountryName);
            tvRates=v.findViewById(R.id.tvRates);


        }
    }
}
