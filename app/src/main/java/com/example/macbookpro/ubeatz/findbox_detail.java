package com.example.macbookpro.ubeatz;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class findbox_detail extends AppCompatActivity {

    EditText addcomment;
    TextView txtView5,txtView6,txtView7,txtView9;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findbox_detail);
        getSupportActionBar().hide();
        addcomment = (EditText) findViewById(R.id.editText3);
        txtView5 = (TextView) findViewById(R.id.textView5);
        txtView6 = (TextView) findViewById(R.id.textView6);
        txtView7 = (TextView) findViewById(R.id.textView7);
        txtView9 = (TextView) findViewById(R.id.textView9);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        addcomment.setTypeface(typeface2);
        txtView5.setTypeface(typeface2);
        txtView6.setTypeface(typeface2);
        txtView7.setTypeface(typeface2);
        txtView9.setTypeface(typeface2);
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
