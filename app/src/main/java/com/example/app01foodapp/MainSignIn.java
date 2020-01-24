package com.example.app01foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSignIn extends AppCompatActivity {

    Button Sign_In_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Sign_In_Button = findViewById(R.id.Sign_In_Button);

        Sign_In_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainSignIn.this, MainSignUp.class);
                startActivity(intent);
            }
        });
    }
}
