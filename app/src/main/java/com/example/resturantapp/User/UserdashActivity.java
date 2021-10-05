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
import com.example.resturantapp.admin.AdminMainActivity;

public class UserdashActivity extends AppCompatActivity {

    //variables
    Button sign_in, signup, get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userdash);

        //Hooks
        sign_in = findViewById(R.id.signin_btn);
        signup = findViewById(R.id.signup_btn);
        get = findViewById(R.id.get_btn);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signin = new Intent(UserdashActivity.this, SigninActivity.class); //Go to next login page
                startActivity(signin);
            }
        });// sign in button

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(UserdashActivity.this, SignupActivity.class); // Go to next Register page
                startActivity(register);
            }
        });//sign up button

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserdashActivity.this, AdminMainActivity.class);
                startActivity(intent);
            }
        });// admin login button
    }
}