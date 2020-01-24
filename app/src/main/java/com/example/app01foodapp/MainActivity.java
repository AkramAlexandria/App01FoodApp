package com.example.app01foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgLogo;
    private final int SPLASH_DISPLAY_LENGTH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogo = findViewById(R.id.imgLogo);

        Animation loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_out);
        loadAnimation.setDuration(9000);
        imgLogo.startAnimation(loadAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this, MainSelection.class);
                MainActivity.this.startActivity(i);
                MainActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
