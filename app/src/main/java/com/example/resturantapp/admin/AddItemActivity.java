package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class AddItemActivity extends AppCompatActivity {

    //variable
    ImageView Ibackbtn;
    Button addI;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Hooks
        addI = findViewById(R.id.add_new_item);
        btnDelete= (Button)findViewById(R.id.delete);

        Ibackbtn = findViewById(R.id.add_item_backbtn);

        Ibackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemActivity.super.onBackPressed();
            }
        }); //back button
    }

    public void calladditem(View view) {
        Intent intent = new Intent(getApplicationContext(), Pop_item_add_Activity.class);
        startActivity(intent);
    }
}