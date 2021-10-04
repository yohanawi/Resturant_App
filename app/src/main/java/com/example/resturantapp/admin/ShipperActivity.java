package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model2;
import com.example.resturantapp.adapters.myadapter2;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ShipperActivity extends AppCompatActivity {

    //variable
    ImageView Sbackbtn;
    RecyclerView rec_view;
    myadapter2 adapter;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipper);

        //Hooks
        Sbackbtn = findViewById(R.id.shipper_back_btn);
        rec_view=(RecyclerView) findViewById(R.id.rec_view2);

        Sbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShipperActivity.super.onBackPressed();
            }
        }); //back button
        rec_view.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model2> options =
                new FirebaseRecyclerOptions.Builder<model2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Shipper"), model2.class)
                        .build();

        adapter=new myadapter2(options);
        rec_view.setAdapter(adapter);

        fb=(FloatingActionButton) findViewById(R.id.S_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pop_shipper_Activity.class));
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