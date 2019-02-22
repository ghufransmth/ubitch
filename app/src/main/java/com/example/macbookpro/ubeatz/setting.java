package com.example.macbookpro.ubeatz;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class setting extends AppCompatActivity {

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().hide();

        TextView textView21 = (TextView) findViewById(R.id.textView21);
        TextView textView22 = (TextView) findViewById(R.id.textView22);
        TextView textView23 = (TextView) findViewById(R.id.textView23);
        TextView textView24 = (TextView) findViewById(R.id.textView24);
        TextView textView25 = (TextView) findViewById(R.id.textView25);
        TextView textView26 = (TextView) findViewById(R.id.textView26);
        TextView textView27 = (TextView) findViewById(R.id.textView27);
        TextView textView28 = (TextView) findViewById(R.id.textView28);
        TextView textView29 = (TextView) findViewById(R.id.textView29);
        TextView textView30 = (TextView) findViewById(R.id.textView30);
        TextView textView31 = (TextView) findViewById(R.id.textView31);
        TextView textView32 = (TextView) findViewById(R.id.textView32);
        TextView textView33 = (TextView) findViewById(R.id.textView33);
        TextView textView34 = (TextView) findViewById(R.id.textView34);
        TextView textView35 = (TextView) findViewById(R.id.textView35);
        TextView textView36 = (TextView) findViewById(R.id.textView36);
        TextView textView37 = (TextView) findViewById(R.id.textView37);
        TextView textView38= (TextView) findViewById(R.id.textView38);
        TextView textView39 = (TextView) findViewById(R.id.textView39);
        TextView textView40 = (TextView) findViewById(R.id.textView40);
        TextView textView41 = (TextView) findViewById(R.id.textView41);
        TextView textView42 = (TextView) findViewById(R.id.textView42);


        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        textView21.setTypeface(typeface2);
        textView22.setTypeface(typeface2);
        textView23.setTypeface(typeface2);
        textView24.setTypeface(typeface2);
        textView25.setTypeface(typeface2);
        textView26.setTypeface(typeface2);
        textView27.setTypeface(typeface2);
        textView28.setTypeface(typeface2);
        textView29.setTypeface(typeface2);
        textView30.setTypeface(typeface2);
        textView31.setTypeface(typeface2);
        textView32.setTypeface(typeface2);
        textView33.setTypeface(typeface2);
        textView34.setTypeface(typeface2);
        textView35.setTypeface(typeface2);
        textView36.setTypeface(typeface2);
        textView37.setTypeface(typeface2);
        textView38.setTypeface(typeface2);
        textView39.setTypeface(typeface2);
        textView40.setTypeface(typeface2);
        textView41.setTypeface(typeface2);
        textView42.setTypeface(typeface2);

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });
    }
}
