package com.example.resturantapp.admin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.Database.dbmanager;
import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model1;
import com.example.resturantapp.adapters.myadapter1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;
    RecyclerView rec_view;
    myadapter1 adapter;
    FloatingActionButton fb;
    ArrayList<model1> dataholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Hooks
        backbtn = findViewById(R.id.add_item_backbtn);
        rec_view=(RecyclerView) findViewById(R.id.rec_view1);
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemActivity.super.onBackPressed();
            }
        }); //back button
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new dbmanager(this).readalldata();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            model1 obj=new model1(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            dataholder.add(obj);
        }

        adapter= new myadapter1(dataholder);
        rec_view.setAdapter(adapter);

        fb=(FloatingActionButton) findViewById(R.id.i_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pop_item_add_Activity.class));
            }
        }); //new add button
    }
}