package com.example.resturantapp.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class Pop_shipper_Activity extends AppCompatActivity {

    //variable
    ImageView S_add_backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_shipper);

        //Hooks
        S_add_backbtn = findViewById(R.id.Shipper_add_backbtn);

        S_add_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop_shipper_Activity.super.onBackPressed();
            }
        }); //back button

    }
}