package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.Database.DBHelper;
import com.example.resturantapp.R;
import com.example.resturantapp.User.DashboardActivity;
import com.example.resturantapp.User.UserdashActivity;
import com.example.resturantapp.admin.AdminMainActivity;

public class SigninActivity extends AppCompatActivity {

    //variable
    EditText username, password;
    ImageView back;
    Button create, facebook, google, login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);

        //Hooks
        DB = new DBHelper(this);

        back = findViewById(R.id.Backbtn);
        username = findViewById(R.id.user_username);
        password = findViewById(R.id.password);
        create = findViewById(R.id.createbtn);
        facebook = findViewById(R.id.facebook_btn);
        login = findViewById(R.id.login_btn);
        google = findViewById(R.id.google_btn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(SigninActivity.this, UserdashActivity.class); //back button
                startActivity(back);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class); //create account button
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(SigninActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(SigninActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SigninActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, AdminMainActivity.class); //facebook login button
                startActivity(intent);
            }
        });

    }
    public void callForgetPassword(View view){
        startActivity(new Intent(getApplicationContext(),ForgetpassActivity.class)); //go to forget password inter face
    }
}