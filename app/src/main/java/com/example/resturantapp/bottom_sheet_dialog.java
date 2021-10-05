package com.example.resturantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bottom_sheet_dialog extends AppCompatActivity {

    Button pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_dialog);

       //Hooks
        pop = findViewById(R.id.pop_pay);

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bottom_sheet_dialog.this, ConfoirmActivity.class);
                startActivity(intent);
            }
        });
    }


}
