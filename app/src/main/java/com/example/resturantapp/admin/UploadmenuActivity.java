package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.ConfoirmActivity;
import com.example.resturantapp.Database.DBdelivery;
import com.example.resturantapp.R;

public class UploadmenuActivity extends AppCompatActivity {

    //variable
    Button confirm;
    ImageView cash_back;
    EditText address, city, city_code, phone;
    DBdelivery DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadmenu);

        //Hooks
        cash_back = findViewById(R.id.address_backbtn);
        confirm = findViewById(R.id.add_address);
        address = (EditText)findViewById(R.id.cash_address);
        city = (EditText)findViewById(R.id.cash_city);
        city_code = (EditText)findViewById(R.id.cash_citycode);
        phone = (EditText)findViewById(R.id.cash_phone);
        DB = new DBdelivery(this);



        cash_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadmenuActivity.super.onBackPressed();
            }
        }); //back button

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Address = address.getText().toString();
                String City = city.getText().toString();
                String citycode = city_code.getText().toString();
                String Phone = phone.getText().toString();

                if(!validatePhoneNumber())
                    Toast.makeText(UploadmenuActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(citycode, Address, City, Phone);
                    if (insert) {
                        Toast.makeText(UploadmenuActivity.this, "inserted successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ConfoirmActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UploadmenuActivity.this, "inserted failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void callcon(View view) {

        if (!validatePhoneNumber()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), ConfoirmActivity.class);
        startActivity(intent);
    }

    //validation
    private boolean validatePhoneNumber() {
        //Get complete phone number
        String val = phone.getText().toString().trim();
        String checknum = "[0-9]{10}";
        if (val.isEmpty()) {
            phone.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checknum)) {
            phone.setError("valid phone !");
            return false;
        }
        return true;
    }      //validate phone number
}