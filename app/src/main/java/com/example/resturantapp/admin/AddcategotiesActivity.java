package com.example.resturantapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.resturantapp.R;
import com.example.resturantapp.User.CateSubActivity;
import com.example.resturantapp.User.CategoriesActivity;

public class AddcategotiesActivity extends AppCompatActivity {

    ImageView backbtn;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategoties);

        add = findViewById(R.id.add_new_categories);
        backbtn = findViewById(R.id.add_cate_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddcategotiesActivity.super.onBackPressed();
            }
        });
    }
    public void calladdcategories(View view) {
        Intent intent = new Intent(getApplicationContext(), Pop_cate_add_Activity.class);
        startActivity(intent);
    }
}