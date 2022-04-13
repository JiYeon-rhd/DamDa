package com.example.wonderv2.Exp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.wonderv2.Home_product.Product_body;
import com.example.wonderv2.Home_product.Product_face;
import com.example.wonderv2.Home_product.Product_food;
import com.example.wonderv2.Home_product.Product_wash;

public class Exp_PagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fm;
    private FragmentTransaction ft;
    private final int numberOfFragment;

    public Exp_PagerAdapter(@NonNull FragmentManager fm, int numberOfFragment) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numberOfFragment = numberOfFragment;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Exp_food();
            case 1:
                return new Exp_wash();
            case 2:
                return new Exp_body();
            default:
                return new Exp_face();
        }
    }
    @Override
    public int getCount(){
        return numberOfFragment;
    }


}
