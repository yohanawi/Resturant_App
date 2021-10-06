package com.example.resturantapp.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Database.dbcategories;
import com.example.resturantapp.R;

public class Pop_cate_add_Activity extends AppCompatActivity {

    //variable
    EditText name, purl;
    Button add;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_cate_add);

        //Hooks
        backbtn = findViewById(R.id.add_backbtn);
        name=(EditText) findViewById(R.id.add_name);
        purl=(EditText) findViewById(R.id.add_purl);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop_cate_add_Activity.super.onBackPressed();
            }
        }); //back button

        add = (Button) findViewById(R.id.add_categories);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert(name.getText().toString(),purl.getText().toString());
            }
        });
    }

    private void processinsert(String n, String p)
    {
        String res = new dbcategories(this).addrecord(n,p);
        name.setText("");
        purl.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();



    }
}