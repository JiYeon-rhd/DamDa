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
import android.widget.Switch;

import com.example.wonderv2.R;

public class AR_select_almaeng extends AppCompatActivity implements View.OnClickListener {
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
    Button almaeng_face_tonor;
    Button almaeng_face_cream;
    Button almaeng_wash_scent;
    Button almaeng_wash_kitchen;
    Button almaeng_body_shampoo;
    Button almaeng_body_conditioner;



    LinearLayout spinner_shampoo_layout;
    LinearLayout spinner_conditioner_layout;
    LinearLayout spinner_tonor_layout;
    LinearLayout spinner_cream_layout;
    LinearLayout spinner_scent_layout;
    LinearLayout spinner_kitchen_layout;
    LinearLayout spinner_tea_layout;
    LinearLayout spinner_coffee_layout;

    Spinner spinner_shampoo_item;
    Spinner spinner_conditioner_item;
    Spinner spinner_tonor_item;
    Spinner spinner_cream_item;
    Spinner spinner_scent_item;
    Spinner spinner_kitchen_item;
    Spinner spinner_tea_item;
    Spinner spinner_coffee_item;

    LinearLayout gram_layout;
    Spinner spinner_gram;
    LinearLayout gram_400_layout;
    Spinner spinner_gram_400;

    Button complete_btn;

    String bottle_name;
    String shop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_almaeng);

        //용기이름, 상점 이름 받아서 넘기기
        Intent intent = getIntent();
        bottle_name = intent.getStringExtra("용기이름");
        shop_name = intent.getStringExtra("상점이름");


        //알맹상점
        almaeng_layout = (LinearLayout) findViewById(R.id.almaeng_layout);

        //카테고리 선택
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


        //상품들
        almaeng_food_items = (LinearLayout) findViewById(R.id.almaeng_food_items);
        almaeng_body_items = (LinearLayout) findViewById(R.id.almaeng_body_items);
        almaeng_face_items = (LinearLayout) findViewById(R.id.almaeng_face_items);
        almaeng_wash_items = (LinearLayout) findViewById(R.id.almaeng_wash_items);

        //제품들
        almaeng_food_tea = (Button)findViewById(R.id.almaeng_food_tea);  //알맹상점 푸드 상품 목록
        almaeng_food_tea.setOnClickListener(this);
        almaeng_food_coffee=(Button)findViewById(R.id.almaeng_food_coffee);
        almaeng_food_coffee.setOnClickListener(this);
        almaeng_face_tonor =findViewById(R.id.almaeng_face_tonor);
        almaeng_face_tonor.setOnClickListener(this);
        almaeng_face_cream=findViewById(R.id.almaeng_face_cream);
        almaeng_face_cream.setOnClickListener(this);
        almaeng_wash_scent=findViewById(R.id.almaeng_wash_scent);
        almaeng_wash_scent.setOnClickListener(this);
        almaeng_wash_kitchen=findViewById(R.id.almaeng_wash_kitchen);
        almaeng_wash_kitchen.setOnClickListener(this);
        almaeng_body_shampoo=findViewById(R.id.almaeng_body_shampoo);
        almaeng_body_shampoo.setOnClickListener(this);
        almaeng_body_conditioner=findViewById(R.id.almaeng_body_conditioner);
        almaeng_body_conditioner.setOnClickListener(this);


        //스피너 레이아웃
        spinner_shampoo_layout = findViewById(R.id.spinner_shampoo_layout);
        spinner_conditioner_layout = findViewById(R.id.spinner_conditioner_layout);
        spinner_tonor_layout = findViewById(R.id.spinner_toner_layout);
        spinner_cream_layout = findViewById(R.id.spinner_cream_layout);
        spinner_scent_layout = findViewById(R.id.spinner_scent_layout);
        spinner_kitchen_layout = findViewById(R.id.spinner_kitchen_layout);
        spinner_tea_layout = findViewById(R.id.spinner_tea_layout);
        spinner_coffee_layout = findViewById(R.id.spinner_coffee_layout);

        gram_layout=findViewById(R.id.gram_layout);
        spinner_gram = (Spinner)findViewById(R.id.spinner_gram);
        gram_400_layout=findViewById(R.id.gram_400_layout);
        spinner_gram_400 = (Spinner)findViewById(R.id.spinner_gram_400);

        //샴푸 스피너
        spinner_shampoo_item = (Spinner) findViewById(R.id.spinner_shampoo_item);
        ArrayAdapter itemAdapter_shampoo= ArrayAdapter.createFromResource(this,
                R.array.spinner_shampoo, android.R.layout.simple_spinner_dropdown_item);
        spinner_shampoo_item.setAdapter(itemAdapter_shampoo);
        spinner_shampoo_item.setSelected(false);
        spinner_shampoo_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_shampoo_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //컨디셔너 스피너
        spinner_conditioner_item = (Spinner) findViewById(R.id.spinner_conditioner_item);
        ArrayAdapter itemAdapter_conditioner= ArrayAdapter.createFromResource(this,
                R.array.spinner_conditioner, android.R.layout.simple_spinner_dropdown_item);
        spinner_conditioner_item.setAdapter(itemAdapter_conditioner);
        spinner_conditioner_item.setSelected(false);
        spinner_conditioner_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_conditioner_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //토너 스피너
        spinner_tonor_item = (Spinner) findViewById(R.id.spinner_toner_item);
        ArrayAdapter itemAdapter_toner= ArrayAdapter.createFromResource(this,
                R.array.spinner_tonor, android.R.layout.simple_spinner_dropdown_item);
        spinner_tonor_item.setAdapter(itemAdapter_toner);
        spinner_tonor_item.setSelected(false);
        spinner_tonor_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_tonor_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //크림 스피너
        spinner_cream_item = (Spinner) findViewById(R.id.spinner_cream_item);
        ArrayAdapter itemAdapter_cream= ArrayAdapter.createFromResource(this,
                R.array.spinner_cream, android.R.layout.simple_spinner_dropdown_item);
        spinner_cream_item.setAdapter(itemAdapter_cream);
        spinner_cream_item.setSelected(false);
        spinner_cream_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_cream_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //섬유유연제 스피너
        spinner_scent_item = (Spinner) findViewById(R.id.spinner_scent_item);
        ArrayAdapter itemAdapter_scent= ArrayAdapter.createFromResource(this,
                R.array.spinner_scent, android.R.layout.simple_spinner_dropdown_item);
        spinner_scent_item.setAdapter(itemAdapter_scent);
        spinner_scent_item.setSelected(false);
        spinner_scent_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_scent_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //주방세제 스피너
        spinner_kitchen_item = (Spinner) findViewById(R.id.spinner_kitchen_item);
        ArrayAdapter itemAdapter_kitchen= ArrayAdapter.createFromResource(this,
                R.array.spinner_kitchen, android.R.layout.simple_spinner_dropdown_item);
        spinner_kitchen_item.setAdapter(itemAdapter_kitchen);
        spinner_kitchen_item.setSelected(false);
        spinner_kitchen_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_kitchen_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //티 스피너
        spinner_tea_item = (Spinner) findViewById(R.id.spinner_tea_item);
        ArrayAdapter itemAdapter_tea= ArrayAdapter.createFromResource(this,
                R.array.spinner_tea, android.R.layout.simple_spinner_dropdown_item);
        spinner_tea_item.setAdapter(itemAdapter_tea);
        spinner_tea_item.setSelected(false);
        spinner_tea_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_tea_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //커피 스피너
        spinner_coffee_item = (Spinner) findViewById(R.id.spinner_coffee_item);
        ArrayAdapter itemAdapter_coffee= ArrayAdapter.createFromResource(this,
                R.array.spinner_coffee, android.R.layout.simple_spinner_dropdown_item);
        spinner_coffee_item.setAdapter(itemAdapter_coffee);
        spinner_coffee_item.setSelected(false);
        spinner_coffee_item.post(new Runnable() {
            @Override
            public void run() {
                spinner_coffee_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        setGramSpinner();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //완료버튼
        complete_btn =findViewById(R.id.item_select_complete);

        //그램 스피너  작은거
        spinner_gram = (Spinner) findViewById(R.id.spinner_gram);
        ArrayAdapter itemAdapter_gram= ArrayAdapter.createFromResource(this,
                R.array.spinner_g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_gram.setAdapter(itemAdapter_gram);
        spinner_gram.setSelected(false);
        spinner_gram.post(new Runnable() {
            @Override
            public void run() {
                spinner_gram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       complete_btn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        //그램 스피너  400까지
        spinner_gram_400 = (Spinner) findViewById(R.id.spinner_gram_400);
        ArrayAdapter itemAdapter_gram_400= ArrayAdapter.createFromResource(this,
                R.array.spinner_400g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_gram_400.setAdapter(itemAdapter_gram_400);
        spinner_gram_400.setSelected(false);
        spinner_gram_400.post(new Runnable() {
            @Override
            public void run() {
                spinner_gram_400.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        complete_btn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //[확인 버튼]
        complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR_select_almaeng.this, AR_complete.class);

                intent.putExtra("상점이름", shop_name);
                intent.putExtra("용기이름", bottle_name);


                intent.putExtra("알맹 선택한 그램", spinner_gram.getSelectedItem().toString());
                intent.putExtra("알맹 선택한 그램 400", spinner_gram_400.getSelectedItem().toString());
                intent.putExtra("알맹 샴푸", spinner_shampoo_item.getSelectedItem().toString());
                intent.putExtra("알맹 컨디셔너", spinner_conditioner_item.getSelectedItem().toString());
                intent.putExtra("알맹 토너", spinner_tonor_item.getSelectedItem().toString());
                intent.putExtra("알맹 크림", spinner_cream_item.getSelectedItem().toString());
                intent.putExtra("알맹 섬유유연제", spinner_scent_item.getSelectedItem().toString());
                intent.putExtra("알맹 주방세제", spinner_kitchen_item.getSelectedItem().toString());
                intent.putExtra("알맹 티", spinner_tea_item.getSelectedItem().toString());
                intent.putExtra("알맹 커피", spinner_coffee_item.getSelectedItem().toString());

                startActivity(intent);
            }
        });



    }

    public void setGramSpinner(){
        if(bottle_name.equals("al_L")){//400까지
            gram_layout.setVisibility(View.INVISIBLE);
            gram_400_layout.setVisibility(View.VISIBLE);
        }
        else if(bottle_name.equals("al_M") || bottle_name.equals("al_S")){
            gram_400_layout.setVisibility(View.INVISIBLE);
            gram_layout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

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

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);

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

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
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

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);

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

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);

                break;

        }
        switch(v.getId()){
            //제품선택

            //티
            case R.id.almaeng_food_tea:
                almaeng_food_tea.setTextColor(Color.parseColor("#EB6446"));
                almaeng_food_coffee.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.VISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;


            //커피
            case R.id.almaeng_food_coffee:
                almaeng_food_tea.setTextColor(Color.parseColor("#505050"));
                almaeng_food_coffee.setTextColor(Color.parseColor("#EB6446"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.VISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;


            //토너
            case R.id.almaeng_face_tonor:
                almaeng_face_tonor.setTextColor(Color.parseColor("#EB6446"));
                almaeng_face_cream.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.VISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;

            //크림
            case R.id.almaeng_face_cream:
                almaeng_face_cream.setTextColor(Color.parseColor("#EB6446"));
                almaeng_face_tonor.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.VISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;


            //섬유유연제
            case R.id.almaeng_wash_scent:
                almaeng_wash_scent.setTextColor(Color.parseColor("#EB6446"));
                almaeng_wash_kitchen.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.VISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;

            //주방세제
            case R.id.almaeng_wash_kitchen:
                almaeng_wash_kitchen.setTextColor(Color.parseColor("#EB6446"));
                almaeng_wash_scent.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.VISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;


            //샴푸
            case R.id.almaeng_body_shampoo:
                almaeng_body_shampoo.setTextColor(Color.parseColor("#EB6446"));
                almaeng_body_conditioner.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.VISIBLE);
                spinner_conditioner_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;


            //컨디셔너
            case R.id.almaeng_body_conditioner:
                almaeng_body_conditioner.setTextColor(Color.parseColor("#EB6446"));
                almaeng_body_shampoo.setTextColor(Color.parseColor("#505050"));

                spinner_tea_layout.setVisibility(View.INVISIBLE);
                spinner_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_tonor_layout.setVisibility(View.INVISIBLE);
                spinner_cream_layout.setVisibility(View.INVISIBLE);
                spinner_scent_layout.setVisibility(View.INVISIBLE);
                spinner_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_shampoo_layout.setVisibility(View.INVISIBLE);
                spinner_conditioner_layout.setVisibility(View.VISIBLE);
                spinner_conditioner_item.setSelection(0);
                spinner_shampoo_item.setSelection(0);
                spinner_tonor_item.setSelection(0);
                spinner_cream_item.setSelection(0);
                spinner_scent_item.setSelection(0);
                spinner_kitchen_item.setSelection(0);
                spinner_tea_item.setSelection(0);
                spinner_coffee_item.setSelection(0);
                spinner_gram_400.setSelection(0);
                spinner_gram.setSelection(0);

                gram_layout.setVisibility(View.INVISIBLE);
                gram_400_layout.setVisibility(View.INVISIBLE);
                complete_btn.setVisibility(View.INVISIBLE);
                break;

        }
    }
}