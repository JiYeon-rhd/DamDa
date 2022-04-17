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


    //알맹상점
    LinearLayout item_select_layout; //제품 선택 전체 레이아웃 알맹상점
    Button item_food; // 카테고리
    Button item_wash;
    Button item_body;
    Button item_face;
    ImageView item_food_bg; //탭 이미지뷰
    ImageView item_wash_bg;
    ImageView item_body_bg;
    ImageView item_face_bg;
    LinearLayout item_food_items; //상품들
    LinearLayout item_face_items;
    LinearLayout item_body_items;
    LinearLayout item_wash_items;



    Button food_tea;  //푸드 카테고리 상품들
    Button food_coffee;

    //지구샵
    LinearLayout item_earth_layout;
    Button item_earth_wash;
    ImageView item_earth_wash_bg;
    LinearLayout item_earth_wash_items;

    Button wash_detergent; //세탁용 세

    LinearLayout spinner_earth_layout;



    //채움소
    LinearLayout item_chaeum_layout; //채움소 레이아웃
    Button item_chaeum_food;
    ImageView item_chaeum_food_bg;
    LinearLayout item_chaeum_food_items;

    Button food_chaeum_tea;
    Button food_chaeum_coffee;

    LinearLayout spinner_chaeum_tea_layout;
    LinearLayout spinner_chaeum_coffee_layout;


    Spinner spinner_earth_wash_detergent;



    //용기에 담을 제품 리니어
    LinearLayout item_name;
    //담고싶은 그램수 리니어
    LinearLayout item_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_item);


        //용기에 담을 제품 선택 스피너
        Spinner spinner_item = (Spinner) findViewById(R.id.spinner_item);
        ArrayAdapter itemAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_item.setAdapter(itemAdapter);


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

        //알맹상점
        item_food = (Button)findViewById(R.id.item_food);
        item_food.setOnClickListener(this);
        item_face = (Button) findViewById(R.id.item_face);
        item_face.setOnClickListener(this);
        item_body = (Button) findViewById(R.id.item_body);
        item_body.setOnClickListener(this);
        item_wash = (Button) findViewById(R.id.item_wash);
        item_wash.setOnClickListener(this);

        item_food_bg = (ImageView)findViewById(R.id.item_food_bg);
        item_face_bg = (ImageView)findViewById(R.id.item_face_bg);
        item_wash_bg = (ImageView)findViewById(R.id.item_wash_bg);
        item_body_bg = (ImageView) findViewById(R.id.item_body_bg);


        item_select_layout = (LinearLayout) findViewById(R.id.item_almaeng_layout);
        item_food_items = (LinearLayout) findViewById(R.id.item_food_items);
        item_body_items = (LinearLayout) findViewById(R.id.item_body_items);
        item_face_items = (LinearLayout) findViewById(R.id.item_face_items);
        item_wash_items = (LinearLayout) findViewById(R.id.item_wash_items);

        food_tea = (Button)findViewById(R.id.food_tea);  //알맹상점 푸드 상품 목록
        food_tea.setOnClickListener(this);
        food_coffee=(Button)findViewById(R.id.food_coffe);
        food_coffee.setOnClickListener(this);


        //지구샵
        item_earth_layout = (LinearLayout)findViewById(R.id.item_earth_layout);
        item_earth_wash_bg = (ImageView)findViewById(R.id.item_earth_wash_bg);
        item_earth_wash = (Button) findViewById(R.id.item_earth_wash);
        item_earth_wash.setOnClickListener(this);
        item_earth_wash_items=(LinearLayout)findViewById(R.id.item_earth_wash_items);

        wash_detergent =(Button)findViewById(R.id.wash_detergent);
        wash_detergent.setOnClickListener(this);

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
        item_chaeum_layout = (LinearLayout) findViewById(R.id.item_chaeum_layout);
        item_chaeum_food =(Button) findViewById(R.id.item_chaeum_food);
        item_chaeum_food.setOnClickListener(this);
        item_chaeum_food_bg=(ImageView) findViewById(R.id.item_chaeum_food_bg);
        item_chaeum_food_items=(LinearLayout) findViewById(R.id.item_chaeum_food_items);

        food_chaeum_tea=(Button)findViewById(R.id.food_chaeum_tea);
        food_chaeum_tea.setOnClickListener(this);
        food_chaeum_coffee=(Button)findViewById(R.id.food_chaeum_coffee);
        food_chaeum_coffee.setOnClickListener(this);

        spinner_chaeum_tea_layout = (LinearLayout)findViewById(R.id.spinner_chaeum_tea_layout);

        Spinner spinner_chaeum_tea = (Spinner) findViewById(R.id.spinner_chaeum_food_tea);
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
        Spinner spinner_chaeum_coffee = (Spinner) findViewById(R.id.spinner_chaeum_food_coffee);
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



        item_name = (LinearLayout) findViewById(R.id.item_name);
        item_g = (LinearLayout) findViewById(R.id.item_g);


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


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.ar_shop_1:  //알맹상점을 클릭했을
                ar_shop_1.setSelected(true);
                ar_shop_2.setSelected(false);
                ar_shop_3.setSelected(false);

                ar_shop_1.setTextColor(Color.parseColor("#FFFFFF"));
                ar_shop_2.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_3.setTextColor(Color.parseColor("#C2C2C2"));

                item_select_layout.setVisibility(View.VISIBLE);
                item_earth_layout.setVisibility(View.INVISIBLE);
                item_chaeum_layout.setVisibility(View.INVISIBLE);

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

                ar_shop_1.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_2.setTextColor(Color.parseColor("#FFFFFF"));
                ar_shop_3.setTextColor(Color.parseColor("#C2C2C2"));


                item_select_layout.setVisibility(View.INVISIBLE);
                item_earth_layout.setVisibility(View.VISIBLE);
                item_chaeum_layout.setVisibility(View.INVISIBLE);

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

                ar_shop_1.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_2.setTextColor(Color.parseColor("#C2C2C2"));
                ar_shop_3.setTextColor(Color.parseColor("#FFFFFF"));


                item_select_layout.setVisibility(View.INVISIBLE);
                item_earth_layout.setVisibility(View.INVISIBLE);
                item_chaeum_layout.setVisibility(View.VISIBLE);

                spinner_earth_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);
                item_g.setVisibility(View.INVISIBLE);
                item_select_complete_btn.setVisibility(View.INVISIBLE);
                break;
        }

        //알맹상점
        switch (v.getId()){
            case R.id.item_food:
                item_food_bg.setVisibility(View.VISIBLE);
                item_wash_bg.setVisibility(View.INVISIBLE);
                item_body_bg.setVisibility(View.INVISIBLE);
                item_face_bg.setVisibility(View.INVISIBLE);

                item_food_items.setVisibility(View.VISIBLE);
                item_wash_items.setVisibility(View.INVISIBLE);
                item_body_items.setVisibility(View.INVISIBLE);
                item_face_items.setVisibility(View.INVISIBLE);

                item_food.setTextColor(Color.parseColor("#EB6446"));
                item_wash.setTextColor(Color.parseColor("#505050"));
                item_body.setTextColor(Color.parseColor("#505050"));
                item_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.item_wash:
                item_food_bg.setVisibility(View.INVISIBLE);
                item_wash_bg.setVisibility(View.VISIBLE);
                item_body_bg.setVisibility(View.INVISIBLE);
                item_face_bg.setVisibility(View.INVISIBLE);

                item_food_items.setVisibility(View.INVISIBLE);
                item_wash_items.setVisibility(View.VISIBLE);
                item_body_items.setVisibility(View.INVISIBLE);
                item_face_items.setVisibility(View.INVISIBLE);

                item_food.setTextColor(Color.parseColor("#505050"));
                item_wash.setTextColor(Color.parseColor("#EB6446"));
                item_body.setTextColor(Color.parseColor("#505050"));
                item_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.item_body:
                item_food_bg.setVisibility(View.INVISIBLE);
                item_wash_bg.setVisibility(View.INVISIBLE);
                item_body_bg.setVisibility(View.VISIBLE);
                item_face_bg.setVisibility(View.INVISIBLE);

                item_food_items.setVisibility(View.INVISIBLE);
                item_wash_items.setVisibility(View.INVISIBLE);
                item_body_items.setVisibility(View.VISIBLE);
                item_face_items.setVisibility(View.INVISIBLE);

                item_food.setTextColor(Color.parseColor("#505050"));
                item_wash.setTextColor(Color.parseColor("#505050"));
                item_body.setTextColor(Color.parseColor("#EB6446"));
                item_face.setTextColor(Color.parseColor("#505050"));
                break;

            case R.id.item_face:
                item_food_bg.setVisibility(View.INVISIBLE);
                item_wash_bg.setVisibility(View.INVISIBLE);
                item_body_bg.setVisibility(View.INVISIBLE);
                item_face_bg.setVisibility(View.VISIBLE);

                item_food_items.setVisibility(View.INVISIBLE);
                item_wash_items.setVisibility(View.INVISIBLE);
                item_body_items.setVisibility(View.INVISIBLE);
                item_face_items.setVisibility(View.VISIBLE);

                item_food.setTextColor(Color.parseColor("#505050"));
                item_wash.setTextColor(Color.parseColor("#505050"));
                item_body.setTextColor(Color.parseColor("#505050"));
                item_face.setTextColor(Color.parseColor("#EB6446"));
                break;
        }



        //지구샵
        switch (v.getId()){
            case R.id.item_earth_wash:
                item_earth_wash_bg.setVisibility(View.VISIBLE);
                item_earth_wash_items.setVisibility(View.VISIBLE);
                item_earth_wash.setTextColor(Color.parseColor("#EB6446"));
                break;

            case R.id.wash_detergent:
                wash_detergent.setTextColor(Color.parseColor("#EB6446"));

                spinner_earth_layout.setVisibility(View.VISIBLE);
                break;

        }




        //채움소
        switch (v.getId()){
            case R.id.item_chaeum_food:
                item_chaeum_food_bg.setVisibility(View.VISIBLE);
                item_chaeum_food.setTextColor(Color.parseColor("#EB6446"));
                item_chaeum_food_items.setVisibility(View.VISIBLE);
                break;

            case R.id.food_chaeum_tea:
                food_chaeum_tea.setTextColor(Color.parseColor("#EB6446"));
                food_chaeum_coffee.setTextColor(Color.parseColor("#505050"));

                spinner_chaeum_tea_layout.setVisibility(View.VISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);


                break;

            case R.id.food_chaeum_coffee:
                food_chaeum_tea.setTextColor(Color.parseColor("#505050"));
                food_chaeum_coffee.setTextColor(Color.parseColor("#EB6446"));

                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.VISIBLE);


                break;


        }


    }

}