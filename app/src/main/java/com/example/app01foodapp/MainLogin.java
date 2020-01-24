package com.example.app01foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLogin extends AppCompatActivity {

    Button Get_Started_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Get_Started_Button = findViewById(R.id.Get_Started_Button);

        Get_Started_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this, MainSignIn.class);
                startActivity(intent);
            }
        });
    }
}
