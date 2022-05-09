package com.example.wonderv2.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.wonderv2.AR.AR_complete;
import com.example.wonderv2.AR.AR_main;
import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.google.android.material.tabs.TabLayout;

public class Home_shop_aromatica_detail extends AppCompatActivity {
    MainActivity activity;

    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Home_aromatica_PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_shop_aromatica_detail);
        mContext = getApplicationContext();
        mTabLayout=(TabLayout) findViewById(R.id.tabs);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));

        mTabLayout.addTab(mTabLayout.newTab().setText("푸드"));
        mTabLayout.addTab(mTabLayout.newTab().setText("세제"));
        mTabLayout.addTab(mTabLayout.newTab().setText("바디"));
        mTabLayout.addTab(mTabLayout.newTab().setText("페이스"));

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPageAdapter = new Home_aromatica_PagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mPageAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ImageButton close_btn=findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button scan_btn = findViewById(R.id.scan_btn);
        scan_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity.setFrag(1);
            }
        });
    }

}