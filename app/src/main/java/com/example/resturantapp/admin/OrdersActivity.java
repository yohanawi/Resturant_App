package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.example.resturantapp.User.DashboardActivity;
import com.example.resturantapp.User.UserdashActivity;

public class OrdersActivity extends AppCompatActivity {

    String[] items = {"Order Confirmed", "Processing your Order", "Order is Ready to delivery", "Rider is pickup Order", "Rider is near by your place"};
    ImageView backbtn;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    Button maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_menu,items);
        autoCompleteTextView.setAdapter(adapterItems);
        maps = findViewById(R.id.shipping_map_btn);

        backbtn = findViewById(R.id.order_back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrdersActivity.super.onBackPressed();
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrdersActivity.this, MapsTrackerActivity.class);
                startActivity(intent);
            }
        });
    }
}