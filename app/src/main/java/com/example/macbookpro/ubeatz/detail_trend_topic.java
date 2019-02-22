package com.example.macbookpro.ubeatz;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detail_trend_topic extends AppCompatActivity {

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trend_topic);

        getSupportActionBar().hide();

        TextView desc = (TextView) findViewById(R.id.textView45);
        TextView topic = (TextView) findViewById(R.id.textView5);
        TextView publisher = (TextView) findViewById(R.id.textView43);
        TextView share = (TextView) findViewById(R.id.textView9);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        desc.setTypeface(typeface2);
        publisher.setTypeface(typeface2);
        share.setTypeface(typeface2);
        topic.setTypeface(typeface);
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
