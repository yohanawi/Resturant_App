package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model;
import com.example.resturantapp.adapters.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class AddcategotiesActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;
    RecyclerView rec_view;
    myadapter adapter;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategoties);

        //Hooks
        backbtn = findViewById(R.id.add_cate_backbtn);
        rec_view=(RecyclerView) findViewById(R.id.rec_view);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddcategotiesActivity.super.onBackPressed();
            }
        }); //back button

        rec_view.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Food"), model.class)
                        .build();

        adapter=new myadapter(options);
        rec_view.setAdapter(adapter);

        fb=(FloatingActionButton) findViewById(R.id.f_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pop_cate_add_Activity.class));
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}