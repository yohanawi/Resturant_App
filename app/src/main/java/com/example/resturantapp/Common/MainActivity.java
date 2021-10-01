package com.example.resturantapp.Common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;
import com.example.resturantapp.User.UserdashActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000; //splash time duration

    //veriables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView PandS, theam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.logo);
        PandS = findViewById(R.id.pands);
        theam = findViewById(R.id.resturant);

        image.setAnimation(bottomAnim);
        PandS.setAnimation(topAnim);
        theam.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, UserdashActivity.class); //Go to next activity
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}