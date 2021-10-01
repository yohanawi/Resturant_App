package com.example.resturantapp.Common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Model.User;
import com.example.resturantapp.Others.Other;
import com.example.resturantapp.R;
import com.example.resturantapp.User.DashboardActivity;
import com.example.resturantapp.User.UserdashActivity;
import com.example.resturantapp.admin.AdminMainActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        phone = findViewById(R.id.username);
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

        //Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog mDialog = new ProgressDialog(SigninActivity.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.child(phone.getEditText().toString()).exists()) {
                            //get User information
                            mDialog.dismiss();
                            User user = snapshot.child(phone.getEditText().toString()).getValue(User.class);
                            if (user.getPassword().equals(password.getEditText().toString()))
                            {
                                Intent dashboard = new Intent(SigninActivity.this, DashboardActivity.class);
                                Other.currentUser = user;
                                startActivity(dashboard);
                                finish();
                            } else {
                                Toast.makeText(SigninActivity.this, "Sign in failed !!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(SigninActivity.this, "User not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }

    public void callForgetpassword(View view){
        startActivity(new Intent(getApplicationContext(),ForgetpassActivity.class));
    }
}