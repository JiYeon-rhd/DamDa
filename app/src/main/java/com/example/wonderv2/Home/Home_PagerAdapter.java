package com.example.wonderv2.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wonderv2.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Home_PagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public Home_PagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount=pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Home_shop_food home_shop_food = new Home_shop_food();
                return home_shop_food;


            case 1:
                Home_shop_wash home_shop_wash = new Home_shop_wash();
                return home_shop_wash;


            case 2:
                Home_shop_body home_shop_body = new Home_shop_body();
                return home_shop_body;

            case 3:
                Home_shop_face home_shop_face = new Home_shop_face();
                return home_shop_face;

            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return mPageCount;
    }
}
