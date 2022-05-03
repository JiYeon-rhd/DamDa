package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wonderv2.R;

public class AR_complete extends AppCompatActivity {

    String Bottle_name;
    String Shop_name;

    TextView bottle_name;
    TextView shop_name;
    TextView item_name_txt;
    TextView item_g_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_complete);

        bottle_name = findViewById(R.id.bottle_name);
        shop_name = findViewById(R.id.shop_name);
        item_name_txt = findViewById(R.id.item_name_txt);
        item_g_txt = findViewById(R.id.item_g_txt);


        Intent intent = getIntent();
        Bottle_name = intent.getStringExtra("용기이름");
        Shop_name = intent.getStringExtra("상점이름");

        bottle_name.setText(Bottle_name);
        shop_name.setText(Shop_name);


    }
}