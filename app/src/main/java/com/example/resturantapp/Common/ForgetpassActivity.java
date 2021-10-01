package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class ForgetpassActivity extends AppCompatActivity {

    //variables
    TextInputLayout Email;
    ImageView back_btn;
    Button next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        //hooks
        Email = findViewById(R.id.forgetEmail);
        back_btn = findViewById(R.id.forget_back);
        next_btn = findViewById(R.id.forgetNext);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(ForgetpassActivity.this, SigninActivity.class);  //page back button
                startActivity(back);
            }
        });
    }
}