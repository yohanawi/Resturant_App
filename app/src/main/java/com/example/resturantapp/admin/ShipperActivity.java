package com.example.resturantapp.admin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.Database.dbship;
import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model2;
import com.example.resturantapp.adapters.myadapter2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ShipperActivity extends AppCompatActivity {

    //variable
    ImageView Sbackbtn;
    RecyclerView rec_view;
    myadapter2 adapter;
    FloatingActionButton fb;
    ArrayList<model2> dataholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipper);

        //Hooks
        Sbackbtn = findViewById(R.id.shipper_back_btn);
        rec_view=(RecyclerView) findViewById(R.id.rec_view2);
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        Sbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShipperActivity.super.onBackPressed();
            }
        }); //back button
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new dbship(this).readalldata();
        dataholder=new ArrayList<model2>();

        while(cursor.moveToNext())
        {
            model2 obj=new model2(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            dataholder.add(obj);
        }
        adapter=new myadapter2(dataholder);
        rec_view.setAdapter(adapter);

        fb=(FloatingActionButton) findViewById(R.id.S_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pop_shipper_Activity.class));
            }
        });
    }
}