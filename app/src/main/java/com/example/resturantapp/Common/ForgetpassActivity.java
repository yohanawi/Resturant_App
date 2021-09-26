package com.example.resturantapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.resturantapp.R;
import com.example.resturantapp.User.UserdashActivity;
import com.google.android.material.textfield.TextInputLayout;

public class ForgetpassActivity extends AppCompatActivity {
    //variables
    private TextInputLayout Email;
    private ImageView backbtn;
    private Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        //hooks
        Email = findViewById(R.id.forgetEmail);
        backbtn = findViewById(R.id.forgetback);
        nextbtn = findViewById(R.id.forgetNext);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetpassActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }
}