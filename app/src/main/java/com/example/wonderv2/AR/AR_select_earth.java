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

public class AR_select_earth extends AppCompatActivity implements View.OnClickListener{
    //지구샵
    LinearLayout earth_layout;
    Button earth_wash;
    ImageView earth_wash_bg;
    LinearLayout earth_wash_items;

    Button earth_wash_kitchen; //세탁용 세
    Button earth_wash_scent; //섬유유연제

    LinearLayout spinner_earth_scent_layout;
    LinearLayout spinner_earth_kitchen_layout;

    Spinner spinner_earth_scent;
    Spinner spinner_earth_kitchen;


    LinearLayout gram_earth_layout;
    Spinner spinner_earth_gram;

    Button complete_btn_earth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_earth);

        //지구샵
        earth_layout = (LinearLayout)findViewById(R.id.earth_layout);
        earth_wash_bg = (ImageView)findViewById(R.id.earth_wash_bg);
        earth_wash = (Button) findViewById(R.id.earth_wash);
        earth_wash.setOnClickListener(this);
        earth_wash_items=(LinearLayout)findViewById(R.id.earth_wash_items);

        earth_wash_kitchen = findViewById(R.id.earth_wash_kitchen);
        earth_wash_kitchen.setOnClickListener(this);
        earth_wash_scent = findViewById(R.id.earth_wash_scent);
        earth_wash_scent.setOnClickListener(this);

        spinner_earth_scent_layout = (LinearLayout)findViewById(R.id.spinner_earth_scent_layout);
        spinner_earth_kitchen_layout = (LinearLayout)findViewById(R.id.spinner_earth_kitchen_layout);

        gram_earth_layout=findViewById(R.id.gram_earth_layout);
        spinner_earth_gram = (Spinner)findViewById(R.id.spinner_earth_gram);


        //섬유유연제 스피너
        spinner_earth_scent= (Spinner) findViewById(R.id.spinner_earth_scent_item);
        ArrayAdapter itemAdapter_chaeum_tea = ArrayAdapter.createFromResource(this,
                R.array.spinner_scent, android.R.layout.simple_spinner_dropdown_item);
        spinner_earth_scent.setAdapter(itemAdapter_chaeum_tea);
        spinner_earth_scent.post(new Runnable() {
            @Override
            public void run() {
                spinner_earth_scent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        gram_earth_layout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });


        //주방세제 스피너
        spinner_earth_kitchen = (Spinner) findViewById(R.id.spinner_earth_kitchen_item);
        ArrayAdapter itemAdapter_chaeum_coffee= ArrayAdapter.createFromResource(this,
                R.array.spinner_kitchen, android.R.layout.simple_spinner_dropdown_item);
        spinner_earth_kitchen.setAdapter(itemAdapter_chaeum_coffee);
        spinner_earth_kitchen.post(new Runnable() {
            @Override
            public void run() {
                spinner_earth_kitchen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        gram_earth_layout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        //완료버튼
        complete_btn_earth =findViewById(R.id.item_select_complete_earth);

        //그램 스피너
        spinner_earth_gram = (Spinner) findViewById(R.id.spinner_earth_gram);
        ArrayAdapter itemAdapter_gram= ArrayAdapter.createFromResource(this,
                R.array.spinner_g_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_earth_gram.setAdapter(itemAdapter_gram);
        spinner_earth_gram.setSelected(false);
        spinner_earth_gram.post(new Runnable() {
            @Override
            public void run() {
                spinner_earth_gram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        complete_btn_earth.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        complete_btn_earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR_select_earth.this, AR_complete.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.earth_wash:
                earth_wash_bg.setVisibility(View.VISIBLE);
                earth_wash_items.setVisibility(View.VISIBLE);
                earth_wash.setTextColor(Color.parseColor("#EB6446"));

                spinner_earth_kitchen_layout.setVisibility(View.INVISIBLE);
                spinner_earth_scent_layout.setVisibility(View.INVISIBLE);
                gram_earth_layout.setVisibility(View.INVISIBLE);
                complete_btn_earth.setVisibility(View.INVISIBLE);
                break;
            case R.id.earth_wash_scent:
                earth_wash_scent.setTextColor(Color.parseColor("#EB6446"));
                earth_wash_kitchen.setTextColor(Color.parseColor("#505050"));

                spinner_earth_scent_layout.setVisibility(View.VISIBLE);
                spinner_earth_kitchen_layout.setVisibility(View.INVISIBLE);

                gram_earth_layout.setVisibility(View.INVISIBLE);
                complete_btn_earth.setVisibility(View.INVISIBLE);

                break;
            case R.id.earth_wash_kitchen:
                earth_wash_scent.setTextColor(Color.parseColor("#505050"));
                earth_wash_kitchen.setTextColor(Color.parseColor("#EB6446"));

                spinner_earth_scent_layout.setVisibility(View.INVISIBLE);
                spinner_earth_kitchen_layout.setVisibility(View.VISIBLE);

                gram_earth_layout.setVisibility(View.INVISIBLE);
                complete_btn_earth.setVisibility(View.INVISIBLE);

                break;

        }
    }
}