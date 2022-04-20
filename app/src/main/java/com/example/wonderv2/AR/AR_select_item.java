package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.nfc.cardemulation.OffHostApduService;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.wonderv2.R;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

public class AR_select_item extends AppCompatActivity implements View.OnClickListener {
    Button item_select_complete_btn;

    Button ar_shop_1;//알맹상점 버튼
    Button ar_shop_2;//지구샵 버튼
    Button ar_shop_3;//채움소 버튼
    Button ar_shop_4; //아로마티카

    //알맹상점
    LinearLayout almaeng_layout; //제품 선택 전체 레이아웃 알맹상점
    Button almaeng_food; // 카테고리
    Button almaeng_wash;
    Button almaeng_body;
    Button almaeng_face;
    ImageView almaeng_food_bg; //탭 이미지뷰
    ImageView almaeng_wash_bg;
    ImageView almaeng_body_bg;
    ImageView almaeng_face_bg;
    LinearLayout almaeng_food_items; //상품들
    LinearLayout almaeng_face_items;
    LinearLayout almaeng_body_items;
    LinearLayout almaeng_wash_items;


    Button almaeng_food_tea;  //푸드 카테고리 상품들
    Button almaeng_food_coffee;

    //지구샵
    LinearLayout earth_layout;
    Button earth_wash;
    ImageView earth_wash_bg;
    LinearLayout earth_wash_items;

    Button earth_wash_detergent; //세탁용 세
    Button earth_wash_scent; //섬유유연제

    LinearLayout spinner_earth_layout;



    //채움소
    LinearLayout chaeum_layout; //채움소 레이아웃
    Button chaeum_food;
    ImageView chaeum_food_bg;
    LinearLayout chaeum_food_items;

    Button chaeum_food_tea;
    Button chaeum_food_coffee;

    LinearLayout spinner_chaeum_tea_layout;
    LinearLayout spinner_chaeum_coffee_layout;


    Spinner spinner_earth_wash_detergent;
    Spinner spinner_chaeum_tea;
    Spinner spinner_chaeum_coffee;



    //용기에 담을 제품 리니어
    LinearLayout item_name;
    //담고싶은 그램수 리니어
    LinearLayout item_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_item);

        ar_shop_1 = (Button) findViewById(R.id.ar_shop_1);
        ar_shop_1.setOnClickListener(this);
        ar_shop_2 = (Button) findViewById(R.id.ar_shop_2);
        ar_shop_2.setOnClickListener(this);
        ar_shop_3 = (Button) findViewById(R.id.ar_shop_3);
        ar_shop_3.setOnClickListener(this);
        ar_shop_4 = (Button)findViewById(R.id.ar_shop_4);
        ar_shop_4.setOnClickListener(this);


        //알맹상점
        almaeng_layout = (LinearLayout) findViewById(R.id.almaeng_layout);

        almaeng_food = (Button)findViewById(R.id.almaeng_food);
        almaeng_food.setOnClickListener(this);
        almaeng_face = (Button) findViewById(R.id.almaeng_face);
        almaeng_face.setOnClickListener(this);
        almaeng_body = (Button) findViewById(R.id.almaeng_body);
        almaeng_body.setOnClickListener(this);
        almaeng_wash = (Button) findViewById(R.id.almaeng_wash);
        almaeng_wash.setOnClickListener(this);

        almaeng_food_bg = (ImageView)findViewById(R.id.almaeng_food_bg);
        almaeng_face_bg = (ImageView)findViewById(R.id.almaeng_face_bg);
        almaeng_wash_bg = (ImageView)findViewById(R.id.almaeng_wash_bg);
        almaeng_body_bg = (ImageView) findViewById(R.id.almaeng_body_bg);



        almaeng_food_items = (LinearLayout) findViewById(R.id.almaeng_food_items);
        almaeng_body_items = (LinearLayout) findViewById(R.id.almaeng_body_items);
        almaeng_face_items = (LinearLayout) findViewById(R.id.almaeng_face_items);
        almaeng_wash_items = (LinearLayout) findViewById(R.id.almaeng_wash_items);

        almaeng_food_tea = (Button)findViewById(R.id.almaeng_food_tea);  //알맹상점 푸드 상품 목록
        almaeng_food_tea.setOnClickListener(this);
        almaeng_food_coffee=(Button)findViewById(R.id.almaeng_food_coffee);
        almaeng_food_coffee.setOnClickListener(this);



        //지구샵
        earth_layout = (LinearLayout)findViewById(R.id.earth_layout);
        earth_wash_bg = (ImageView)findViewById(R.id.earth_wash_bg);
        earth_wash = (Button) findViewById(R.id.earth_wash);
        earth_wash.setOnClickListener(this);
        earth_wash_items=(LinearLayout)findViewById(R.id.earth_wash_items);

        earth_wash_detergent =(Button)findViewById(R.id.earth_wash_detergent);
        earth_wash_detergent.setOnClickListener(this);

        spinner_earth_layout = (LinearLayout)findViewById(R.id.spinner_earth);

        spinner_earth_wash_detergent = (Spinner) findViewById(R.id.spinner_earth_detergent);  //지구샵 세제 스피너
        ArrayAdapter itemAdapter_earth = ArrayAdapter.createFromResource(this,
                R.array.spinner_earth_wash_detergent_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_earth_wash_detergent.setAdapter(itemAdapter_earth);
        spinner_earth_wash_detergent.setSelected(false);
        spinner_earth_wash_detergent.post(new Runnable() {
            @Override
            public void run() {
                spinner_earth_wash_detergent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        item_g.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });




        //채움소
        chaeum_layout = (LinearLayout) findViewById(R.id.chaeum_layout);
        chaeum_food =(Button) findViewById(R.id.chaeum_food);
        chaeum_food.setOnClickListener(this);
        chaeum_food_bg=(ImageView) findViewById(R.id.chaeum_food_bg);
        chaeum_food_items=(LinearLayout) findViewById(R.id.chaeum_food_items);

        chaeum_food_tea=(Button)findViewById(R.id.chaeum_food_tea);
        chaeum_food_tea.setOnClickListener(this);
        chaeum_food_coffee=(Button)findViewById(R.id.chaeum_food_coffee);
        chaeum_food_coffee.setOnClickListener(this);

        spinner_chaeum_tea_layout = (LinearLayout)findViewById(R.id.spinner_chaeum_tea_layout);

        spinner_chaeum_tea = (Spinner) findViewById(R.id.spinner_chaeum_food_tea);
        ArrayAdapter itemAdapter_chaeum_tea = ArrayAdapter.createFromResource(this,
                R.array.spinner_chaeum_food_tea_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_chaeum_tea.setAdapter(itemAdapter_chaeum_tea);
        spinner_chaeum_tea.post(new Runnable() {
            @Override
            public void run() {
                spinner_chaeum_tea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        item_g.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        spinner_chaeum_coffee_layout= (LinearLayout)findViewById(R.id.spinner_chaeum_coffee_layout);
        spinner_chaeum_coffee = (Spinner) findViewById(R.id.spinner_chaeum_food_coffee);
        ArrayAdapter itemAdapter_chaeum_coffee= ArrayAdapter.createFromResource(this,
                R.array.spinner_chaeum_food_coffee_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_chaeum_coffee.setAdapter(itemAdapter_chaeum_coffee);
        spinner_chaeum_coffee.post(new Runnable() {
            @Override
            public void run() {
                spinner_chaeum_coffee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        item_g.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });



        //용기에 담을 제품 선택 스피너
        Spinner spinner_item = (Spinner) findViewById(R.id.spinner_item);
        ArrayAdapter itemAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_item.setAdapter(itemAdapter);

        //담고 싶은 g 선택 스피너
        Spinner spinner_g = (Spinner) findViewById(R.id.spinner_g);
        ArrayAdapter gAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_g.setAdapter(gAdapter);
        spinner_g.post(new Runnable() {
            @Override
            public void run() {
                spinner_g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        item_select_complete_btn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //확인 버튼
        item_select_complete_btn = (Button) findViewById(R.id.item_select_complete);
        item_select_complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //용기 스캔 카메라 로 인텐
                Intent intent = new Intent(getApplicationContext(), AR_camera.class);

                intent.putExtra("item_g", spinner_g.getSelectedItem().toString());
                intent.putExtra("item_earth_detergent", spinner_earth_wash_detergent.getSelectedItem().toString());
                intent.putExtra("item_chaeum_tea", spinner_chaeum_tea.getSelectedItem().toString());
                intent.putExtra("item_chaeum_coffee", spinner_chaeum_coffee.getSelectedItem().toString());

                startActivity(intent);
            }
        });












        item_name = (LinearLayout) findViewById(R.id.item_name);
        item_g = (LinearLayout) findViewById(R.id.item_g);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.ar_shop_1:  //알맹상점을 클릭했을 때
                ar_shop_1.setSelected(true);
                ar_shop_2.setSelected(false);
                ar_shop_3.setSelected(false);
                ar_shop_4.setSelected(false);

                ar_shop_1.setTextColor(Color.parseColor("#FFFFFF"));
                ar_shop_2.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_3.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_4.setTextColor(Color.parseColor("#C2C2C2"));

                almaeng_layout.setVisibility(View.VISIBLE);
                earth_layout.setVisibility(View.INVISIBLE);
                chaeum_layout.setVisibility(View.INVISIBLE);

                spinner_earth_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);
                item_g.setVisibility(View.INVISIBLE);
                item_select_complete_btn.setVisibility(View.INVISIBLE);
                break;


            case R.id.ar_shop_2:  //지구샵
                ar_shop_1.setSelected(false);
                ar_shop_2.setSelected(true);
                ar_shop_3.setSelected(false);
                ar_shop_4.setSelected(false);

                ar_shop_1.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_2.setTextColor(Color.parseColor("#FFFFFF"));
                ar_shop_3.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_4.setTextColor(Color.parseColor("#C2C2C2"));


                almaeng_layout.setVisibility(View.INVISIBLE);
                earth_layout.setVisibility(View.VISIBLE);
                chaeum_layout.setVisibility(View.INVISIBLE);

                spinner_earth_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);
                item_g.setVisibility(View.INVISIBLE);
                item_select_complete_btn.setVisibility(View.INVISIBLE);
                break;

            case R.id.ar_shop_3: //채움소
                ar_shop_1.setSelected(false);
                ar_shop_2.setSelected(false);
                ar_shop_3.setSelected(true);
                ar_shop_4.setSelected(false);

                ar_shop_1.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_2.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_3.setTextColor(Color.parseColor("#FFFFFF"));
                ar_shop_4.setTextColor(Color.parseColor("#C2C2C2"));


                almaeng_layout.setVisibility(View.INVISIBLE);
                earth_layout.setVisibility(View.INVISIBLE);
                chaeum_layout.setVisibility(View.VISIBLE);

                spinner_earth_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);
                item_g.setVisibility(View.INVISIBLE);
                item_select_complete_btn.setVisibility(View.INVISIBLE);
                break;
        }

        //알맹상점
        switch (v.getId()){
            case R.id.almaeng_food:
                almaeng_food_bg.setVisibility(View.VISIBLE);
                almaeng_wash_bg.setVisibility(View.INVISIBLE);
                almaeng_body_bg.setVisibility(View.INVISIBLE);
                almaeng_face_bg.setVisibility(View.INVISIBLE);

                almaeng_food_items.setVisibility(View.VISIBLE);
                almaeng_wash_items.setVisibility(View.INVISIBLE);
                almaeng_body_items.setVisibility(View.INVISIBLE);
                almaeng_face_items.setVisibility(View.INVISIBLE);

                almaeng_food.setTextColor(Color.parseColor("#EB6446"));
                almaeng_wash.setTextColor(Color.parseColor("#505050"));
                almaeng_body.setTextColor(Color.parseColor("#505050"));
                almaeng_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.almaeng_wash:
                almaeng_food_bg.setVisibility(View.INVISIBLE);
                almaeng_wash_bg.setVisibility(View.VISIBLE);
                almaeng_body_bg.setVisibility(View.INVISIBLE);
                almaeng_face_bg.setVisibility(View.INVISIBLE);

                almaeng_food_items.setVisibility(View.INVISIBLE);
                almaeng_wash_items.setVisibility(View.VISIBLE);
                almaeng_body_items.setVisibility(View.INVISIBLE);
                almaeng_face_items.setVisibility(View.INVISIBLE);

                almaeng_food.setTextColor(Color.parseColor("#505050"));
                almaeng_wash.setTextColor(Color.parseColor("#EB6446"));
                almaeng_body.setTextColor(Color.parseColor("#505050"));
                almaeng_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.almaeng_body:
                almaeng_food_bg.setVisibility(View.INVISIBLE);
                almaeng_wash_bg.setVisibility(View.INVISIBLE);
                almaeng_body_bg.setVisibility(View.VISIBLE);
                almaeng_face_bg.setVisibility(View.INVISIBLE);

                almaeng_food_items.setVisibility(View.INVISIBLE);
                almaeng_wash_items.setVisibility(View.INVISIBLE);
                almaeng_body_items.setVisibility(View.VISIBLE);
                almaeng_face_items.setVisibility(View.INVISIBLE);

                almaeng_food.setTextColor(Color.parseColor("#505050"));
                almaeng_wash.setTextColor(Color.parseColor("#505050"));
                almaeng_body.setTextColor(Color.parseColor("#EB6446"));
                almaeng_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.almaeng_face:
                almaeng_food_bg.setVisibility(View.INVISIBLE);
                almaeng_wash_bg.setVisibility(View.INVISIBLE);
                almaeng_body_bg.setVisibility(View.INVISIBLE);
                almaeng_face_bg.setVisibility(View.VISIBLE);

                almaeng_food_items.setVisibility(View.INVISIBLE);
                almaeng_wash_items.setVisibility(View.INVISIBLE);
                almaeng_body_items.setVisibility(View.INVISIBLE);
                almaeng_face_items.setVisibility(View.VISIBLE);

                almaeng_food.setTextColor(Color.parseColor("#505050"));
                almaeng_wash.setTextColor(Color.parseColor("#505050"));
                almaeng_body.setTextColor(Color.parseColor("#505050"));
                almaeng_face.setTextColor(Color.parseColor("#EB6446"));
                break;
        }



        //지구샵
        switch (v.getId()){
            case R.id.earth_wash:
                earth_wash_bg.setVisibility(View.VISIBLE);
                earth_wash_items.setVisibility(View.VISIBLE);
                earth_wash.setTextColor(Color.parseColor("#EB6446"));
                break;

            case R.id.earth_wash_detergent:
                earth_wash_detergent.setTextColor(Color.parseColor("#EB6446"));

                spinner_earth_layout.setVisibility(View.VISIBLE);
                break;

        }




        //채움소
        switch (v.getId()){
            case R.id.chaeum_food:
                chaeum_food_bg.setVisibility(View.VISIBLE);
                chaeum_food.setTextColor(Color.parseColor("#EB6446"));
                chaeum_food_items.setVisibility(View.VISIBLE);
                break;

            case R.id.chaeum_food_tea:
                chaeum_food_tea.setTextColor(Color.parseColor("#EB6446"));
                chaeum_food_coffee.setTextColor(Color.parseColor("#505050"));

                spinner_chaeum_tea_layout.setVisibility(View.VISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);


                break;

            case R.id.chaeum_food_coffee:
                chaeum_food_tea.setTextColor(Color.parseColor("#505050"));
                chaeum_food_coffee.setTextColor(Color.parseColor("#EB6446"));

                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.VISIBLE);


                break;


        }


    }

}