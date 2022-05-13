package com.example.wonderv2.AR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.airbnb.lottie.LottieAnimationView;
import com.example.wonderv2.R;

public class AR_splash_scan extends Dialog {

    LottieAnimationView scan_animation;
    

    public AR_splash_scan(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ar_splash_scan);


        
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_splash_scan);


        scan_animation = findViewById(R.id.scan_animation);



    }
}