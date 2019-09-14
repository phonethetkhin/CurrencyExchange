package com.example.currencyexchange.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.currencyexchange.Fragments.CentralBankFragment;
import com.example.currencyexchange.Fragments.ConverterFragment;
import com.example.currencyexchange.Fragments.InternationalFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
         Fragment fragment=null;
         switch (position)
         {
             case 0:
                 fragment=new CentralBankFragment();
                 break;
             case 1:
                 fragment=new ConverterFragment();
                 break;
             case 2:
                 fragment=new InternationalFragment();
                 break;

         }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
