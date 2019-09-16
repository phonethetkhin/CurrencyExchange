package com.example.currencyexchange.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.currencyexchange.Models.SpinnerModel;
import com.example.currencyexchange.R;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter {
    List<SpinnerModel> spinnerModelslist;

    public SpinnerAdapter(@NonNull Context context, int resource, int textViewResourceId, List<SpinnerModel> spinnerModelslist) {
        super(context, resource, textViewResourceId);
        this.spinnerModelslist = spinnerModelslist;
    }

    @Override
    public int getCount() {
        return spinnerModelslist.size();
    }

   public View getCustomView(int i,View v,ViewGroup parent)
   {
       ImageView imgCurrencyPhoto;
       TextView tvSpinnerListitem;
v=LayoutInflater.from(parent.getContext()).inflate(R.layout.spinnerlistitem,parent,false);
tvSpinnerListitem=v.findViewById(R.id.tvSpinnerItem);
imgCurrencyPhoto=v.findViewById(R.id.imgFlag);

tvSpinnerListitem.setText(spinnerModelslist.get(i).getCurrencyCode());
imgCurrencyPhoto.setImageResource(spinnerModelslist.get(i).getCountryFlag());
       return v;
   }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i,view,viewGroup);
    }
}
