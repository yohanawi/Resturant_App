package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.example.resturantapp.User.UserdashActivity;
import com.example.resturantapp.admin.AdminMainActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SigninActivity extends AppCompatActivity {

    //variable
    TextInputLayout phone, password;
    ImageView back;
    Button create, facebook, google, login;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);

        //Hooks
        firebaseAuth = FirebaseAuth.getInstance();

        back = findViewById(R.id.Backbtn);
        phone = findViewById(R.id.user_phone);
        password = findViewById(R.id.password);
        create = findViewById(R.id.createbtn);
        facebook = findViewById(R.id.facebook_btn);
        login = findViewById(R.id.login_btn);
        google = findViewById(R.id.google_btn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(SigninActivity.this, UserdashActivity.class); //back button
                startActivity(back);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class); //create account button
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, AdminMainActivity.class); //facebook login button
                startActivity(intent);
            }
        });

        //Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

    }
    public void callForgetPassword(View view){
        startActivity(new Intent(getApplicationContext(),ForgetpassActivity.class)); //go to forget password inter face
    }
}