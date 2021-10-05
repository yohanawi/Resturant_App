package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.hbb20.CountryCodePicker;

public class SignupActivity2 extends AppCompatActivity {

    //variable
    ImageView back;
    Button next, login;
    EditText phone;
    CountryCodePicker countryCodePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup2);

        //hooks
        back = findViewById(R.id.signup_backbtn);
        login = (Button)findViewById(R.id.signup_loginbtn);
        next = (Button)findViewById(R.id.signup_nextbtn);
        phone = (EditText)findViewById(R.id.phone_number);
        countryCodePicker = (CountryCodePicker) findViewById(R.id.country_code_picker);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity2.this, SignupActivity1.class);
                startActivity(intent);
            }
        });  // back button

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Phone = phone.getText().toString();
                Intent intent=new Intent(SignupActivity2.this,OtpActivity.class);
                intent.putExtra("mobile",countryCodePicker.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });
    }



    //validation
    private boolean validatePhoneNumber() {
        //Get complete phone number
        String _getUserEnteredPhoneNumber = phone.getText().toString().trim();
//Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
//Complete phone number
        final String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;
        return true;
    }  //validate phone number
}