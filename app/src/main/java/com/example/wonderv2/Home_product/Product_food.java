package com.example.wonderv2.Home_product;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.wonderv2.Home.Home_shop_detail;
import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Product_food#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_food extends Fragment {
    MainActivity activity;

    Button tea_btn;
    Button coffee_btn;
    Button spice_btn;
    Button oatmeal_btn;
    Button shop1_detail1;
    Button shop1_datail2;
    Button shop1_datail3;
    Button shop1_datail4;

    LinearLayout product_tea;
    LinearLayout product_coffee;
    LinearLayout product_spice;
    LinearLayout product_oatmeal;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Product_food() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Product_food.
     */
    // TODO: Rename and change types and number of parameters
    public static Product_food newInstance(String param1, String param2) {
        Product_food fragment = new Product_food();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.product_food, container, false);

        product_tea=(LinearLayout) v.findViewById(R.id.product_tea);
        product_coffee=(LinearLayout) v.findViewById(R.id.product_coffee);
        product_spice=(LinearLayout) v.findViewById(R.id.product_spice);
        product_oatmeal=(LinearLayout) v.findViewById(R.id.product_oatmeal);

        tea_btn=(Button) v.findViewById(R.id.tea_btn);
        tea_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_tea.setVisibility(View.VISIBLE);
                product_coffee.setVisibility(View.INVISIBLE);
                product_spice.setVisibility(View.INVISIBLE);
                product_oatmeal.setVisibility(View.INVISIBLE);
            }
        });
        coffee_btn=(Button) v.findViewById(R.id.coffee_btn);
        coffee_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_tea.setVisibility(View.INVISIBLE);
                product_coffee.setVisibility(View.VISIBLE);
                product_spice.setVisibility(View.INVISIBLE);
                product_oatmeal.setVisibility(View.INVISIBLE);
            }
        });
        spice_btn=(Button) v.findViewById(R.id.spice_btn);
        spice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_tea.setVisibility(View.INVISIBLE);
                product_coffee.setVisibility(View.INVISIBLE);
                product_spice.setVisibility(View.VISIBLE);
                product_oatmeal.setVisibility(View.INVISIBLE);
            }
        });
        oatmeal_btn=(Button) v.findViewById(R.id.oatmeal_btn);
        oatmeal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_tea.setVisibility(View.INVISIBLE);
                product_coffee.setVisibility(View.INVISIBLE);
                product_spice.setVisibility(View.INVISIBLE);
                product_oatmeal.setVisibility(View.VISIBLE);
            }
        });
        shop1_detail1=(Button) v.findViewById(R.id.shop1_datail1);
        shop1_detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_datail2=(Button) v.findViewById(R.id.shop1_datail2);
        shop1_datail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_datail3=(Button) v.findViewById(R.id.shop1_datail3);
        shop1_datail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_datail4=(Button) v.findViewById(R.id.shop1_datail4);
        shop1_datail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_detail.class
                );

                startActivity(intent);
            }
        });

        return v;
    }
}