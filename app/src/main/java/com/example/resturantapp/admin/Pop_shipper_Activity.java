package com.example.resturantapp.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Pop_shipper_Activity extends AppCompatActivity {

    //variable
    EditText name, phone, id, location;
    Button add;
    ImageView S_add_backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_shipper);

        //Hooks
        S_add_backbtn = findViewById(R.id.Shipper_add_backbtn);
        name=(EditText) findViewById(R.id.add_name);
        phone=(EditText) findViewById(R.id.add_phone);
        id=(EditText) findViewById(R.id.add_id);
        location=(EditText) findViewById(R.id.add_location);

        S_add_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop_shipper_Activity.super.onBackPressed();
            }
        }); //back button

        add = (Button) findViewById(R.id.add_shipper);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });
    }

    private void processinsert() {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("phone",phone.getText().toString());
        map.put("id",id.getText().toString());
        map.put("location",location.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Shipper").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        name.setText(" ");
                        phone.setText(" ");
                        id.setText(" ");
                        location.setText(" ");
                        Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Could not Inserted", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}