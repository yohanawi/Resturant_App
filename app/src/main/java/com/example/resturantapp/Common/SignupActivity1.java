package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

import java.util.Calendar;

public class SignupActivity1 extends AppCompatActivity {

    //variable
    ImageView back;
    Button next;
    RadioGroup radioGroup;
    RadioButton selectedgender;
    DatePicker age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        //hooks
        back = findViewById(R.id.signup_backbtn);
        next = findViewById(R.id.signup_nextbtn);
        radioGroup = findViewById(R.id.radio_g);
        age = findViewById(R.id.birth);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity1.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    public void call2NextSignupScreen(View view) {

        if (!validateGender() | !validateAge()) {
            return;
        }
        selectedgender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectedgender.getText().toString();

        int day = age.getDayOfMonth();
        int month = age.getMonth();
        int year = age.getYear();

        String _date = day + "/" + month + "/" + year;

        Intent intent = new Intent(getApplicationContext(), SignupActivity2.class);
        startActivity(intent);
    }

    //validation
    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = age.getYear();
        int isAgeValid = currentyear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "you are not eligible tp apply", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}