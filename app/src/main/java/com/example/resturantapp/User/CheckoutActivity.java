package com.example.resturantapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.example.resturantapp.admin.UploadmenuActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CheckoutActivity extends AppCompatActivity {

    //variable
    Button cash_btn, credit_btn;
    ImageView method_back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Hooks
        method_back_btn = findViewById(R.id.payment_method);
        cash_btn = findViewById(R.id.cash_method);
        credit_btn = findViewById(R.id.credit_method);

        method_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckoutActivity.super.onBackPressed();
            }
        });

        credit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CheckoutActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
                bottomSheetDialog.setCanceledOnTouchOutside(false);
                bottomSheetDialog.show();
            }
        });

        cash_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutActivity.this, UploadmenuActivity.class);
                startActivity(intent);
            }
        }
        );
    }
}