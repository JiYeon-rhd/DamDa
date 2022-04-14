package com.example.wonderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.wonderv2.AR.AR_main;
import com.example.wonderv2.Exp.Exp_main;
import com.example.wonderv2.Home.Home_loca_list;
import com.example.wonderv2.Home.Home_loca_map;
import com.example.wonderv2.Home.Home_main;
import com.example.wonderv2.Home.Home_shop_detail;
import com.example.wonderv2.Home.Home_shop_finder;
import com.example.wonderv2.Home_product.Home_product;
import com.example.wonderv2.Home_product.Product_body;
import com.example.wonderv2.Home_product.Product_face;
import com.example.wonderv2.Home_product.Product_food;
import com.example.wonderv2.Home_product.Product_wash;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavi;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Home_main home_main;
    private AR_main ar_main;
    private Exp_main exp_main;

    private Home_product home_product;
    private Home_loca_map home_loca_map;
    private Home_loca_list home_loca_list;
    private Home_shop_detail home_shop_detail;
    private Home_shop_finder home_shop_finder;

    Fragment fragment1, fragment2, fragment3, fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment1 = new Product_food();
        fragment2 = new Product_wash();
        fragment3 = new Product_body();
        fragment4 = new Product_face();


        home_main = new Home_main();
        ar_main = new AR_main();
        exp_main = new Exp_main();
        setFrag(0);

        home_product = new Home_product();
        home_loca_map = new Home_loca_map();
        home_loca_list = new Home_loca_list();
        home_shop_finder = new Home_shop_finder();

        bottomNavi = findViewById(R.id.bottom_navi);
        bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        setFrag(0);
                        break;
                    case R.id.ar_fragment:
                        setFrag(1);
                        break;
                    case R.id.exp_fragment:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });


    }

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0: //홈화면
                ft.replace(R.id.main_frame, home_main);
                ft.commit();
                break;
            case 1: //ar 화면
                ft.replace(R.id.main_frame, ar_main);
                ft.commit();
                break;
            case 2: //유통기한 화면
                ft.replace(R.id.main_frame, exp_main);
                ft.commit();
                break;

            case 3: //홈화면 -> 제품화면 으로 이동
                ft.replace(R.id.main_frame, home_product);
                ft.commit();
                break;

            case 4: //홈화면 -> 위치(맵)화면
                ft.replace(R.id.main_frame, home_loca_map);
                ft.commit();
                break;
            case 5: //홈화면 -> 위치(리스트)화면
                ft.replace(R.id.main_frame, home_loca_list);
                ft.commit();
                break;

            case 6: //홈화면 -> 매장확인하기 화면
                ft.replace(R.id.main_frame, home_shop_finder);
                ft.commit();
                break;

        }
    }
}