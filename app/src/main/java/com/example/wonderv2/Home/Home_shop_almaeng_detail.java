package com.example.wonderv2.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.example.wonderv2.Setting.Setting_alarm;
import com.google.android.material.tabs.TabLayout;

public class Home_shop_almaeng_detail extends AppCompatActivity {
    MainActivity activity;

    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Home_PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_shop_almaeng_detail);
        mContext = getApplicationContext();
        mTabLayout=(TabLayout) findViewById(R.id.tabs);

        mTabLayout.addTab(mTabLayout.newTab().setText("푸드"));
        mTabLayout.addTab(mTabLayout.newTab().setText("세제"));
        mTabLayout.addTab(mTabLayout.newTab().setText("바디"));
        mTabLayout.addTab(mTabLayout.newTab().setText("페이스"));

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPageAdapter = new Home_PagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
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
    }

    }