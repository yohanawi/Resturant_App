package com.example.resturantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class bottom_sheet_dialog extends AppCompatActivity {

    Button pop;
    EditText cvv, card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_dialog);

       //Hooks
        pop = findViewById(R.id.pop_pay);
        card = findViewById(R.id.D_address);
        cvv = findViewById(R.id.card_cvv);

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bottom_sheet_dialog.this, ConfoirmActivity.class);
                startActivity(intent);
            }
        });
    }
    //validation
    private boolean validatecvvnumber() {
        //Get complete cvv number
        String val = cvv.getText().toString().trim();
        String checknum = "[0-9]{3}";
        if (val.isEmpty()) {
            cvv.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checknum)) {
            cvv.setError("valid cvv number !");
            return false;
        }
        return true;
    }      //validate cvv number

    //validate card number
    private boolean validatecardnumber() {
        //Get complete card number
        String val = card.getText().toString().trim();
        String checknum = "[0-9]{12}";
        if (val.isEmpty()) {
            card.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checknum)) {
            card.setError("valid cvv number !");
            return false;
        }
        return true;
    }
    public void call_card(View view) {
        if (!validatecvvnumber() | !validatecardnumber()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), ConfoirmActivity.class);
        startActivity(intent);
    }
}



