package com.example.app01foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSignUp extends AppCompatActivity {

    Button Save_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Save_Button = findViewById(R.id.Save_Button);

        Save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainSignUp.this, MainFood.class);
                startActivity(intent);
            }
        });
    }
}
