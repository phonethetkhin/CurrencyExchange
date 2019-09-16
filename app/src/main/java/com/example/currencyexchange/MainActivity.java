package com.example.currencyexchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.currencyexchange.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tlMain;
    ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tlMain=findViewById(R.id.tlMain);
        vpMain=findViewById(R.id.vpMain);

        ViewPagerAdapter vpAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpMain.setAdapter(vpAdapter);
        vpMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlMain));
        getSupportActionBar().setTitle("Central Bank Exchange Rates");
        tlMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
vpMain.setCurrentItem(tab.getPosition());
String title="";
switch (tab.getPosition())
{
    case 0:
        title="Central Bank Exchange Rates";
        break;
    case 1:
        title="Currency Converter";
        break;
    case 2:
        title="International Exchange Rates";
        break;

}
getSupportActionBar().setTitle(title);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
