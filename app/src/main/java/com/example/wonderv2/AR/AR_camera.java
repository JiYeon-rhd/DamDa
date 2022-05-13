package com.example.wonderv2.AR;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.media.MediaSession2Service;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.example.wonderv2.ml.BottleModel;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.schema.Model;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Struct;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class AR_camera extends AppCompatActivity {
    private static int TIME_OUT = 1001;
    MainActivity activity;

    LinearLayout before_scan_layout;
    Button scan_btn;

    LinearLayout success_scan_layout;
    ImageView bottle_image;
    ImageView scan_bottle_image;
    TextView bottle_name_txt;
    TextView shop_name_txt;
    Button item_select_btn;
    Button re_scan_btn;

    AR_splash_scan ar_splash_scan;

    LinearLayout layout_bg;

    public int itemG =0;
    public String itemName_earth_detergent;
    public String itemName_ch_tea;
    public String itemName_ch_coffee;
    int imageSize = 224;

    private AR_main ar_main;
    private FragmentManager fm;
    private FragmentTransaction ft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_camera);

        before_scan_layout = findViewById(R.id.before_scan_layout);
        scan_btn = findViewById(R.id.scan_btn);


        success_scan_layout = findViewById(R.id.success_scan_layout);
        bottle_image= findViewById(R.id.bottle_image);
        scan_bottle_image=findViewById(R.id.scan_bottle_image);
        bottle_name_txt=findViewById(R.id.bottle_name_txt);
        shop_name_txt=findViewById(R.id.shop_name_txt);
        item_select_btn=findViewById(R.id.item_select_btn);
        re_scan_btn=findViewById(R.id.re_scan_btn);

        layout_bg = findViewById(R.id.layout_bg);

        ar_main = new AR_main();

        //스플래시 화면 설정
        ar_splash_scan = new AR_splash_scan(this);
        ar_splash_scan.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ar_splash_scan.setCancelable(false);
        ar_splash_scan.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        ar_splash_scan.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams params = ar_splash_scan.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        ar_splash_scan.getWindow().setAttributes(params);




        //스캔 시작 버튼을 누르면 카메라 실행
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1);
                }
                else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},100);
                }



            }

        });

        //[제품 선택 버튼] 누루면 상점 이름에 따라 액티비티 인텐트
        item_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shop_name_txt.getText().toString() == "알맹상점"){
                    Intent intent = new Intent(AR_camera.this, AR_select_almaeng.class);

                    intent.putExtra("상점이름", shop_name_txt.getText().toString());
                    intent.putExtra("용기이름", bottle_name_txt.getText().toString());

                    startActivity(intent);
                }
                else if(shop_name_txt.getText().toString() == "아로마티카"){
                    Intent intent = new Intent(AR_camera.this, AR_select_aromatica.class);

                    intent.putExtra("상점이름", shop_name_txt.getText().toString());
                    intent.putExtra("용기이름", bottle_name_txt.getText().toString());

                    startActivity(intent);
                }
                else if(shop_name_txt.getText().toString() == "채움소"){
                    Intent intent = new Intent(AR_camera.this, AR_select_chaeum.class);

                    intent.putExtra("상점이름", shop_name_txt.getText().toString());
                    intent.putExtra("용기이름", bottle_name_txt.getText().toString());

                    startActivity(intent);
                }
                else if(shop_name_txt.getText().toString() == "지구샵"){
                    Intent intent = new Intent(AR_camera.this, AR_select_earth.class);

                    intent.putExtra("상점이름", shop_name_txt.getText().toString());
                    intent.putExtra("용기이름", bottle_name_txt.getText().toString());

                    startActivity(intent);
                }
            }
        });

        //[다시 선택 버튼]을 누르면 카메라 실행
        re_scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1);
                }
                else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},100);
                }
            }
        });

    }


    //이미지 분류 모델
    public void classifyImage(Bitmap image) {
        try {
            BottleModel model = BottleModel.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            for (int i = 0; i < imageSize; i++) {
                for (int j = 0; j < imageSize; j++) {
                    int val = intValues[pixel++]; //RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF)*(1.f / 255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF)*(1.f / 255.f));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 255.f));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            BottleModel.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos = 0;
            float maxConfidence = 0;
            for(int i =0; i<confidences.length; i++){
                if(confidences[i] > maxConfidence){
                    maxConfidence = confidences[i];
                    maxPos=i;
                }
            }

            //공병 이름들
            String[] classes = {"al_L", "al_M", "al_S", "aro_L", "aro_s", "ch_M", "ear_L"};
            bottle_name_txt.setText(classes[maxPos]);
            //bottle_name_fail.setText(classes[maxPos]);

            //공병 이름에 따라 상점 이름 바꾸기
            if(bottle_name_txt.getText().toString() == "al_L"){
                shop_name_txt.setText("알맹상점");
                scan_bottle_image.setImageResource(R.drawable.bottle_al_l);
            }
            else if(bottle_name_txt.getText().toString() == "al_M"){
                shop_name_txt.setText("알맹상점");
                scan_bottle_image.setImageResource(R.drawable.bottle_al_m);
            }
            else if(bottle_name_txt.getText().toString() == "al_S"){
                shop_name_txt.setText("알맹상점");
                scan_bottle_image.setImageResource(R.drawable.bottle_al_s);
            }
            else if(bottle_name_txt.getText().toString() == "aro_L"){
                shop_name_txt.setText("아로마티카");
                scan_bottle_image.setImageResource(R.drawable.bottle_aro_l);
            }
            else if(bottle_name_txt.getText().toString() == "aro_s"){
                shop_name_txt.setText("아로마티카");
                scan_bottle_image.setImageResource(R.drawable.bottle_aro_s);
            }
            else if(bottle_name_txt.getText().toString() == "ch_M"){
                shop_name_txt.setText("채움소");
                scan_bottle_image.setImageResource(R.drawable.bottle_ch_m);
            }
            else if(bottle_name_txt.getText().toString() == "ear_L"){
                shop_name_txt.setText("지구샵");
                scan_bottle_image.setImageResource(R.drawable.bottle_ear_l);
            }


            //정확도 측정
            String s ="";
            for(int i = 0; i <classes.length; i++){
                s += String.format("%s: %.1f%%\n", classes[i], confidences[i] * 100);
            }

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }
    }


    //카메라 실행 종료 후 나올 화면
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            int dimension = Math.min(image.getWidth(), image.getHeight());
            image = rotataeImage(image, 90);
            image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);

            bottle_image.setImageBitmap(image);

            image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);

            before_scan_layout.setVisibility(View.INVISIBLE);

            //스캔 스플래시 보여주기
            ar_splash_scan.show();

            //스캔 스플래시 몇 초 후에 종료
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            ar_splash_scan.dismiss();
                        }
                    };

                    Timer timer = new Timer();
                    timer.schedule(task, 4500);
                }
            });
            thread.start();


            classifyImage(image);
            success_scan_layout.setVisibility(View.VISIBLE);
            layout_bg.setBackgroundResource(R.drawable.bg_image);

        }
        super.onActivityResult(requestCode, resultCode, data);

    }


    //이미지 돌아가기 방지
    public static Bitmap rotataeImage(Bitmap source, float angle){
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0,0,source.getWidth(), source.getHeight(), matrix, true);
    }



}