package com.example.wonderv2.Exp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wonderv2.R;

import org.w3c.dom.Text;

public class Exp_detail extends AppCompatActivity {

    TextView detail_dday, detail_product, detail_shop, detail_exp, detail_detail, detail_ingredient, detail_guide;

    String productName, shopName, expDay, dDay, productDetail, productIngredient, productGuide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_detail);

        ImageButton back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView detail_dday = findViewById(R.id.detail_dday);
        TextView detail_product = findViewById(R.id.detail_product);
        TextView detail_shop = findViewById(R.id.detail_shop);
        TextView detail_exp = findViewById(R.id.detail_exp);
        TextView detail_detail = findViewById(R.id.detail_detail);
        TextView detail_ingredient = findViewById(R.id.detail_ingredient);
        TextView detail_guide = findViewById(R.id.detail_guide);

        Intent intent = getIntent();


        detail_dday.setText(intent.getStringExtra("dday"));
        detail_product.setText(intent.getStringExtra("product"));
        detail_shop.setText(intent.getStringExtra("shop"));
        detail_exp.setText(intent.getStringExtra("exp"));
        detail_detail.setText(intent.getStringExtra("detail"));
        detail_ingredient.setText(intent.getStringExtra("ingredient"));
        detail_guide.setText(intent.getStringExtra("guide"));





    }
}