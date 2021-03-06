package com.example.resturantapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class CartActivity extends AppCompatActivity {

    //variable
    ImageView cart_backbtn;
    Button addcart, credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //Hooks
        credit = findViewById(R.id.show_bottom_sheet);
        cart_backbtn = findViewById(R.id.cart_backbtn);
        addcart = findViewById(R.id.add_cart);

        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

        cart_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CartActivity.super.onBackPressed();
            }
        }); // back button
    }

    public void calldashboard(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }  //call home dashboard button
}