package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class AddcategotiesActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategoties);

        //Hooks
        add = findViewById(R.id.add_new_categories);
        backbtn = findViewById(R.id.add_cate_backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddcategotiesActivity.super.onBackPressed();
            }
        }); //back button
    }
    public void calladdcategories(View view) {
        Intent intent = new Intent(getApplicationContext(), Pop_cate_add_Activity.class);
        startActivity(intent);
    }
}