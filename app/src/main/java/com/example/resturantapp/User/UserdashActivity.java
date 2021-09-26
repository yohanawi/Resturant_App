package com.example.resturantapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Common.SigninActivity;
import com.example.resturantapp.Common.SignupActivity;
import com.example.resturantapp.R;

public class UserdashActivity extends AppCompatActivity {

    //veriables
    Button signin, signup, get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userdash);

        signin = findViewById(R.id.signin_btn);
        signup = findViewById(R.id.signup_btn);
        get = findViewById(R.id.get_btn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserdashActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserdashActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserdashActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}