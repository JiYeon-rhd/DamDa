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
 * Use the {@link Product_body#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_body extends Fragment {
    MainActivity activity;

    Button shampoo_btn;
    Button bodywash_btn;
    Button hairessence_btn;
    Button conditioning_btn;
    Button allinone_btn;
    Button handwash_btn;
    Button shop1_datail1;
    Button shop1_datail2;
    Button shop1_datail3;
    Button shop1_datail5;
    Button shop1_datail6;

    LinearLayout product_shampoo;
    LinearLayout product_bodywash;
    LinearLayout product_hariessence;
    LinearLayout product_conditioning;
    LinearLayout product_allinone;
    LinearLayout product_handwash;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Product_body() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Product_body.
     */
    // TODO: Rename and change types and number of parameters
    public static Product_body newInstance(String param1, String param2) {
        Product_body fragment = new Product_body();
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
        View v= inflater.inflate(R.layout.product_body, container, false);

        product_shampoo=(LinearLayout) v.findViewById(R.id.product_shampoo);
        product_bodywash=(LinearLayout) v.findViewById(R.id.product_bodywash);
        product_hariessence=(LinearLayout) v.findViewById(R.id.product_hairessence);
        product_conditioning=(LinearLayout) v.findViewById(R.id.product_hairconditioning);
        product_allinone=(LinearLayout) v.findViewById(R.id.product_allinone);
        product_handwash=(LinearLayout) v.findViewById(R.id.product_handwash);

        shampoo_btn=(Button) v.findViewById(R.id.shampoo_btn);
        shampoo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_shampoo.setVisibility(View.VISIBLE);
                product_bodywash.setVisibility(View.INVISIBLE);
                product_hariessence.setVisibility(View.INVISIBLE);
                product_conditioning.setVisibility(View.INVISIBLE);
                product_allinone.setVisibility(View.INVISIBLE);
                product_handwash.setVisibility(View.INVISIBLE);
            }
        });
        bodywash_btn=(Button) v.findViewById(R.id.bodywash_btn);
        bodywash_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_shampoo.setVisibility(View.INVISIBLE);
                product_bodywash.setVisibility(View.VISIBLE);
                product_hariessence.setVisibility(View.INVISIBLE);
                product_conditioning.setVisibility(View.INVISIBLE);
                product_allinone.setVisibility(View.INVISIBLE);
                product_handwash.setVisibility(View.INVISIBLE);
            }
        });
        hairessence_btn=(Button) v.findViewById(R.id.hairessence_btn);
        hairessence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_shampoo.setVisibility(View.INVISIBLE);
                product_bodywash.setVisibility(View.INVISIBLE);
                product_hariessence.setVisibility(View.VISIBLE);
                product_conditioning.setVisibility(View.INVISIBLE);
                product_allinone.setVisibility(View.INVISIBLE);
                product_handwash.setVisibility(View.INVISIBLE);
            }
        });
        conditioning_btn=(Button) v.findViewById(R.id.hairconditioning_btn);
        conditioning_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_shampoo.setVisibility(View.INVISIBLE);
                product_bodywash.setVisibility(View.INVISIBLE);
                product_hariessence.setVisibility(View.INVISIBLE);
                product_conditioning.setVisibility(View.VISIBLE);
                product_allinone.setVisibility(View.INVISIBLE);
                product_handwash.setVisibility(View.INVISIBLE);
            }
        });
        allinone_btn=(Button) v.findViewById(R.id.allinone_btn);
        allinone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_shampoo.setVisibility(View.INVISIBLE);
                product_bodywash.setVisibility(View.INVISIBLE);
                product_hariessence.setVisibility(View.INVISIBLE);
                product_conditioning.setVisibility(View.INVISIBLE);
                product_allinone.setVisibility(View.VISIBLE);
                product_handwash.setVisibility(View.INVISIBLE);
            }
        });
        handwash_btn=(Button) v.findViewById(R.id.handwash_btn);
        handwash_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_shampoo.setVisibility(View.INVISIBLE);
                product_bodywash.setVisibility(View.INVISIBLE);
                product_hariessence.setVisibility(View.INVISIBLE);
                product_conditioning.setVisibility(View.INVISIBLE);
                product_allinone.setVisibility(View.INVISIBLE);
                product_handwash.setVisibility(View.VISIBLE);
            }
        });
        shop1_datail1=(Button) v.findViewById(R.id.shop1_datail1);
        shop1_datail1.setOnClickListener(new View.OnClickListener() {
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
        shop1_datail5=(Button) v.findViewById(R.id.shop1_datail5);
        shop1_datail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_detail.class
                );

                startActivity(intent);
            }
        });
        shop1_datail6=(Button) v.findViewById(R.id.shop1_datail6);
        shop1_datail6.setOnClickListener(new View.OnClickListener() {
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