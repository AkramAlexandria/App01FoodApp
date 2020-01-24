package com.example.app01foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainSelection extends AppCompatActivity {

    TextView txtEN, txtAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        txtEN = findViewById(R.id.txtEN);
        txtAR = findViewById(R.id.txtAR);

        txtEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainSelection.this, MainDescription.class);

                startActivity(intent);
            }
        });

        txtAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainSelection.this, MainDescription.class);

                startActivity(intent);
            }
        });
    }
}
