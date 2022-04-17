package com.example.wonderv2.Sign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wonderv2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Sign_up extends AppCompatActivity {
    //가입하는 화면

    private static final String TAG = "Sign_up";
    EditText mEmailText, mPasswordText, mPasswordcheckText, mName;
    Button mSignUpBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);



        //파이어베이스 접근 설
        firebaseAuth = FirebaseAuth.getInstance();

        mEmailText = findViewById(R.id.email_txt);
        mPasswordText = findViewById(R.id.password_txt);
        mPasswordcheckText = findViewById(R.id.password_check_txt);
        mName = findViewById(R.id.name_txt);

        mSignUpBtn = findViewById(R.id.sign_up_btn);

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //가입 정보 가져오기
                final String email = mEmailText.getText().toString().trim();
                String pwd = mPasswordText.getText().toString().trim();
                String pwdcheck = mPasswordcheckText.getText().toString().trim();


                if (pwd.equals(pwdcheck)) {
                    Log.d(TAG, "등록 버튼 " + email + " , " + pwd);
                    final ProgressDialog mDialog = new ProgressDialog(Sign_up.this);
                    mDialog.setMessage("가입중입니다");
                    mDialog.show();

                    //파이어베이스에 신규계정 등록하기
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //가입 성공시
                            if (task.isSuccessful()) {
                                mDialog.dismiss();

                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                String email = user.getEmail();
                                String uid = user.getUid();
                                String name = mName.getText().toString().trim();

                                //해쉬맵 테이블을 파이어베이스 데이터베이스에 저장
                                HashMap<Object, String> hashMap = new HashMap<>();

                                hashMap.put("uid", uid);
                                hashMap.put("email", email);
                                hashMap.put("name", name);

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference reference = database.getReference("Users");
                                reference.child(uid).setValue(hashMap);


                                //가입이 이루어져을시 가입 화면을 빠져나감.
                                Intent intent = new Intent(Sign_up.this, Sign_in.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(Sign_up.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();

                            } else {
                                mDialog.dismiss();
                                Toast.makeText(Sign_up.this, "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                return;  //해당 메소드 진행을 멈추고 빠져나감.

                            }

                        }
                    });

                    //비밀번호 오류시
                } else {

                    Toast.makeText(Sign_up.this, "비밀번호가 틀렸습니다. 다시 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        ; // 뒤로가기 버튼이 눌렸을시
        return super.onSupportNavigateUp(); // 뒤로가기 버튼
    }

}


    /*
    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.sign_up_btn:
                    signUP();
                    break;
            }
        }
    }
    */

    /*
    private void signUP(){
        String mName = ((EditText)findViewById(R.id.name_txt)).getText().toString();
        String mEmail = ((EditText)findViewById(R.id.email_txt)).getText().toString();
        String mPassword = ((EditText)findViewById(R.id.password_txt)).getText().toString();
        String mPassCheck = ((EditText)findViewById(R.id.password_check_txt)).getText().toString();

        if(mName.length()>0 && mEmail.length()>0 && mPassword.length()>0 && mPassCheck.length()>0){
            if(mPassword.equals(mPassCheck)){
                firebaseAuth.createUserWithEmailAndPassword(mEmail, mPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Sign_up.this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if(task.getException().toString() !null){
                                Toast.makeText(Sign_up.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
            else {
                Toast.makeText(Sign_up.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }

        }

        else{
            Toast.makeText(Sign_up.this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
        }

    }
    */

