package com.example.resturantapp.User;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class UserprofileActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        //Hooks
        backbtn = findViewById(R.id.pro_backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserprofileActivity.super.onBackPressed();
            }
        }); //back button
    }
}