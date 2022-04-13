package com.example.wonderv2.Home_product;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Product_PagerAdapter extends FragmentPagerAdapter{
    private FragmentManager fm;
    private FragmentTransaction ft;
    private final int numberOfFragment;

    public Product_PagerAdapter(FragmentManager fm, int numberOfFragment) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numberOfFragment = numberOfFragment;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Product_food();
            case 1:
                return new Product_wash();
            case 2:
                return new Product_body();
            default:
                return new Product_face();
        }
    }
    @Override
    public int getCount(){
        return numberOfFragment;
    }

}
