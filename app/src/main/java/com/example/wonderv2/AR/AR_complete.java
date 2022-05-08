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

    TextView bottle_name;
    TextView shop_name;
    TextView item_name_txt;
    TextView item_g_txt;
    TextView item_price_txt;

    TextView price_txt; //측정된 금액은
    TextView max_gram;
    LinearLayout max_gram_layout;
    LinearLayout other_layout;

    Button scan_btn;
    Button home_btn;

    ImageView scan_image;

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

    String Gram_name_5;//알맹상점 400
    String Gram_name_6; //아로마티카 400

    //파이어베이스 연동
    private  FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_complete);

        bottle_name = findViewById(R.id.bottle_name);
        shop_name = findViewById(R.id.shop_name);
        item_name_txt = findViewById(R.id.item_name_txt);
        item_g_txt = findViewById(R.id.item_g_txt);
        scan_image = findViewById(R.id.scan_bottle_gram_image);
        item_price_txt = findViewById(R.id.item_price_txt);
        price_txt = findViewById(R.id.price_txt);
        max_gram= findViewById(R.id.max_gram);
        max_gram_layout = findViewById(R.id.max_gram_layout);
        other_layout = findViewById(R.id.other_layout);


        Intent intent = getIntent();

        //용기 이름, 상점 이름 설정
        Bottle_name = intent.getStringExtra("용기이름");
        Shop_name = intent.getStringExtra("상점이름");
        bottle_name.setText(Bottle_name);
        shop_name.setText(Shop_name);

        //용기이름에 따라 이미지 바꾸기
        if(bottle_name.getText().toString().equals("al_L")){
            scan_image.setImageResource(R.drawable.bottle_al_l);
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
            scan_image.setImageResource(R.drawable.bottle_ch_m);
        }
        else if(bottle_name.getText().toString().equals("ear_L")){
            scan_image.setImageResource(R.drawable.bottle_ear_l);
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
        Gram_name_5 = intent.getStringExtra("알맹 선택한 그램 400");
        Gram_name_6 = intent.getStringExtra("아로마 선택한 그램 400");


        //알맹상점 상품이 선택됐으면
        if(Product_name_1 != null || Product_name_2!=null || Product_name_3 !=null ||Product_name_4 !=null||Product_name_5 !=null||
                Product_name_6 !=null ||Product_name_7 !=null || Product_name_8 !=null){
            if(!Gram_name_1.equals("선택하세요")){
                item_g_txt.setText(Gram_name_1); }
            else if(!Gram_name_5.equals("선택하세요")){
                item_g_txt.setText(Gram_name_5); }

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
            if(!Gram_name_2.equals("선택하세요")){
                item_g_txt.setText(Gram_name_2); }
            else if(!Gram_name_6.equals("선택하세요")){
                item_g_txt.setText(Gram_name_6); }
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

        databaseReference.child("ARCard").child(shop_name).setValue(ar_card_Model);
    }


    public void priceCalculation(){
        //가격 계산
        int gram;
        String Gram = item_g_txt.getText().toString();
        gram = Integer.parseInt(Gram);

        //세제랑 섬유유연제
        if(item_name_txt.getText().toString().equals("에코띠끄 친환경 세탁세제") || item_name_txt.getText().toString().equals("에코띠끄 친환경 섬유유연제")){
            gram = gram * 7;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("유칼립투스향 세탁세제") || item_name_txt.getText().toString().equals("꽃마리 세탹세제")){
            gram = gram * 10;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("인블리스 컨전셔스 섬유유연제")){
            gram = gram * 4;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("시트러스향 섬유유연제")){
            gram = gram * 13;
            item_price_txt.setText(String.valueOf(gram)); }

        //크림이랑 토너
        else if(item_name_txt.getText().toString().equals("팜앤코 수분크림")){
            gram = gram * 180;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("체이싱래빗 말차 크림")){
            gram = gram * 300;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("어성초 토너") || item_name_txt.getText().toString().equals("티오피라 아쿠아샷 토너")){
            gram = gram * 70;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("바이탈라이징 로즈마리 토너")){
            gram = gram * 44;
            item_price_txt.setText(String.valueOf(gram)); }
        //샴푸랑 컨디셔너
        else if(item_name_txt.getText().toString().equals("로즈마리 스칼라 스케일링 샴푸") || item_name_txt.getText().toString().equals("티트리 퓨리파잉 샴푸")){
            gram = gram * 35;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 샴푸") ||
                item_name_txt.getText().toString().equals("로즈마리 헤어 씨크닝 컨디셔너") ||
                item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 컨디셔너")){
            gram = gram * 30;
            item_price_txt.setText(String.valueOf(gram)); }
        //커피랑 차
        else if(item_name_txt.getText().toString().equals("로즈마리") ||
                item_name_txt.getText().toString().equals("페퍼민트") ||
                item_name_txt.getText().toString().equals("카모마일")){
            gram = gram * 200;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("리브레 원두")){
            gram = gram * 45;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("다크 벨벳")){
            gram = gram * 90;
            item_price_txt.setText(String.valueOf(gram)); }
        else if(item_name_txt.getText().toString().equals("커피 원두")){
            gram = gram * 50;
            item_price_txt.setText(String.valueOf(gram)); }
    }


    public void maxPriceCalculation(){
        //가격 계산
        int Maxgram=0;
        int gram=0;
        //String Gram = item_g_txt.getText().toString();
        //gram = Integer.parseInt(Gram);

        if(bottle_name.getText().toString().equals("al_L") ||
                bottle_name.getText().toString().equals("aro_L") ||
                bottle_name.getText().toString().equals("ch_M") ||
                bottle_name.getText().toString().equals("ear_L")){
            Maxgram = 400;
            //세제랑 섬유유연제
            if(item_name_txt.getText().toString().equals("에코띠끄 친환경 세탁세제") || item_name_txt.getText().toString().equals("에코띠끄 친환경 섬유유연제")){
                gram = Maxgram * 7;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("유칼립투스향 세탁세제") || item_name_txt.getText().toString().equals("꽃마리 세탹세제")){
                gram = Maxgram * 10;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("인블리스 컨전셔스 섬유유연제")){
                gram = Maxgram * 4;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("시트러스향 섬유유연제")){
                gram = Maxgram * 13;
                item_price_txt.setText(String.valueOf(gram)); }
            //크림이랑 토너
            else if(item_name_txt.getText().toString().equals("팜앤코 수분크림")){
                gram = Maxgram * 180;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("체이싱래빗 말차 크림")){
                gram = Maxgram * 300;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("어성초 토너") || item_name_txt.getText().toString().equals("티오피라 아쿠아샷 토너")){
                gram = Maxgram * 70;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("바이탈라이징 로즈마리 토너")){
                gram = Maxgram * 44;
                item_price_txt.setText(String.valueOf(gram)); }
            //샴푸랑 컨디셔너
            else if(item_name_txt.getText().toString().equals("로즈마리 스칼라 스케일링 샴푸") || item_name_txt.getText().toString().equals("티트리 퓨리파잉 샴푸")){
                gram = Maxgram * 35;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 샴푸") ||
                    item_name_txt.getText().toString().equals("로즈마리 헤어 씨크닝 컨디셔너") ||
                    item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 컨디셔너")){
                gram = Maxgram * 30;
                item_price_txt.setText(String.valueOf(gram)); }
            //커피랑 차
            else if(item_name_txt.getText().toString().equals("로즈마리") ||
                    item_name_txt.getText().toString().equals("페퍼민트") ||
                    item_name_txt.getText().toString().equals("카모마일")){
                gram = Maxgram * 200;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("리브레 원두")){
                gram = Maxgram * 45;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("다크 벨벳")){
                gram = Maxgram * 90;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("커피 원두")){
                gram = Maxgram * 50;
                item_price_txt.setText(String.valueOf(gram)); }
        }
        else if(bottle_name.getText().toString().equals("al_M")){
            Maxgram = 200;
            //세제랑 섬유유연제
            if(item_name_txt.getText().toString().equals("에코띠끄 친환경 세탁세제") || item_name_txt.getText().toString().equals("에코띠끄 친환경 섬유유연제")){
                gram = Maxgram * 7;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("유칼립투스향 세탁세제") || item_name_txt.getText().toString().equals("꽃마리 세탹세제")){
                gram = Maxgram * 10;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("인블리스 컨전셔스 섬유유연제")){
                gram = Maxgram * 4;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("시트러스향 섬유유연제")){
                gram = Maxgram * 13;
                item_price_txt.setText(String.valueOf(gram)); }
            //크림이랑 토너
            else if(item_name_txt.getText().toString().equals("팜앤코 수분크림")){
                gram = Maxgram * 180;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("체이싱래빗 말차 크림")){
                gram = Maxgram * 300;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("어성초 토너") || item_name_txt.getText().toString().equals("티오피라 아쿠아샷 토너")){
                gram = Maxgram * 70;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("바이탈라이징 로즈마리 토너")){
                gram = Maxgram * 44;
                item_price_txt.setText(String.valueOf(gram)); }
            //샴푸랑 컨디셔너
            else if(item_name_txt.getText().toString().equals("로즈마리 스칼라 스케일링 샴푸") || item_name_txt.getText().toString().equals("티트리 퓨리파잉 샴푸")){
                gram = Maxgram * 35;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 샴푸") ||
                    item_name_txt.getText().toString().equals("로즈마리 헤어 씨크닝 컨디셔너") ||
                    item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 컨디셔너")){
                gram = Maxgram * 30;
                item_price_txt.setText(String.valueOf(gram)); }
            //커피랑 차
            else if(item_name_txt.getText().toString().equals("로즈마리") ||
                    item_name_txt.getText().toString().equals("페퍼민트") ||
                    item_name_txt.getText().toString().equals("카모마일")){
                gram = Maxgram * 200;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("리브레 원두")){
                gram = Maxgram * 45;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("다크 벨벳")){
                gram = Maxgram * 90;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("커피 원두")){
                gram = Maxgram * 50;
                item_price_txt.setText(String.valueOf(gram)); }
        }
        else if(bottle_name.getText().toString().equals("al_s")){
            Maxgram = 100;
            //세제랑 섬유유연제
            if(item_name_txt.getText().toString().equals("에코띠끄 친환경 세탁세제") || item_name_txt.getText().toString().equals("에코띠끄 친환경 섬유유연제")){
                gram = Maxgram * 7;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("유칼립투스향 세탁세제") || item_name_txt.getText().toString().equals("꽃마리 세탹세제")){
                gram = Maxgram * 10;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("인블리스 컨전셔스 섬유유연제")){
                gram = Maxgram * 4;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("시트러스향 섬유유연제")){
                gram = Maxgram * 13;
                item_price_txt.setText(String.valueOf(gram)); }
            //크림이랑 토너
            else if(item_name_txt.getText().toString().equals("팜앤코 수분크림")){
                gram = Maxgram * 180;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("체이싱래빗 말차 크림")){
                gram = Maxgram * 300;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("어성초 토너") || item_name_txt.getText().toString().equals("티오피라 아쿠아샷 토너")){
                gram = Maxgram * 70;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("바이탈라이징 로즈마리 토너")){
                gram = Maxgram * 44;
                item_price_txt.setText(String.valueOf(gram)); }
            //샴푸랑 컨디셔너
            else if(item_name_txt.getText().toString().equals("로즈마리 스칼라 스케일링 샴푸") || item_name_txt.getText().toString().equals("티트리 퓨리파잉 샴푸")){
                gram = Maxgram * 35;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 샴푸") ||
                    item_name_txt.getText().toString().equals("로즈마리 헤어 씨크닝 컨디셔너") ||
                    item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 컨디셔너")){
                gram = Maxgram * 30;
                item_price_txt.setText(String.valueOf(gram)); }
            //커피랑 차
            else if(item_name_txt.getText().toString().equals("로즈마리") ||
                    item_name_txt.getText().toString().equals("페퍼민트") ||
                    item_name_txt.getText().toString().equals("카모마일")){
                gram = Maxgram * 200;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("리브레 원두")){
                gram = Maxgram * 45;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("다크 벨벳")){
                gram = Maxgram * 90;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("커피 원두")){
                gram = Maxgram * 50;
                item_price_txt.setText(String.valueOf(gram)); }
        }
        else if(bottle_name.getText().toString().equals("aro_s")){
            Maxgram = 50;
            //세제랑 섬유유연제
            if(item_name_txt.getText().toString().equals("에코띠끄 친환경 세탁세제") || item_name_txt.getText().toString().equals("에코띠끄 친환경 섬유유연제")){
                gram = Maxgram * 7;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("유칼립투스향 세탁세제") || item_name_txt.getText().toString().equals("꽃마리 세탹세제")){
                gram = Maxgram * 10;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("인블리스 컨전셔스 섬유유연제")){
                gram = Maxgram * 4;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("시트러스향 섬유유연제")){
                gram = Maxgram * 13;
                item_price_txt.setText(String.valueOf(gram)); }
            //크림이랑 토너
            else if(item_name_txt.getText().toString().equals("팜앤코 수분크림")){
                gram = Maxgram * 180;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("체이싱래빗 말차 크림")){
                gram = Maxgram * 300;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("어성초 토너") || item_name_txt.getText().toString().equals("티오피라 아쿠아샷 토너")){
                gram = Maxgram * 70;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("바이탈라이징 로즈마리 토너")){
                gram = Maxgram * 44;
                item_price_txt.setText(String.valueOf(gram)); }
            //샴푸랑 컨디셔너
            else if(item_name_txt.getText().toString().equals("로즈마리 스칼라 스케일링 샴푸") || item_name_txt.getText().toString().equals("티트리 퓨리파잉 샴푸")){
                gram = Maxgram * 35;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 샴푸") ||
                    item_name_txt.getText().toString().equals("로즈마리 헤어 씨크닝 컨디셔너") ||
                    item_name_txt.getText().toString().equals("B5+ 비오틴 포티파잉 컨디셔너")){
                gram = Maxgram * 30;
                item_price_txt.setText(String.valueOf(gram)); }
            //커피랑 차
            else if(item_name_txt.getText().toString().equals("로즈마리") ||
                    item_name_txt.getText().toString().equals("페퍼민트") ||
                    item_name_txt.getText().toString().equals("카모마일")){
                gram = Maxgram * 200;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("리브레 원두")){
                gram = Maxgram * 45;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("다크 벨벳")){
                gram = Maxgram * 90;
                item_price_txt.setText(String.valueOf(gram)); }
            else if(item_name_txt.getText().toString().equals("커피 원두")){
                gram = Maxgram * 50;
                item_price_txt.setText(String.valueOf(gram)); }
        }



    }

    public void priceSet(){
        //가격 계산
        int gram;
        String Gram = item_g_txt.getText().toString();
        gram = Integer.parseInt(Gram);

        //al_L
        if(bottle_name.getText().toString().equals("al_L")){
            if(gram <= 400){
                max_gram_layout.setVisibility(View.GONE);
                other_layout.setVisibility(View.GONE);
                price_txt.setText("측정된 금액은");
                priceCalculation();

            }
            else if(gram > 401){
                max_gram_layout.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.VISIBLE);
                max_gram.setText("400g");
                price_txt.setText("최대용량을 기준으로 측정된 금액은");
                maxPriceCalculation();

            }
        }
        //al_M
        else if(bottle_name.getText().toString().equals("al_M")){
            if(gram <- 200){
                max_gram_layout.setVisibility(View.GONE);
                other_layout.setVisibility(View.GONE);
                price_txt.setText("측정된 금액은");
                priceCalculation();

            }
            else if(gram >201){
                max_gram_layout.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.VISIBLE);
                max_gram.setText("200g");
                price_txt.setText("최대용량을 기준으로 측정된 금액은");
                maxPriceCalculation();
            }

        }
        //al_S
        else if(bottle_name.getText().toString().equals("al_S")){
            if(gram <=100){

                max_gram_layout.setVisibility(View.GONE);
                other_layout.setVisibility(View.GONE);
                price_txt.setText("측정된 금액은");
                priceCalculation();


            }
            else if(gram >101){
                max_gram_layout.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.VISIBLE);
                max_gram.setText("100g");
                price_txt.setText("최대용량을 기준으로 측정된 금액은");
                maxPriceCalculation();

            }

        }
        //aro_L
        else if(bottle_name.getText().toString().equals("aro_L")){
            if(gram <= 400){
                max_gram_layout.setVisibility(View.GONE);
                other_layout.setVisibility(View.GONE);
                price_txt.setText("측정된 금액은");
                priceCalculation();
            }
            else if(gram >401){
                max_gram_layout.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.VISIBLE);
                max_gram.setText("400g");
                price_txt.setText("최대용량을 기준으로 측정된 금액은");
                maxPriceCalculation();

            }

        }
        //aro_S
        else if(bottle_name.getText().toString().equals("aro_s")){
            if(gram <= 50){
                max_gram_layout.setVisibility(View.GONE);
                other_layout.setVisibility(View.GONE);
                price_txt.setText("측정된 금액은");
                priceCalculation();
            }
            else if(gram >51){

                max_gram_layout.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.VISIBLE);
                max_gram.setText("50g");
                price_txt.setText("최대용량을 기준으로 측정된 금액은");
                maxPriceCalculation();
            }

        }
        //ch_M
        else if(bottle_name.getText().toString().equals("ch_M")){
            if( gram <= 400){
                max_gram_layout.setVisibility(View.GONE);
                other_layout.setVisibility(View.GONE);
                price_txt.setText("측정된 금액은");
                priceCalculation();
            }
            else if(gram > 401){

                max_gram_layout.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.VISIBLE);
                max_gram.setText("400g");
                price_txt.setText("최대용량을 기준으로 측정된 금액은");
                maxPriceCalculation();
            }
        }

        //ear_L
        else if(bottle_name.getText().toString().equals("ear_L")){
            priceCalculation();
        }

    }

}