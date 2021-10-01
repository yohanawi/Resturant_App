package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Model.User;
import com.example.resturantapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class SignupActivity2 extends AppCompatActivity {

    //variable
    ImageView back;
    Button login;
    TextInputLayout fullName, UserName, Email, Password, phoneNumber;
    CountryCodePicker countryCodePicker;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        //hooks
        back = findViewById(R.id.signup_backbtn);
        login = findViewById(R.id.signup_loginbtn);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);
        fullName = findViewById(R.id.fullN);
        UserName = findViewById(R.id.userN);
        Email = findViewById(R.id.Remail);
        Password = findViewById(R.id.Repass);
        fAuth = FirebaseAuth.getInstance();

        //Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity2.this, SignupActivity1.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child(phoneNumber.getEditText().toString()).exists())
                        {
                            Toast.makeText(SignupActivity2.this, "Register", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            User user = new User(fullName.getEditText().toString(), Password.getEditText().toString());
                            table_user.child(phoneNumber.getEditText().toString()).setValue(user);
                            Toast.makeText(SignupActivity2.this, "Register", Toast.LENGTH_SHORT).show();
                            finish();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }

    public void callVerifyOTP(View view) {

        if (!validatePhoneNumber()) {
            return;
        }
        String _fullName = getIntent().getStringExtra("fullName");
        String _email = getIntent().getStringExtra("Email");
        String _userName = getIntent().getStringExtra("userName");
        String _password = getIntent().getStringExtra("Password");
        String _date = getIntent().getStringExtra("age");
        String _gender = getIntent().getStringExtra("gender");

        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), OtpActivity.class);

        intent.putExtra("fullName", _fullName);
        intent.putExtra("Email", _email);
        intent.putExtra("userName", _userName);
        intent.putExtra("Password", _password);
        intent.putExtra("date", _date);
        intent.putExtra("gender", _gender);
        intent.putExtra("phoneNo", _phoneNo);

        startActivity(intent);
    }

    //validation
    private boolean validatePhoneNumber() {
        //Get complete phone number
        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
//Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
//Complete phone number
        final String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;
        return true;
    }
}