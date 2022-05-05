
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

public class Home_aromatica_PagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public Home_aromatica_PagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount=pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Home_shop_aromatica_food home_shop_aromatica_food = new Home_shop_aromatica_food();
                return home_shop_aromatica_food;


            case 1:
                Home_shop_aromatica_wash home_shop_aromatica_wash = new Home_shop_aromatica_wash();
                return home_shop_aromatica_wash;


            case 2:
                Home_shop_aromatica_body home_shop_aromatica_body = new Home_shop_aromatica_body();
                return home_shop_aromatica_body;

            case 3:
                Home_shop_aromatica_face home_shop_aromatica_face = new Home_shop_aromatica_face();
                return home_shop_aromatica_face;

            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return mPageCount;
    }
}
