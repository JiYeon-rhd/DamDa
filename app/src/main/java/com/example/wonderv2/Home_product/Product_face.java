package com.example.wonderv2.Home_product;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.wonderv2.Home.Home_shop_almaeng_detail;
import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Product_face#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_face extends Fragment {
    MainActivity activity;

    Button toner_btn;
    Button cream_btn;
    Button cleanser_btn;
    Button suncream_btn;
    Button gel_btn;
    Button oil_btn;
    Button shop1_detail1;
    Button shop1_detail2;
    Button shop1_detail3;
    Button shop1_detail4;
    Button shop1_detail5;


    LinearLayout product_toner;
    LinearLayout product_cream;
    LinearLayout product_cleanser;
    LinearLayout product_suncream;
    LinearLayout product_gel;
    LinearLayout product_oil;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Product_face() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Product_face.
     */
    // TODO: Rename and change types and number of parameters
    public static Product_face newInstance(String param1, String param2) {
        Product_face fragment = new Product_face();
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
        View v=inflater.inflate(R.layout.product_face, container, false);

        product_toner=(LinearLayout) v.findViewById(R.id.product_toner);
        product_cream=(LinearLayout) v.findViewById(R.id.product_cream);
        product_cleanser=(LinearLayout) v.findViewById(R.id.product_cleanser);
        product_suncream=(LinearLayout) v.findViewById(R.id.product_suncream);
        product_gel=(LinearLayout) v.findViewById(R.id.product_gel);
        product_oil=(LinearLayout) v.findViewById(R.id.product_oil);

        toner_btn=(Button) v.findViewById(R.id.toner_btn);
        toner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toner_btn.setTextColor(Color.RED);
                cream_btn.setTextColor(Color.BLACK);
                cleanser_btn.setTextColor(Color.BLACK);
                suncream_btn.setTextColor(Color.BLACK);
                gel_btn.setTextColor(Color.BLACK);
                oil_btn.setTextColor(Color.BLACK);

                product_toner.setVisibility(View.VISIBLE);
                product_cream.setVisibility(View.INVISIBLE);
                product_cleanser.setVisibility(View.INVISIBLE);
                product_suncream.setVisibility(View.INVISIBLE);
                product_gel.setVisibility(View.INVISIBLE);
                product_oil.setVisibility(View.INVISIBLE);
            }
        });
        cream_btn=(Button) v.findViewById(R.id.cream_btn);
        cream_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toner_btn.setTextColor(Color.BLACK);
                cream_btn.setTextColor(Color.RED);
                cleanser_btn.setTextColor(Color.BLACK);
                suncream_btn.setTextColor(Color.BLACK);
                gel_btn.setTextColor(Color.BLACK);
                oil_btn.setTextColor(Color.BLACK);

                product_toner.setVisibility(View.INVISIBLE);
                product_cream.setVisibility(View.VISIBLE);
                product_cleanser.setVisibility(View.INVISIBLE);
                product_suncream.setVisibility(View.INVISIBLE);
                product_gel.setVisibility(View.INVISIBLE);
                product_oil.setVisibility(View.INVISIBLE);
            }
        });
        cleanser_btn=(Button) v.findViewById(R.id.cleanser_btn);
        cleanser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toner_btn.setTextColor(Color.BLACK);
                cream_btn.setTextColor(Color.BLACK);
                cleanser_btn.setTextColor(Color.RED);
                suncream_btn.setTextColor(Color.BLACK);
                gel_btn.setTextColor(Color.BLACK);
                oil_btn.setTextColor(Color.BLACK);

                product_toner.setVisibility(View.INVISIBLE);
                product_cream.setVisibility(View.INVISIBLE);
                product_cleanser.setVisibility(View.VISIBLE);
                product_suncream.setVisibility(View.INVISIBLE);
                product_gel.setVisibility(View.INVISIBLE);
                product_oil.setVisibility(View.INVISIBLE);
            }
        });
        suncream_btn=(Button) v.findViewById(R.id.suncream_btn);
        suncream_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toner_btn.setTextColor(Color.BLACK);
                cream_btn.setTextColor(Color.BLACK);
                cleanser_btn.setTextColor(Color.BLACK);
                suncream_btn.setTextColor(Color.RED);
                gel_btn.setTextColor(Color.BLACK);
                oil_btn.setTextColor(Color.BLACK);

                product_toner.setVisibility(View.INVISIBLE);
                product_cream.setVisibility(View.INVISIBLE);
                product_cleanser.setVisibility(View.INVISIBLE);
                product_suncream.setVisibility(View.VISIBLE);
                product_gel.setVisibility(View.INVISIBLE);
                product_oil.setVisibility(View.INVISIBLE);
            }
        });
        gel_btn=(Button) v.findViewById(R.id.gel_btn);
        gel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toner_btn.setTextColor(Color.BLACK);
                cream_btn.setTextColor(Color.BLACK);
                cleanser_btn.setTextColor(Color.BLACK);
                suncream_btn.setTextColor(Color.BLACK);
                gel_btn.setTextColor(Color.RED);
                oil_btn.setTextColor(Color.BLACK);

                product_toner.setVisibility(View.INVISIBLE);
                product_cream.setVisibility(View.INVISIBLE);
                product_cleanser.setVisibility(View.INVISIBLE);
                product_suncream.setVisibility(View.INVISIBLE);
                product_gel.setVisibility(View.VISIBLE);
                product_oil.setVisibility(View.INVISIBLE);
            }
        });
        oil_btn=(Button) v.findViewById(R.id.oil_btn);
        oil_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toner_btn.setTextColor(Color.BLACK);
                cream_btn.setTextColor(Color.BLACK);
                cleanser_btn.setTextColor(Color.BLACK);
                suncream_btn.setTextColor(Color.BLACK);
                gel_btn.setTextColor(Color.BLACK);
                oil_btn.setTextColor(Color.RED);
                
                product_toner.setVisibility(View.INVISIBLE);
                product_cream.setVisibility(View.INVISIBLE);
                product_cleanser.setVisibility(View.INVISIBLE);
                product_suncream.setVisibility(View.INVISIBLE);
                product_gel.setVisibility(View.INVISIBLE);
                product_oil.setVisibility(View.VISIBLE);
            }
        });
        shop1_detail1=(Button) v.findViewById(R.id.shop1_datail1);
        shop1_detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_almaeng_detail.class
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
                        Home_shop_almaeng_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_detail3=(Button) v.findViewById(R.id.shop1_datail3);
        shop1_detail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_almaeng_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_detail4=(Button) v.findViewById(R.id.shop1_datail4);
        shop1_detail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_almaeng_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_detail5=(Button) v.findViewById(R.id.shop1_datail5);
        shop1_detail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_almaeng_detail.class
                );

                startActivity(intent);
            }
        });

        return v;
    }
}