package com.example.wonderv2.Sign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {
    //로그인 하는 화면

    Button mSignInBtn;
    Button mSignUpBtn;
    EditText mEmailText, mPasswordText;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        firebaseAuth = FirebaseAuth.getInstance();
        mEmailText = findViewById(R.id.email_txt);
        mPasswordText = findViewById(R.id.password_txt);

        //회원가입버튼
        mSignUpBtn = (Button) findViewById(R.id.sign_up_btn);
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //용기 스캔 카메라 로 인텐
                Intent intent = new Intent(Sign_in.this,Sign_up.class);
                startActivity(intent);
            }
        });


        //로그인 버튼이 눌리면
        mSignInBtn = (Button)findViewById(R.id.sign_in_btn);
        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailText.getText().toString();
                String pwd = mPasswordText.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(Sign_in.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Sign_in.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}