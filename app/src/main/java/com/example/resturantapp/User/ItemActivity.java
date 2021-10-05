package com.example.resturantapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class ItemActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;
    TextView value;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        //Hooks
        backbtn = findViewById(R.id.item_backbtn);
        value = findViewById(R.id.value);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemActivity.super.onBackPressed();
            }
        }); //back button
    }
    public void calladdtocart(View view) {
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        startActivity(intent);
    }
    public void calldashboard(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }

    //count button
    public void increment(View view){
        count++;
        value.setText(""+count);
    }
    public void decrement(View view){
        if(count <= 0) count = 0;
        else count--;
        value.setText(""+count);
    }
}