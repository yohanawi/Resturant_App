package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.example.resturantapp.User.DashboardActivity;
import com.example.resturantapp.User.UserdashActivity;
import com.example.resturantapp.admin.AdminMainActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class SigninActivity extends AppCompatActivity {

    //variable
    TextInputLayout username, password;
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
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        create = findViewById(R.id.createbtn);
        facebook = findViewById(R.id.facebook_btn);
        login = findViewById(R.id.login_btn);
        google = findViewById(R.id.google_btn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, UserdashActivity.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, AdminMainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(v -> {
            if(Objects.requireNonNull(username.getEditText()).toString().isEmpty()){
                username.setError("Email is Missing");
                return;
            }
            if (Objects.requireNonNull(password.getEditText()).toString().isEmpty()){
                password.setError("Password is Missing");
                return;
            }
            firebaseAuth.signInWithEmailAndPassword(username.getEditText().toString(),password.getEditText().toString()).addOnSuccessListener(authResult -> {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                finish();
            }).addOnFailureListener(e -> Toast.makeText(SigninActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show());
        });

    }

    public void callForgetpassword(View view){
        startActivity(new Intent(getApplicationContext(),ForgetpassActivity.class));
    }
}