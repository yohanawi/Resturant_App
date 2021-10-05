package com.example.resturantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfoirmActivity extends AppCompatActivity {
    //variables
    Button okey, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confoirm);

        okey = findViewById(R.id.ok_btn);
        cancel = findViewById(R.id.cancel_btn);

        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfoirmActivity.this, "Okey", Toast.LENGTH_SHORT).show();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancel = new Intent(getApplicationContext(), bottom_sheet_dialog.class);
                startActivity(cancel);
                Toast.makeText(ConfoirmActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
    }
}