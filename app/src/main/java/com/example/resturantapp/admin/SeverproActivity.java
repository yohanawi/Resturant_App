package com.example.resturantapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.resturantapp.R;
import com.example.resturantapp.User.UserprofileActivity;

public class SeverproActivity extends AppCompatActivity {

    ImageView Server_backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_severpro);

        Server_backbtn = findViewById(R.id.Server_pro_backbtn);
        Server_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeverproActivity.super.onBackPressed();
            }
        });
    }
}