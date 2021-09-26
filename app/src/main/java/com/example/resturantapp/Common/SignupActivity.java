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

public class SignupActivity extends AppCompatActivity {

    //variable
    ImageView back_signup;
    Button next;
    TextInputLayout fullName, UserName, Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        back_signup = findViewById(R.id.signup_back_btn);
        next = findViewById(R.id.signup_nextbtn);
        fullName = findViewById(R.id.fullN);
        UserName = findViewById(R.id.userN);
        Email = findViewById(R.id.Remail);
        Password = findViewById(R.id.Repass);

        back_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,UserdashActivity.class);
                startActivity(intent);
            }
        });

    }
    public void callNextSignupScreen(View view){

        if(!validateFullName() | !validateUserName() | !validateEmail() | !validatePassword()){
            return;
        }

        Intent intent = new Intent(getApplicationContext(),SignupActivity1.class);
        startActivity(intent);
    }
    //validate function
    private boolean validateFullName(){
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateUserName(){
        String val = UserName.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\W{1,20}\\z";
        if (val.isEmpty()){
            UserName.setError("Field can not be empty");
            return false;
        } else if (val.length() >20){
            UserName.setError("Username is too large !");
            return false;
        }else {
            UserName.setError(null);
            UserName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEmail(){
        String val = Email.getEditText().getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()){
            Email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkemail)){
            Email.setError("Invalid Email !");
            return false;
        } else {
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatePassword(){
        String val = Password.getEditText().getText().toString().trim();
        String checkpassword= "^" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\s+$)" +
                ".{4,}" +
                "$";
        if (val.isEmpty()){
            Password.setError("Field can not be empty");
            return false;
        }  else {
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }

}