package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;

public class AR_complete extends AppCompatActivity {

    String Bottle_name;
    String Shop_name;

    TextView bottle_name;
    TextView shop_name;
    TextView item_name_txt;
    TextView item_g_txt;

    Button scan_btn;
    Button home_btn;

    ImageView scan_bottle_gram_image;

    String Product_name_1;
    String Product_name_2;
    String Product_name_3;
    String Product_name_4;
    String Product_name_5;
    String Product_name_6;
    String Product_name_7;
    String Product_name_8;
    String Product_name_9;
    String Product_name_10;
    String Product_name_11;
    String Product_name_12;
    String Product_name_13;
    String Product_name_14;
    String Product_name_15;
    String Product_name_16;
    String Gram_name_1;
    String Gram_name_2;
    String Gram_name_3;
    String Gram_name_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_complete);

        bottle_name = findViewById(R.id.bottle_name);
        shop_name = findViewById(R.id.shop_name);
        item_name_txt = findViewById(R.id.item_name_txt);
        item_g_txt = findViewById(R.id.item_g_txt);


        Intent intent = getIntent();

        //용기 이름, 상점 이름 설정
        Bottle_name = intent.getStringExtra("용기이름");
        Shop_name = intent.getStringExtra("상점이름");
        bottle_name.setText(Bottle_name);
        shop_name.setText(Shop_name);

        //용기 이름에 따라 공병 사진 바꾸기
        scan_bottle_gram_image = findViewById(R.id.scan_bottle_gram_image);
        if(bottle_name.getText().toString() == "al_L"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_al_l);
        }
        else if(bottle_name.getText().toString() == "al_M"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_al_m);
        }
        else if(bottle_name.getText().toString() == "al_S"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_al_s);
        }
        else if(bottle_name.getText().toString() == "aro_L"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_aro_l);
        }
        else if(bottle_name.getText().toString() == "aro_s"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_aro_s);
        }
        else if(bottle_name.getText().toString() == "ch_M"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_ch_m);
        }
        else if(bottle_name.getText().toString() == "ear_L"){
            scan_bottle_gram_image.setImageResource(R.drawable.bottle_ear_l);
        }

        //선택한 제품
        Product_name_1 = intent.getStringExtra("알맹 샴푸");
        Product_name_2 = intent.getStringExtra("알맹 컨디셔너");
        Product_name_3 = intent.getStringExtra("알맹 토너");
        Product_name_4 = intent.getStringExtra("알맹 크림");
        Product_name_5 = intent.getStringExtra("알맹 섬유유연제");
        Product_name_6 = intent.getStringExtra("알맹 주방세제");
        Product_name_7 = intent.getStringExtra("알맹 티");
        Product_name_8 = intent.getStringExtra("알맹 커피");
        Product_name_9 = intent.getStringExtra("아로마 샴푸");
        Product_name_10 = intent.getStringExtra("아로마 컨디셔너");
        Product_name_11 = intent.getStringExtra("아로마 토너");
        Product_name_12 = intent.getStringExtra("아로마 크림");
        Product_name_13 = intent.getStringExtra("채움소 티");
        Product_name_14 = intent.getStringExtra("채움소 커피");
        Product_name_15 = intent.getStringExtra("지구샵 섬유유연제");
        Product_name_16 = intent.getStringExtra("지구샵 주방세제");
        //선택한 그램
        Gram_name_1 =intent.getStringExtra("알맹 선택한 그램");
        Gram_name_2 =intent.getStringExtra("아로마 선택한 그램");
        Gram_name_3 =intent.getStringExtra("채움소 선택한 그램");
        Gram_name_4 =intent.getStringExtra("지구샵 선택한 그램");

        //알맹상점
        if(Product_name_1 != null || Product_name_2!=null || Product_name_3 !=null ||Product_name_4 !=null||Product_name_5 !=null||
                Product_name_6 !=null ||Product_name_7 !=null || Product_name_8 !=null){
            item_g_txt.setText(Gram_name_1);
            if(!Product_name_1.equals("선택하세요")){ item_name_txt.setText(Product_name_1); }
            else if(!Product_name_2.equals("선택하세요")){ item_name_txt.setText(Product_name_2); }
            else if(!Product_name_3.equals("선택하세요")){ item_name_txt.setText(Product_name_3); }
            else if(!Product_name_4.equals("선택하세요")){ item_name_txt.setText(Product_name_4); }
            else if(!Product_name_5.equals("선택하세요")){ item_name_txt.setText(Product_name_5); }
            else if(!Product_name_6.equals("선택하세요")){ item_name_txt.setText(Product_name_6); }
            else if(!Product_name_7.equals("선택하세요")){ item_name_txt.setText(Product_name_7); }
            else if(!Product_name_8.equals("선택하세요")){ item_name_txt.setText(Product_name_8); }
        }
        //아로마티카
        else if(Product_name_9 != null || Product_name_10 != null || Product_name_11 != null || Product_name_12 != null){
            item_g_txt.setText(Gram_name_2);
            if(!Product_name_9.equals("선택하세요")){ item_name_txt.setText(Product_name_9); }
            else if(!Product_name_10.equals("선택하세요")){ item_name_txt.setText(Product_name_10); }
            else if(!Product_name_11.equals("선택하세요")){ item_name_txt.setText(Product_name_11); }
            else if(!Product_name_12.equals("선택하세요")){ item_name_txt.setText(Product_name_12); }
        }
        //채움소
        else if(Product_name_13 != null || Product_name_14 !=null){
            item_g_txt.setText(Gram_name_3);
            if(!Product_name_13.equals("선택하세요")){ item_name_txt.setText(Product_name_13); }
            else if(!Product_name_14.equals("선택하세요")){ item_name_txt.setText(Product_name_14); }
        }
        //지구샵
        else  if(Product_name_15 != null || Product_name_16 !=null) {
            item_g_txt.setText(Gram_name_4);
            if(!Product_name_15.equals("선택하세요")){ item_name_txt.setText(Product_name_15); }
            else if(!Product_name_16.equals("선택하세요")){ item_name_txt.setText(Product_name_16); }
        }


        //[다시 선택 버튼]
        scan_btn = findViewById(R.id.scan_btn);
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });


        //[스캔 완료 버튼]
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR_complete.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}