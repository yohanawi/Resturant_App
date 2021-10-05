package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Database.DBHelper;
import com.example.resturantapp.R;
import com.example.resturantapp.User.UserdashActivity;

public class SignupActivity extends AppCompatActivity {

    //variable
    ImageView back_signup;
    Button next;
    EditText fullName, UserName, Email, Password;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Hooks
        back_signup = findViewById(R.id.signup_back_btn);
        next = findViewById(R.id.signup_nextbtn);
        fullName = findViewById(R.id.fullN);
        UserName = findViewById(R.id.userN);
        Email = findViewById(R.id.Remail);
        Password = findViewById(R.id.Repass);
        DB = new DBHelper(this);


        back_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, UserdashActivity.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = fullName.getText().toString();
                String username = UserName.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if (!validateFullName() | !validateUserName() | !validateEmail() | !validatePassword())

                    Toast.makeText(SignupActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(fullname, username, email, password);
                    if (insert) {
                        Toast.makeText(SignupActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SignupActivity1.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignupActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });

    }


    public void callNextSignupScreen(View view) {

        if (!validateFullName() | !validateUserName() | !validateEmail() | !validatePassword()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), SignupActivity1.class);
        startActivity(intent);
    }

    //validate function
    private boolean validateFullName() {
        String val = fullName.getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            return true;
        }
    } //validate name

    private boolean validateUserName() {
        String val = UserName.getText().toString().trim();
        String checkspaces = "\\A\\W{1,20}\\z";
        if (val.isEmpty()) {
            UserName.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            UserName.setError("Username is too large !");
            return false;
        } else {
            UserName.setError(null);
            return true;
        }
    } //validate user name

    private boolean validateEmail() {
        String val = Email.getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            Email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkemail)) {
            Email.setError("Invalid Email !");
            return false;
        } else {
            Email.setError(null);

            return true;
        }
    } //validate email address

    private boolean validatePassword() {
        String val = Password.getText().toString().trim();
        String checkpassword = "^" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\s+$)" +
                ".{4,}" +
                "$";
        if (val.isEmpty()) {
            Password.setError("Field can not be empty");
            return false;
        } else {
            Password.setError(null);

            return true;
        }
    } //validate password

}