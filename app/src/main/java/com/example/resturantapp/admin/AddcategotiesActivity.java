package com.example.resturantapp.admin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.Database.dbcategories;
import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model;
import com.example.resturantapp.adapters.myadapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddcategotiesActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;
    RecyclerView rec_view;
    myadapter adapter;
    FloatingActionButton fb;
    ArrayList<model> dataholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategoties);

        //Hooks
        backbtn = findViewById(R.id.add_cate_backbtn);
        rec_view=(RecyclerView) findViewById(R.id.rec_view);
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddcategotiesActivity.super.onBackPressed();
            }
        }); //back button

        //recycle view
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new dbcategories(this).readalldata();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            model obj=new model(cursor.getString(1),cursor.getString(2));
            dataholder.add(obj);
        }

        adapter=new myadapter(dataholder);
        rec_view.setAdapter(adapter);

        //floting button
        fb=(FloatingActionButton) findViewById(R.id.f_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pop_cate_add_Activity.class));
            }
        });
    }
}