package com.example.resturantapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.resturantapp.Common.SigninActivity;
import com.example.resturantapp.R;
import com.google.android.material.navigation.NavigationView;

public class AdminMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variable
    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView server_navigationView;
    ImageView menuIcon;
    LinearLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        //hooks menu
        drawerLayout = findViewById(R.id.drawer_layout);
        server_navigationView = findViewById(R.id.server_navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);


        navigationDrawer();

    }

    //navigation function
    private void navigationDrawer() {
        server_navigationView.bringToFront();
        server_navigationView.setNavigationItemSelectedListener(this);
        server_navigationView.setCheckedItem(R.id.server_nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }
    private void animateNavigationDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                                           @Override
                                           public void onDrawerSlide(View drawerView, float slideOffset) {
                                               final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                                               final float offsetScale = 1 - diffScaledOffset;
                                               contentView.setScaleX(offsetScale);
                                               contentView.setScaleY(offsetScale);

                                               final float xOffset = drawerView.getWidth() * slideOffset;
                                               final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                                               final float xTranslation = xOffset - xOffsetDiff;
                                               contentView.setTranslationX(xTranslation);
                                           }
                                       }
        );
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.server_nav_categories:
                startActivity(new Intent(getApplicationContext(), AddcategotiesActivity.class));
                break;
            case R.id.server_nav_food:
                startActivity(new Intent(getApplicationContext(), AddItemActivity.class));
                break;
            case R.id.server_nav_profile:
                startActivity(new Intent(getApplicationContext(), SeverproActivity.class));
                break;
            case R.id.server_nav_logout:
                startActivity(new Intent(getApplicationContext(), SigninActivity.class));
                finish();
                Toast.makeText(AdminMainActivity.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
                break;
            case R.id.server_nav_order:
                startActivity(new Intent(getApplicationContext(), OrdersActivity.class));
                break;
            case R.id.server_shipper:
                startActivity(new Intent(getApplicationContext(), ShipperActivity.class));
                break;
        }
        return true;}
}