package com.example.resturantapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class CateSubActivity extends AppCompatActivity {
    ImageView backbtn;
    Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_sub);

        addbtn = findViewById(R.id.orderbtn);
        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CateSubActivity.super.onBackPressed();
            }
        });
    }
    public void callItemorder(View view) {
        Intent intent = new Intent(getApplicationContext(), ItemActivity.class);
        startActivity(intent);
    }
    public void calldashboard(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}