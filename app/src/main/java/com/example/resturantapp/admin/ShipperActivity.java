package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class ShipperActivity extends AppCompatActivity {

    ImageView Sbackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipper);

        Sbackbtn = findViewById(R.id.shipper_back_btn);
        Sbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShipperActivity.super.onBackPressed();
            }
        });
    }
    public void calladdshipper(View view) {
        Intent intent = new Intent(getApplicationContext(), Pop_shipper_Activity.class);
        startActivity(intent);
    }
}
