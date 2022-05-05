package com.example.wonderv2.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.example.wonderv2.Setting.Setting_alarm;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_shop_finder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_shop_finder extends Fragment {
    MainActivity activity;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_shop_finder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_shop_finder.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_shop_finder newInstance(String param1, String param2) {
        Home_shop_finder fragment = new Home_shop_finder();
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

    public void onAttach(Context context){
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    public void onDetach(){
        super.onDetach();
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.home_shop_finder, container, false);

        //홈으로 다시 뒤로가기 버튼
        ImageButton back_btn = v.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity.setFrag(0);
            }
        });

        Button earth_btn=v.findViewById(R.id.earth_btn);
        earth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_earth_detail.class
                );

                startActivity(intent);
            }
        });
        Button almaeng_btn=v.findViewById(R.id.almaeng_btn);
        almaeng_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_almaeng_detail.class
                );

                startActivity(intent);
            }
        });
        Button chaeum_btn=v.findViewById(R.id.chaeum_btn);
        chaeum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_chaeum_detail.class
                );

                startActivity(intent);
            }
        });
        Button aromatica_btn=v.findViewById(R.id.aromatica_btn);
        aromatica_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Home_shop_aromatica_detail.class
                );

                startActivity(intent);
            }
        });
        ImageButton alarm_btn=v.findViewById(R.id.alarm_btn);
        alarm_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Setting_alarm.class
                );

                startActivity(intent);
            }
        });


        return v;

    }
}