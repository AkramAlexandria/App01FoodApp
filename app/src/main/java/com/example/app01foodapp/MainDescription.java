package com.example.app01foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainDescription extends AppCompatActivity {

    ViewPager vpDescription;
    int[] sliders = {R.layout.activity_slider01, R.layout.activity_slider02, R.layout.activity_slider03, R.layout.activity_slider04};
    AdapterViewPager adaptorViewPager;
    Button btnSkip, btnNext;
    LinearLayout llDotsView;
    ImageView[] dots;
    ClassPreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        if(Build.VERSION.SDK_INT >= 19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else
        {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        vpDescription = findViewById(R.id.vpDescription);
        llDotsView = findViewById(R.id.llDotsView);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);

        adaptorViewPager = new AdapterViewPager(sliders, this);

        vpDescription.setAdapter(adaptorViewPager);

        createDotsLayout(0);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextSlide();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHomeActivity();
                //new ClassPreferenceManager(this).writePreference();
            }
        });

        vpDescription.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float iOffset, int iOffsetPixel)
            {

            }

            @Override
            public void onPageSelected(int i)
            {
                createDotsLayout(i);

                if( i == dots.length )
                {
                    btnNext.setText("Start");
                    btnSkip.setVisibility(View.INVISIBLE);
                }
                else
                {
                    btnNext.setText("Next");
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadHomeActivity()
    {
        startActivity(new Intent(this, MainLogin.class));
        finish();
    }

    private void createDotsLayout(int current_postion)
    {
        if(llDotsView !=  null)
        {
            llDotsView.removeAllViews();
        }

        dots = new ImageView[sliders.length];

        for(int i = 0; i < sliders.length; i++)
        {
            dots[i] = new ImageView(this);

            if( i == current_postion)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(5,0,5,0);

            llDotsView.addView(dots[i], params);
        }
    }

    private void loadNextSlide()
    {
        int next_slide = vpDescription.getCurrentItem()+1;

        if( next_slide <  dots.length )
        {
            vpDescription.setCurrentItem( next_slide );
        }
        else
        {
            loadHomeActivity();
            //new ClassPreferenceManager((View.OnClickListener) this).writePreference();
        }
    }
}
