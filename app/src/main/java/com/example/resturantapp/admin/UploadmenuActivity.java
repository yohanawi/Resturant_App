package com.example.resturantapp.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class UploadmenuActivity extends AppCompatActivity {

    //variable
    Button confirm;
    ImageView cash_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadmenu);

        //Hooks
        cash_back = findViewById(R.id.address_backbtn);

        cash_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadmenuActivity.super.onBackPressed();
            }
        }); //back button
    }
}