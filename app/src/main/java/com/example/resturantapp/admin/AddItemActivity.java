package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model1;
import com.example.resturantapp.adapters.myadapter1;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemActivity extends AppCompatActivity {

    //variable
    ImageView backbtn;
    RecyclerView rec_view;
    myadapter1 adapter;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Hooks
        backbtn = findViewById(R.id.add_item_backbtn);
        rec_view=(RecyclerView) findViewById(R.id.rec_view1);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemActivity.super.onBackPressed();
            }
        }); //back button
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model1> options =
                new FirebaseRecyclerOptions.Builder<model1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Item"), model1.class)
                        .build();

        adapter= new myadapter1(options);
        rec_view.setAdapter(adapter);

        fb=(FloatingActionButton) findViewById(R.id.i_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pop_item_add_Activity.class));
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