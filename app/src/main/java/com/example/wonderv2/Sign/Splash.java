package com.example.wonderv2.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        moveMain(1);
    }

    public void moveMain(int sec){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),
                        Sign_in.class);
                startActivity(intent);

                finish();
            }
        }, 1000 *sec);
    }
}