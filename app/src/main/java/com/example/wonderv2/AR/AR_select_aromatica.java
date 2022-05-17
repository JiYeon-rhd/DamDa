package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

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

    LinearLayout spinner_aro_shampoo_layout;
    LinearLayout spinner_aro_conditioner_layout;
    LinearLayout spinner_aro_tonor_layout;
    LinearLayout spinner_aro_cream_layout;

    Spinner spinner_aro_shampoo_item;
    Spinner spinner_aro_conditioner_item;
    Spinner spinner_aro_tonor_item;
    Spinner spinner_aro_cream_item;


    //그램 스피너
    LinearLayout layout_aro_400g;
    Spinner spinner_aro_400g;
    LinearLayout layout_aro_50g;
    Spinner spinner_aro_50g;

    Button complete_btn_aro;

    String bottle_name;
    String shop_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_aromatica);

        //용기이름, 상점 이름 받아서 넘기기
        Intent intent = getIntent();
        bottle_name = intent.getStringExtra("용기이름");
        shop_name = intent.getStringExtra("상점이름");

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


        //스피너 레이아웃
        spinner_aro_shampoo_layout = findViewById(R.id.spinner_aro_shampoo_layout);
        spinner_aro_conditioner_layout = findViewById(R.id.spinner_aro_conditioner_layout);
        spinner_aro_tonor_layout = findViewById(R.id.spinner_aro_tonor_layout);
        spinner_aro_cream_layout = findViewById(R.id.spinner_aro_cream_layout);

        layout_aro_400g=findViewById(R.id.layout_aro_400g);
        spinner_aro_400g = (Spinner)findViewById(R.id.spinner_aro_400g);
        layout_aro_50g = findViewById(R.id.layout_aro_50g);
        spinner_aro_50g = (Spinner)findViewById(R.id.spinner_aro_50g);


        //샴푸 스피너
        spinner_aro_shampoo_item = (Spinner) findViewById(R.id.spinner_aro_shampoo_item);
        ArrayAdapter itemAdapter_shampoo= ArrayAdapter.createFromResource(this,
                R.array.spinner_shampoo, android.R.layout.simple_spinner_dropdown_item);
        spinner_aro_shampoo_item.setAdapter(itemAdapter_shampoo);
        spinner_aro_shampoo_item.setSelected(false);
        spinner_aro_shampoo_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_aro_shampoo_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramAro();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //컨디셔너 스피너
        spinner_aro_conditioner_item = (Spinner) findViewById(R.id.spinner_aro_conditioner_item);
        ArrayAdapter itemAdapter_conditioner= ArrayAdapter.createFromResource(this,
                R.array.spinner_conditioner, android.R.layout.simple_spinner_dropdown_item);
        spinner_aro_conditioner_item.setAdapter(itemAdapter_conditioner);
        spinner_aro_conditioner_item.setSelected(false);
        spinner_aro_conditioner_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_aro_conditioner_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramAro();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //토너 스피너
        spinner_aro_tonor_item = (Spinner) findViewById(R.id.spinner_aro_tonor_item);
        ArrayAdapter itemAdapter_toner= ArrayAdapter.createFromResource(this,
                R.array.spinner_tonor, android.R.layout.simple_spinner_dropdown_item);
        spinner_aro_tonor_item.setAdapter(itemAdapter_toner);
        spinner_aro_tonor_item.setSelected(false);
        spinner_aro_tonor_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_aro_tonor_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramAro();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //크림 스피너
        spinner_aro_cream_item = (Spinner) findViewById(R.id.spinner_aro_cream_item);
        ArrayAdapter itemAdapter_cream= ArrayAdapter.createFromResource(this,
                R.array.spinner_cream, android.R.layout.simple_spinner_dropdown_item);
        spinner_aro_cream_item.setAdapter(itemAdapter_cream);
        spinner_aro_cream_item.setSelected(false);
        spinner_aro_cream_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_aro_cream_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramAro();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //완료버튼
        complete_btn_aro =findViewById(R.id.item_select_complete_aro);

        //400그램 스피너
        spinner_aro_400g = (Spinner) findViewById(R.id.spinner_aro_400g);
        ArrayAdapter itemAdapter_gram= ArrayAdapter.createFromResource(this,
                R.array.spinner_400g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_aro_400g.setAdapter(itemAdapter_gram);
        spinner_aro_400g.setSelected(false);
        spinner_aro_400g.post(new Runnable() {
            @Override
            public void run() {
                spinner_aro_400g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        complete_btn_aro.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //50그램 스피너
        spinner_aro_50g = (Spinner) findViewById(R.id.spinner_aro_50g);
        ArrayAdapter itemAdapter_gram_400= ArrayAdapter.createFromResource(this,
                R.array.spinner_50g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_aro_50g.setAdapter(itemAdapter_gram_400);
        spinner_aro_50g.setSelected(false);
        spinner_aro_50g.post(new Runnable() {
            @Override
            public void run() {
                spinner_aro_50g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        complete_btn_aro.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });


        complete_btn_aro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR_select_aromatica.this, AR_complete.class);

                intent.putExtra("상점이름", shop_name);
                intent.putExtra("용기이름", bottle_name);

                intent.putExtra("아로마 샴푸", spinner_aro_shampoo_item.getSelectedItem().toString());
                intent.putExtra("아로마 컨디셔너", spinner_aro_conditioner_item.getSelectedItem().toString());
                intent.putExtra("아로마 토너", spinner_aro_tonor_item.getSelectedItem().toString());
                intent.putExtra("아로마 크림", spinner_aro_cream_item.getSelectedItem().toString());
                intent.putExtra("아로마 선택한 그램 400", spinner_aro_400g.getSelectedItem().toString());
                intent.putExtra("아로마 선택한 그램 50", spinner_aro_50g.getSelectedItem().toString());

                startActivity(intent);
            }
        });





    }
    //"알맹상점 에코 PET L", "알맹상점 디스펜서 M", "알맹상점 에코 PET S","아로마티카 PET L", "아로마티카 PET S", "채움소 BIO PET L", "자구샵 PCR L"

    public void setGramAro(){
        if(bottle_name.equals("아로마티카 PET L")){//400까지
            layout_aro_400g.setVisibility(View.VISIBLE);
            layout_aro_50g.setVisibility(View.INVISIBLE);
        }
        else if(bottle_name.equals("아로마티카 PET S")){
            layout_aro_400g.setVisibility(View.INVISIBLE);
            layout_aro_50g.setVisibility(View.VISIBLE);
        }
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

                spinner_aro_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_aro_cream_layout.setVisibility(View.INVISIBLE);
                spinner_aro_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_layout.setVisibility(View.INVISIBLE);
                layout_aro_400g.setVisibility(View.INVISIBLE);
                layout_aro_50g.setVisibility(View.INVISIBLE);
                complete_btn_aro.setVisibility(View.INVISIBLE);
                break;

            case R.id.aro_face:
                aro_body_bg.setVisibility(View.INVISIBLE);
                aro_face_bg.setVisibility(View.VISIBLE);

                aro_body_items.setVisibility(View.INVISIBLE);
                aro_face_items.setVisibility(View.VISIBLE);

                aro_body.setTextColor(Color.parseColor("#505050"));
                aro_face.setTextColor(Color.parseColor("#EB6446"));

                spinner_aro_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_aro_cream_layout.setVisibility(View.INVISIBLE);
                spinner_aro_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_layout.setVisibility(View.INVISIBLE);
                layout_aro_400g.setVisibility(View.INVISIBLE);
                layout_aro_50g.setVisibility(View.INVISIBLE);
                complete_btn_aro.setVisibility(View.INVISIBLE);
                break;
        }

        switch (v.getId()){
            case R.id.aro_body_shampoo:
                aro_body_shampoo.setTextColor(Color.parseColor("#EB6446"));
                aro_body_conditioner.setTextColor(Color.parseColor("#505050"));
                aro_face_tonor.setTextColor(Color.parseColor("#505050"));
                aro_face_cream.setTextColor(Color.parseColor("#505050"));

                spinner_aro_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_aro_cream_layout.setVisibility(View.INVISIBLE);
                spinner_aro_shampoo_layout.setVisibility(View.VISIBLE);
                spinner_aro_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_item.setSelection(0);
                spinner_aro_shampoo_item.setSelection(0);
                spinner_aro_tonor_item.setSelection(0);
                spinner_aro_cream_item.setSelection(0);
                spinner_aro_400g.setSelection(0);
                spinner_aro_50g.setSelection(0);

                layout_aro_400g.setVisibility(View.INVISIBLE);
                layout_aro_50g.setVisibility(View.INVISIBLE);
                complete_btn_aro.setVisibility(View.INVISIBLE);

                break;

            case R.id.aro_body_conditioner:
                aro_body_shampoo.setTextColor(Color.parseColor("#505050"));
                aro_body_conditioner.setTextColor(Color.parseColor("#EB6446"));
                aro_face_tonor.setTextColor(Color.parseColor("#505050"));
                aro_face_cream.setTextColor(Color.parseColor("#505050"));

                spinner_aro_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_aro_cream_layout.setVisibility(View.INVISIBLE);
                spinner_aro_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_layout.setVisibility(View.VISIBLE);
                spinner_aro_conditioner_item.setSelection(0);
                spinner_aro_shampoo_item.setSelection(0);
                spinner_aro_tonor_item.setSelection(0);
                spinner_aro_cream_item.setSelection(0);
                spinner_aro_400g.setSelection(0);
                spinner_aro_50g.setSelection(0);

                layout_aro_400g.setVisibility(View.INVISIBLE);
                layout_aro_50g.setVisibility(View.INVISIBLE);
                complete_btn_aro.setVisibility(View.INVISIBLE);

                break;

            case R.id.aro_face_tonor:
                aro_face_tonor.setTextColor(Color.parseColor("#EB6446"));
                aro_face_cream.setTextColor(Color.parseColor("#505050"));
                aro_body_shampoo.setTextColor(Color.parseColor("#505050"));
                aro_body_conditioner.setTextColor(Color.parseColor("#505050"));

                spinner_aro_tonor_layout.setVisibility(View.VISIBLE);
                spinner_aro_cream_layout.setVisibility(View.INVISIBLE);
                spinner_aro_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_item.setSelection(0);
                spinner_aro_shampoo_item.setSelection(0);
                spinner_aro_tonor_item.setSelection(0);
                spinner_aro_cream_item.setSelection(0);
                spinner_aro_400g.setSelection(0);
                spinner_aro_50g.setSelection(0);

                layout_aro_400g.setVisibility(View.INVISIBLE);
                layout_aro_50g.setVisibility(View.INVISIBLE);
                complete_btn_aro.setVisibility(View.INVISIBLE);
                break;

            case R.id.aro_face_cream:
                aro_face_tonor.setTextColor(Color.parseColor("#505050"));
                aro_face_cream.setTextColor(Color.parseColor("#EB6446"));
                aro_body_shampoo.setTextColor(Color.parseColor("#505050"));
                aro_body_conditioner.setTextColor(Color.parseColor("#505050"));


                spinner_aro_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_aro_cream_layout.setVisibility(View.VISIBLE);
                spinner_aro_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_aro_conditioner_item.setSelection(0);
                spinner_aro_shampoo_item.setSelection(0);
                spinner_aro_tonor_item.setSelection(0);
                spinner_aro_cream_item.setSelection(0);
                spinner_aro_400g.setSelection(0);
                spinner_aro_50g.setSelection(0);

                layout_aro_400g.setVisibility(View.INVISIBLE);
                layout_aro_50g.setVisibility(View.INVISIBLE);
                complete_btn_aro.setVisibility(View.INVISIBLE);

                break;


        }

    }
}