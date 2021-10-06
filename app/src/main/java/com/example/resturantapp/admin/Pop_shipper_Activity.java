package com.example.resturantapp.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Database.dbmanager;
import com.example.resturantapp.R;

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
                processinsert(name.getText().toString(),phone.getText().toString(),id.getText().toString(),location.getText().toString());
            }
        });
    }
    private void processinsert(String n, String p, String i, String l)
    {
        String res = new dbmanager(this).addrecord(n,p,i,l);
        name.setText(" ");
        phone.setText(" ");
        id.setText(" ");
        location.setText(" ");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}