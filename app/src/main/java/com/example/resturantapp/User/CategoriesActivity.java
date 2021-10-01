package com.example.resturantapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

public class CategoriesActivity extends AppCompatActivity {

    //Variable
    ImageView backbtn;
    Button categoriesbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        //Hooks
        backbtn = findViewById(R.id.backbtn);
        categoriesbtn = findViewById(R.id.cateP_btn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CategoriesActivity.super.onBackPressed();
            }
        }); //back button

    }

    public void callcategoriesbutton(View view) {
        Intent intent = new Intent(getApplicationContext(), CateSubActivity.class);
        startActivity(intent);
    }
}