package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wonderv2.R;

public class AR_select_aromatica extends AppCompatActivity implements View.OnClickListener {

    LinearLayout aro_layout;
    Button aro_body;
    Button aro_face;
    ImageView aro_body_bg;
    ImageView aro_face_bg;
    LinearLayout aro_body_items;
    LinearLayout aro_face_items;

    Button aro_body_shampoo;
    Button aro_body_conditioner;
    Button aro_face_tonor;
    Button aro_face_cream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_aromatica);

        aro_layout = findViewById(R.id.aro_layout);

        //카테고리 버튼
        aro_body = findViewById(R.id.aro_body);
        aro_body.setOnClickListener(this);
        aro_face = findViewById(R.id.aro_face);
        aro_face.setOnClickListener(this);
        //카테고리 배경 이미지
        aro_body_bg = findViewById(R.id.aro_body_bg);
        aro_face_bg = findViewById(R.id.aro_face_bg);
        //상품 카테고리 목록
        aro_body_items = findViewById(R.id.aro_body_items);
        aro_face_items = findViewById(R.id.aro_face_items);

        aro_body_shampoo = findViewById(R.id.aro_body_shampoo);
        aro_body_shampoo.setOnClickListener(this);
        aro_body_conditioner = findViewById(R.id.aro_body_conditioner);
        aro_body_conditioner.setOnClickListener(this);
        aro_face_tonor = findViewById(R.id.aro_face_tonor);
        aro_face_tonor.setOnClickListener(this);
        aro_face_cream = findViewById(R.id.aro_face_cream);
        aro_face_cream.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aro_body:
                aro_body_bg.setVisibility(View.VISIBLE);
                aro_face_bg.setVisibility(View.INVISIBLE);

                aro_body_items.setVisibility(View.VISIBLE);
                aro_face_items.setVisibility(View.INVISIBLE);

                aro_body.setTextColor(Color.parseColor("#EB6446"));
                aro_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.aro_face:
                aro_body_bg.setVisibility(View.INVISIBLE);
                aro_face_bg.setVisibility(View.VISIBLE);

                aro_body_items.setVisibility(View.INVISIBLE);
                aro_face_items.setVisibility(View.VISIBLE);

                aro_body.setTextColor(Color.parseColor("#505050"));
                aro_face.setTextColor(Color.parseColor("#EB6446"));
                break;
        }

        switch (v.getId()){
            case R.id.aro_body_shampoo:
                aro_body_shampoo.setTextColor(Color.parseColor("#EB6446"));
                aro_body_conditioner.setTextColor(Color.parseColor("#505050"));

                break;

            case R.id.aro_body_conditioner:
                aro_body_shampoo.setTextColor(Color.parseColor("#505050"));
                aro_body_conditioner.setTextColor(Color.parseColor("#EB6446"));

                break;

            case R.id.aro_face_tonor:
                aro_face_tonor.setTextColor(Color.parseColor("#EB6446"));
                aro_face_cream.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.aro_face_cream:
                aro_face_tonor.setTextColor(Color.parseColor("#505050"));
                aro_face_cream.setTextColor(Color.parseColor("#EB6446"));

                break;


        }

    }
}