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

public class Pop_item_add_Activity extends AppCompatActivity {

    //variable
    EditText name, price, description, purl;
    Button add;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_item_add);

        //Hooks
        backbtn = findViewById(R.id.add_Ibackbtn);
        name=(EditText) findViewById(R.id.add_name);
        price=(EditText) findViewById(R.id.add_price);
        description=(EditText) findViewById(R.id.add_description);
        purl=(EditText) findViewById(R.id.add_purl);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop_item_add_Activity.super.onBackPressed();
            }
        }); //back button

        add = (Button) findViewById(R.id.add_item);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert(name.getText().toString(),price.getText().toString(),description.getText().toString(),purl.getText().toString());
            }
        });
    }

    private void processinsert(String n, String P, String d, String p)
    {
        String res = new dbmanager(this).addrecord(n,P,d,p);
        name.setText("");
        price.setText("");
        description.setText("");
        purl.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();



    }
}