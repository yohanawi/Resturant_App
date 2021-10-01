package com.example.resturantapp.admin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantapp.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Pop_item_add_Activity extends AppCompatActivity {

    //variable
    int SELECT_PHOTO = 1;
    Uri uri;
    ImageView imageView;
    ImageView Ibackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_item_add);

        //Hooks
        Ibackbtn = findViewById(R.id.add_Ibackbtn);
        Button Choose = findViewById(R.id.image_choose_item);
        imageView = findViewById(R.id.item_image);

        Ibackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop_item_add_Activity.super.onBackPressed();
            }
        });

        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PHOTO && requestCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}