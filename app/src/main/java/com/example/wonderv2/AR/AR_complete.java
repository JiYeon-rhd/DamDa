package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AR_complete extends AppCompatActivity {

    String Bottle_name;
    String Shop_name;

    TextView shop_name;



    TextView bottle_name;
    TextView item_name_txt;
    TextView item_g_txt;
    TextView item_price_txt;
    ImageView scan_image;

    //스크립트
    TextView bottle_name2;
    TextView item_name_txt2;
    TextView item_g_txt2;
    TextView item_price_txt2;



    Button scan_btn;
    Button home_btn;


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
    String Gram_name_1; //알맹 400
    String Gram_name_2; //알맹 200
    String Gram_name_3; //알맹 100
    String Gram_name_4; //아로마 400
    String Gram_name_5;//아로마 50
    String Gram_name_6; //채움소 400
    String Gram_name_7; //지구샵 400

    //파이어베이스 연동
    private  FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_complete);

        shop_name = findViewById(R.id.shop_name);

        bottle_name = findViewById(R.id.bottle_name);
        item_name_txt = findViewById(R.id.item_name_txt);
        item_g_txt = findViewById(R.id.item_g_txt);
        item_price_txt = findViewById(R.id.item_price_txt);

        scan_image = findViewById(R.id.scan_bottle_gram_image);

        //스크립트
        bottle_name2=findViewById(R.id.bottle_name2);
        item_name_txt2=findViewById(R.id.item_name_txt2);
        item_g_txt2=findViewById(R.id.item_g_txt2);
        item_price_txt2=findViewById(R.id.item_price_txt2);


        Intent intent = getIntent();

        //용기 이름, 상점 이름 설정
        Bottle_name = intent.getStringExtra("용기이름");
        Shop_name = intent.getStringExtra("상점이름");
        shop_name.setText(Shop_name);
        bottle_name.setText(Bottle_name);
        bottle_name2.setText(Bottle_name);


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
        Gram_name_1 =intent.getStringExtra("알맹 선택한 그램 400");
        Gram_name_2 =intent.getStringExtra("알맹 선택한 그램 200");
        Gram_name_3 =intent.getStringExtra("알맹 선택한 그램 50");
        Gram_name_4 =intent.getStringExtra("아로마 선택한 그램 400");
        Gram_name_5 = intent.getStringExtra("아로마 선택한 그램 50");
        Gram_name_6 = intent.getStringExtra("채움소 선택한 그램");
        Gram_name_7 = intent.getStringExtra("지구샵 선택한 그램");


        //알맹상점 상품이 선택됐으면
        if(Product_name_1 != null || Product_name_2!=null || Product_name_3 !=null ||Product_name_4 !=null||Product_name_5 !=null||
                Product_name_6 !=null ||Product_name_7 !=null || Product_name_8 !=null){
            if(!Gram_name_1.equals("선택하세요")){
                item_g_txt.setText(Gram_name_1);
                item_g_txt2.setText(Gram_name_1);}
            else if(!Gram_name_2.equals("선택하세요")){
                item_g_txt.setText(Gram_name_2);
                item_g_txt2.setText(Gram_name_2);}
            else if(!Gram_name_3.equals("선택하세요")){
                item_g_txt.setText(Gram_name_3);
                item_g_txt2.setText(Gram_name_3);}

            if(!Product_name_1.equals("선택하세요")){ item_name_txt.setText(Product_name_1); item_name_txt2.setText(Product_name_1);}
            else if(!Product_name_2.equals("선택하세요")){ item_name_txt.setText(Product_name_2); item_name_txt2.setText(Product_name_2);}
            else if(!Product_name_3.equals("선택하세요")){ item_name_txt.setText(Product_name_3); item_name_txt2.setText(Product_name_3);}
            else if(!Product_name_4.equals("선택하세요")){ item_name_txt.setText(Product_name_4); item_name_txt2.setText(Product_name_4);}
            else if(!Product_name_5.equals("선택하세요")){ item_name_txt.setText(Product_name_5); item_name_txt2.setText(Product_name_5);}
            else if(!Product_name_6.equals("선택하세요")){ item_name_txt.setText(Product_name_6); item_name_txt2.setText(Product_name_6);}
            else if(!Product_name_7.equals("선택하세요")){ item_name_txt.setText(Product_name_7); item_name_txt2.setText(Product_name_7);}
            else if(!Product_name_8.equals("선택하세요")){ item_name_txt.setText(Product_name_8); item_name_txt2.setText(Product_name_8);}
        }

        //아로마티카
        else if(Product_name_9 != null || Product_name_10 != null || Product_name_11 != null || Product_name_12 != null){
            if(!Gram_name_4.equals("선택하세요")){
                item_g_txt.setText(Gram_name_4);
                item_g_txt2.setText(Gram_name_4);}
            else if(!Gram_name_5.equals("선택하세요")){
                item_g_txt.setText(Gram_name_5);
                item_g_txt2.setText(Gram_name_5);}
            if(!Product_name_9.equals("선택하세요")){ item_name_txt.setText(Product_name_9); item_name_txt2.setText(Product_name_9);}
            else if(!Product_name_10.equals("선택하세요")){ item_name_txt.setText(Product_name_10); item_name_txt2.setText(Product_name_10);}
            else if(!Product_name_11.equals("선택하세요")){ item_name_txt.setText(Product_name_11); item_name_txt2.setText(Product_name_11);}
            else if(!Product_name_12.equals("선택하세요")){ item_name_txt.setText(Product_name_12); item_name_txt2.setText(Product_name_12);}
        }
        //채움소
        else if(Product_name_13 != null || Product_name_14 !=null){
            item_g_txt.setText(Gram_name_6);
            item_g_txt2.setText(Gram_name_6);
            if(!Product_name_13.equals("선택하세요")){ item_name_txt.setText(Product_name_13); item_name_txt2.setText(Product_name_13);}
            else if(!Product_name_14.equals("선택하세요")){ item_name_txt.setText(Product_name_14); item_name_txt2.setText(Product_name_14);}
        }
        //지구샵
        else  if(Product_name_15 != null || Product_name_16 !=null) {
            item_g_txt.setText(Gram_name_7);
            item_g_txt2.setText(Gram_name_7);
            if(!Product_name_15.equals("선택하세요")){ item_name_txt.setText(Product_name_15); item_name_txt2.setText(Product_name_16);}
            else if(!Product_name_16.equals("선택하세요")){ item_name_txt.setText(Product_name_16); item_name_txt2.setText(Product_name_15);}
        }

        //용기이름과 그램수에 따라 이미지 바꾸기
        if(bottle_name.getText().toString().equals("al_L")){
            if(item_g_txt.getText().toString().equals("400")){
                scan_image.setImageResource(R.drawable.bottle_al_l_400g); }
            else if(item_g_txt.getText().toString().equals("350")){
                scan_image.setImageResource(R.drawable.bottle_al_l_350g); }
            else if(item_g_txt.getText().toString().equals("300")){
                scan_image.setImageResource(R.drawable.bottle_al_l_300g); }
            else if(item_g_txt.getText().toString().equals("250")){
                scan_image.setImageResource(R.drawable.bottle_al_l_250g); }
            else if(item_g_txt.getText().toString().equals("200")){
                scan_image.setImageResource(R.drawable.bottle_al_l_200g); }
            else if(item_g_txt.getText().toString().equals("150")){
                scan_image.setImageResource(R.drawable.bottle_al_l_150g); }
            else if(item_g_txt.getText().toString().equals("100")){
                scan_image.setImageResource(R.drawable.bottle_al_l_100g); }
            else if(item_g_txt.getText().toString().equals("50")){
                scan_image.setImageResource(R.drawable.bottle_al_l_50g); }
        }
        else if(bottle_name.getText().toString().equals("al_M")){
            scan_image.setImageResource(R.drawable.bottle_al_m);
        }
        else if(bottle_name.getText().toString().equals("al_S")){
            scan_image.setImageResource(R.drawable.bottle_al_s);
        }
        else if(bottle_name.getText().toString().equals("aro_L")){
            scan_image.setImageResource(R.drawable.bottle_aro_l);
        }
        else if(bottle_name.getText().toString().equals("aro_s")){
            scan_image.setImageResource(R.drawable.bottle_aro_s);
        }
        else if(bottle_name.getText().toString().equals("ch_M")){
            if(item_g_txt.getText().toString().equals("400")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_400g); }
            else if(item_g_txt.getText().toString().equals("350")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_350g); }
            else if(item_g_txt.getText().toString().equals("300")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_300g); }
            else if(item_g_txt.getText().toString().equals("250")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_250g); }
            else if(item_g_txt.getText().toString().equals("200")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_200g); }
            else if(item_g_txt.getText().toString().equals("150")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_150g); }
            else if(item_g_txt.getText().toString().equals("100")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_100g); }
            else if(item_g_txt.getText().toString().equals("50")){
                scan_image.setImageResource(R.drawable.bottle_ch_l_50g);}
        }
        else if(bottle_name.getText().toString().equals("ear_L")){
            scan_image.setImageResource(R.drawable.bottle_ear_l);
        }

        priceSet();

        //[다시 선택 버튼]
        scan_btn = findViewById(R.id.scan_btn);
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });


        //[스캔 완료 버튼] 파이어 베이스에 정보 넘기기
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR_complete.this, MainActivity.class);

                addARCard(shop_name.getText().toString(), item_name_txt.getText().toString(),
                        item_g_txt.getText().toString(), item_price_txt.getText().toString());


                startActivity(intent);
            }
        });

    }

    //파이어베이스 리얼파이 데베로 넘기는 함수
    public void addARCard(String shop_name, String item_name, String item_gram, String item_price){
        AR_card_model ar_card_Model = new AR_card_model(shop_name, item_name, item_gram, item_price);

        databaseReference.child("ARCard").push().setValue(ar_card_Model);
    }


    public void priceCalculation(){
        //가격 계산
        int gram;
        String Gram = item_g_txt.getText().toString();
        gram = Integer.parseInt(Gram);

        //세제랑 섬유유연제
        if(item_name_txt.getText().toString().equals("에코띠끄 친환경 세탁세제") || item_name_txt.getText().toString().equals("에코띠끄 친환경 섬유유연제")){
            gram = gram * 7;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("유칼립투스향 세탁세제") || item_name_txt.getText().toString().equals("꽃마리 세탹세제")){
            gram = gram * 10;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("인블리스 컨전셔스 섬유유연제")){
            gram = gram * 4;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("시트러스향 섬유유연제")){
            gram = gram * 13;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}

        //크림이랑 토너
        else if(item_name_txt.getText().toString().equals("팜앤코 수분크림")){
            gram = gram * 180;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("체이싱래빗 말차 크림")){
            gram = gram * 300;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("어성초 토너") || item_name_txt.getText().toString().equals("티오피라 아쿠아샷 토너")){
            gram = gram * 70;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("바이탈라이징 로즈마리 토너")){
            gram = gram * 44;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        //샴푸랑 컨디셔너
        else if(item_name_txt.getText().toString().equals("로즈마리 스칼라 스케일링 샴푸") || item_name_txt.getText().toString().equals("티트리 퓨리파잉 샴푸")){
            gram = gram * 35;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 샴푸") ||
                item_name_txt.getText().toString().equals("로즈마리 헤어 씨크닝 컨디셔너") ||
                item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 컨디셔너")){
            gram = gram * 30;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        //커피랑 차
        else if(item_name_txt.getText().toString().equals("로즈마리") ||
                item_name_txt.getText().toString().equals("페퍼민트") ||
                item_name_txt.getText().toString().equals("카모마일")){
            gram = gram * 200;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("리브레 원두")){
            gram = gram * 45;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("다크 벨벳")){
            gram = gram * 90;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
        else if(item_name_txt.getText().toString().equals("커피 원두")){
            gram = gram * 50;
            item_price_txt.setText(String.valueOf(gram));
            item_price_txt2.setText(String.valueOf(gram));}
    }



    public void priceSet(){
        //가격 계산
        int gram;
        String Gram = item_g_txt.getText().toString();
        gram = Integer.parseInt(Gram);

        //al_L
        if(bottle_name.getText().toString().equals("al_L")){
            if(gram <= 400){
                priceCalculation();
            }

        }
        //al_M
        else if(bottle_name.getText().toString().equals("al_M")){
            if(gram <- 200){
                priceCalculation();
            }


        }
        //al_S
        else if(bottle_name.getText().toString().equals("al_S")){
            if(gram <=100){
                priceCalculation();
            }

        }
        //aro_L
        else if(bottle_name.getText().toString().equals("aro_L")){
            if(gram <= 400){
                priceCalculation();
            }


        }
        //aro_S
        else if(bottle_name.getText().toString().equals("aro_s")){
            if(gram <= 50){
                priceCalculation();
            }

        }
        //ch_M
        else if(bottle_name.getText().toString().equals("ch_M")){
            if( gram <= 400){
                priceCalculation();
            }

        }

        //ear_L
        else if(bottle_name.getText().toString().equals("ear_L")){
            priceCalculation();
        }

    }

}