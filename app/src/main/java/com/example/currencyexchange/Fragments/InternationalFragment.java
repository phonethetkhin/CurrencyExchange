package com.example.currencyexchange.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.currencyexchange.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InternationalFragment extends Fragment {


    public InternationalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_international, container, false);
    }

}
