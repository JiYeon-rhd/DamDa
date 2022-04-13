package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.wonderv2.R;

public class AR_select_item extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner_g;
    Spinner spinner_item;

    Button item_select_complete_btn;

    Button ar_shop_1;//지구샵 버튼
    Button ar_shop_2;//알맹상점 버튼
    Button ar_shop_3;//아로마티카 버튼

    Button item_face; //페이스
    Button item_body; //바디
    Button item_cleanser; //세제

    LinearLayout item_face_items; //페이스 카테고리
    LinearLayout item_body_items; //바디 카테고리
    LinearLayout item_cleanser_items; //세제 카테고리
    LinearLayout item_select_layout; //제품 선택 전체 레이아웃

    //바디 카테고리 상품들
    Button body_shanpoo;
    Button body_bodywash;
    Button body_hairessence;
    Button body_conditioner;
    Button body_allinone;
    Button body_handwash;

    //용기에 담을 제품 리니어
    LinearLayout item_name;
    //담고싶은 그램수 리니어
    LinearLayout item_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_item);


        //용기에 담을 제품 선택 스피너
        spinner_item = (Spinner) findViewById(R.id.spinner_item);
        ArrayAdapter itemAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_item.setAdapter(itemAdapter);

        //담고 싶은 g 선택 스피너
        spinner_g = (Spinner) findViewById(R.id.spinner_g);
        ArrayAdapter gAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_g.setAdapter(gAdapter);


        //확인 버튼
        item_select_complete_btn = (Button) findViewById(R.id.item_select_complete);
        item_select_complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //용기 스캔 카메라 로 인텐
                Intent intent = new Intent(getApplicationContext(), AR_camera.class);
                startActivity(intent);
            }
        });


        ar_shop_1 = (Button) findViewById(R.id.ar_shop_1);
        ar_shop_1.setOnClickListener(this);
        ar_shop_2 = (Button) findViewById(R.id.ar_shop_2);
        ar_shop_2.setOnClickListener(this);
        ar_shop_3 = (Button) findViewById(R.id.ar_shop_3);
        ar_shop_3.setOnClickListener(this);

        item_face = (Button) findViewById(R.id.item_face);
        item_face.setOnClickListener(this);
        item_body = (Button) findViewById(R.id.item_body);
        item_body.setOnClickListener(this);
        item_cleanser = (Button) findViewById(R.id.item_cleanser);
        item_cleanser.setOnClickListener(this);


        item_select_layout = (LinearLayout) findViewById(R.id.item_select_layout);
        item_body_items = (LinearLayout) findViewById(R.id.item_body_items);
        item_face_items = (LinearLayout) findViewById(R.id.item_face_items);
        item_cleanser_items = (LinearLayout) findViewById(R.id.item_cleanser_items);


        //바디 상품 카테고리
        body_shanpoo = (Button) findViewById(R.id.body_shanpoo);
        body_shanpoo.setOnClickListener(this);
        body_bodywash = (Button) findViewById(R.id.body_bodywash);
        body_bodywash.setOnClickListener(this);
        body_hairessence = (Button) findViewById(R.id.body_hairessence);
        body_hairessence.setOnClickListener(this);
        body_conditioner = (Button) findViewById(R.id.body_conditioner);
        body_conditioner.setOnClickListener(this);
        body_allinone = (Button) findViewById(R.id.body_allinone);
        body_allinone.setOnClickListener(this);
        body_handwash = (Button) findViewById(R.id.body_handwash);
        body_handwash.setOnClickListener(this);

        item_name = (LinearLayout) findViewById(R.id.item_name);
        item_g = (LinearLayout) findViewById(R.id.item_g);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ar_shop_1: //지구샵을 눌렀을 경우
                ar_shop_1.setSelected(true);
                ar_shop_2.setSelected(false);
                ar_shop_3.setSelected(false);
                item_select_layout.setVisibility(View.VISIBLE);
                break;
            case R.id.ar_shop_2:  //알맹상점을 눌렀을 경우
                ar_shop_1.setSelected(false);
                ar_shop_2.setSelected(true);
                ar_shop_3.setSelected(false);
                item_select_layout.setVisibility(View.VISIBLE);
                break;
            case R.id.ar_shop_3: //아로마티카를 눌렀을 경우
                ar_shop_1.setSelected(false);
                ar_shop_2.setSelected(false);
                ar_shop_3.setSelected(true);
                item_select_layout.setVisibility(View.VISIBLE);
                break;
        }


        //페이스, 세제, 바디를 눌렀을 경우
        switch (v.getId()){
            case R.id.item_face:
                item_face.setSelected(true);
                item_body.setSelected(false);
                item_cleanser.setSelected(false);


                item_face_items.setVisibility(View.VISIBLE);
                item_body_items.setVisibility(View.INVISIBLE);
                item_cleanser_items.setVisibility(View.INVISIBLE);
                break;

            case R.id.item_body:
                item_face.setSelected(false);
                item_body.setSelected(true);
                item_cleanser.setSelected(false);

                item_face_items.setVisibility(View.INVISIBLE);
                item_body_items.setVisibility(View.VISIBLE);
                item_cleanser_items.setVisibility(View.VISIBLE);
                break;

            case R.id.item_cleanser:
                item_face.setSelected(false);
                item_body.setSelected(false);
                item_cleanser.setSelected(true);

                item_face_items.setVisibility(View.INVISIBLE);
                item_body_items.setVisibility(View.INVISIBLE);
                item_cleanser_items.setVisibility(View.VISIBLE);
                break;

        }
        //바디의 카테고리를 눌렀을 경우
        switch (v.getId()){
            case R.id.body_shanpoo:
                body_shanpoo.setSelected(true);
                body_bodywash.setSelected(false);
                body_hairessence.setSelected(false);
                body_conditioner.setSelected(false);
                body_allinone.setSelected(false);
                body_handwash.setSelected(false);

                item_name.setVisibility(View.VISIBLE);
                item_g.setVisibility(View.VISIBLE);
                item_select_complete_btn.setVisibility(View.VISIBLE);

                break;
            case R.id.body_bodywash:
                body_shanpoo.setSelected(false);
                body_bodywash.setSelected(true);
                body_hairessence.setSelected(false);
                body_conditioner.setSelected(false);
                body_allinone.setSelected(false);
                body_handwash.setSelected(false);

                item_name.setVisibility(View.VISIBLE);
                item_g.setVisibility(View.VISIBLE);
                item_select_complete_btn.setVisibility(View.VISIBLE);
                break;
            case R.id.body_hairessence:
                body_shanpoo.setSelected(false);
                body_bodywash.setSelected(false);
                body_hairessence.setSelected(true);
                body_conditioner.setSelected(false);
                body_allinone.setSelected(false);
                body_handwash.setSelected(false);

                item_name.setVisibility(View.VISIBLE);
                item_g.setVisibility(View.VISIBLE);
                item_select_complete_btn.setVisibility(View.VISIBLE);
                break;
            case R.id.body_conditioner:
                body_shanpoo.setSelected(false);
                body_bodywash.setSelected(false);
                body_hairessence.setSelected(false);
                body_conditioner.setSelected(true);
                body_allinone.setSelected(false);
                body_handwash.setSelected(false);

                item_name.setVisibility(View.VISIBLE);
                item_g.setVisibility(View.VISIBLE);
                item_select_complete_btn.setVisibility(View.VISIBLE);
                break;
            case R.id.body_allinone:
                body_shanpoo.setSelected(false);
                body_bodywash.setSelected(false);
                body_hairessence.setSelected(false);
                body_conditioner.setSelected(false);
                body_allinone.setSelected(true);
                body_handwash.setSelected(false);

                item_name.setVisibility(View.VISIBLE);
                item_g.setVisibility(View.VISIBLE);
                item_select_complete_btn.setVisibility(View.VISIBLE);
                break;
            case R.id.body_handwash:
                body_shanpoo.setSelected(false);
                body_bodywash.setSelected(false);
                body_hairessence.setSelected(false);
                body_conditioner.setSelected(false);
                body_allinone.setSelected(false);
                body_handwash.setSelected(true);

                item_name.setVisibility(View.VISIBLE);
                item_g.setVisibility(View.VISIBLE);
                item_select_complete_btn.setVisibility(View.VISIBLE);
                break;
        }



    }
}