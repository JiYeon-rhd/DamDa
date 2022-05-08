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

public class AR_select_chaeum extends AppCompatActivity implements View.OnClickListener  {

    LinearLayout chaeum_layout;
    Button chaeum_food;
    ImageView chaeum_food_bg;
    LinearLayout chaeum_food_items;

    Button chaeum_food_tea;
    Button chaeum_food_coffee;


    LinearLayout spinner_chaeum_tea_layout;
    LinearLayout spinner_chaeum_coffee_layout;

    Spinner spinner_chaeum_tea;
    Spinner spinner_chaeum_coffee;


    LinearLayout gram_chaeum_layout;
    Spinner spinner_chaeum_gram;

    Button complete_btn_chaeum;

    String bottle_name;
    String shop_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_chaeum);

        //용기이름, 상점 이름 받아서 넘기기
        Intent intent = getIntent();
        bottle_name = intent.getStringExtra("용기이름");
        shop_name = intent.getStringExtra("상점이름");

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
        spinner_chaeum_coffee_layout = (LinearLayout)findViewById(R.id.spinner_chaeum_coffee_layout);

        gram_chaeum_layout=findViewById(R.id.gram_chaeum_layout);
        spinner_chaeum_gram = (Spinner)findViewById(R.id.spinner_chaeum_gram);

        //티 스피너
        spinner_chaeum_tea = (Spinner) findViewById(R.id.spinner_chaeum_tea_item);
        ArrayAdapter itemAdapter_chaeum_tea = ArrayAdapter.createFromResource(this,
                R.array.spinner_tea, android.R.layout.simple_spinner_dropdown_item);
        spinner_chaeum_tea.setAdapter(itemAdapter_chaeum_tea);
        spinner_chaeum_tea.post(new Runnable() {
            @Override
            public void run() {
                spinner_chaeum_tea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        gram_chaeum_layout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //커피 스피너
        spinner_chaeum_coffee_layout= (LinearLayout)findViewById(R.id.spinner_chaeum_coffee_layout);
        spinner_chaeum_coffee = (Spinner) findViewById(R.id.spinner_chaeum_coffee_item);
        ArrayAdapter itemAdapter_chaeum_coffee= ArrayAdapter.createFromResource(this,
                R.array.spinner_coffee, android.R.layout.simple_spinner_dropdown_item);
        spinner_chaeum_coffee.setAdapter(itemAdapter_chaeum_coffee);
        spinner_chaeum_coffee.post(new Runnable() {
            @Override
            public void run() {
                spinner_chaeum_coffee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        gram_chaeum_layout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //완료버튼
        complete_btn_chaeum =findViewById(R.id.item_select_complete_chaeum);

        //그램 스피너
        spinner_chaeum_gram = (Spinner) findViewById(R.id.spinner_chaeum_gram);
        ArrayAdapter itemAdapter_gram= ArrayAdapter.createFromResource(this,
                R.array.spinner_400g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_chaeum_gram.setAdapter(itemAdapter_gram);
        spinner_chaeum_gram.setSelected(false);
        spinner_chaeum_gram.post(new Runnable() {
            @Override
            public void run() {
                spinner_chaeum_gram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        complete_btn_chaeum.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        complete_btn_chaeum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR_select_chaeum.this, AR_complete.class);
                intent.putExtra("상점이름", shop_name);
                intent.putExtra("용기이름", bottle_name);

                intent.putExtra("채움소 티", spinner_chaeum_tea.getSelectedItem().toString());
                intent.putExtra("채움소 커피", spinner_chaeum_coffee.getSelectedItem().toString());
                intent.putExtra("채움소 선택한 그램", spinner_chaeum_gram.getSelectedItem().toString());

                startActivity(intent);
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chaeum_food:
                chaeum_food_bg.setVisibility(View.VISIBLE);
                chaeum_food_items.setVisibility(View.VISIBLE);
                chaeum_food.setTextColor(Color.parseColor("#EB6446"));

                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);
                gram_chaeum_layout.setVisibility(View.INVISIBLE);
                complete_btn_chaeum.setVisibility(View.INVISIBLE);
                break;

            case R.id.chaeum_food_tea:
                chaeum_food_tea.setTextColor(Color.parseColor("#EB6446"));
                chaeum_food_coffee.setTextColor(Color.parseColor("#505050"));

                spinner_chaeum_tea_layout.setVisibility(View.VISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_tea.setSelection(0);
                spinner_chaeum_coffee.setSelection(0);


                gram_chaeum_layout.setVisibility(View.INVISIBLE);
                complete_btn_chaeum.setVisibility(View.INVISIBLE);


                break;

            case R.id.chaeum_food_coffee:
                chaeum_food_tea.setTextColor(Color.parseColor("#505050"));
                chaeum_food_coffee.setTextColor(Color.parseColor("#EB6446"));

                spinner_chaeum_tea_layout.setVisibility(View.INVISIBLE);
                spinner_chaeum_coffee_layout.setVisibility(View.VISIBLE);
                spinner_chaeum_tea.setSelection(0);
                spinner_chaeum_coffee.setSelection(0);


                gram_chaeum_layout.setVisibility(View.INVISIBLE);
                complete_btn_chaeum.setVisibility(View.INVISIBLE);
                break;


        }
    }
}