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
 * Use the {@link Product_wash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_wash extends Fragment {
    MainActivity activity;

    Button detergent_btn;
    Button softer_btn;
    Button kitchen_btn;
    Button shop1_detail1;
    Button shop1_detail2;
    Button shop1_datail3;

    LinearLayout product_detergent;
    LinearLayout product_softer;
    LinearLayout product_kitchen;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Product_wash() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Product_wash.
     */
    // TODO: Rename and change types and number of parameters
    public static Product_wash newInstance(String param1, String param2) {
        Product_wash fragment = new Product_wash();
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
        View v= inflater.inflate(R.layout.product_wash, container, false);

        product_detergent=(LinearLayout) v.findViewById(R.id.product_detergent);
        product_softer=(LinearLayout) v.findViewById(R.id.product_softer);
        product_kitchen=(LinearLayout) v.findViewById(R.id.product_kitchen);

        detergent_btn=(Button) v.findViewById(R.id.detergent_btn);
        detergent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_detergent.setVisibility(View.VISIBLE);
                product_softer.setVisibility(View.INVISIBLE);
                product_kitchen.setVisibility(View.INVISIBLE);
            }
        });
        softer_btn=(Button) v.findViewById(R.id.softer_btn);
        softer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_detergent.setVisibility(View.INVISIBLE);
                product_softer.setVisibility(View.VISIBLE);
                product_kitchen.setVisibility(View.INVISIBLE);
            }
        });
        kitchen_btn=(Button) v.findViewById(R.id.kitchen_btn);
        kitchen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_detergent.setVisibility(View.INVISIBLE);
                product_softer.setVisibility(View.INVISIBLE);
                product_kitchen.setVisibility(View.VISIBLE);
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
        shop1_detail2=(Button) v.findViewById(R.id.shop1_datail2);
        shop1_detail2.setOnClickListener(new View.OnClickListener() {
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

        return v;
    }
}