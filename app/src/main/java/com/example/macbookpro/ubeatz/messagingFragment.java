package com.example.macbookpro.ubeatz;

import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;

import butterknife.ButterKnife;

public class messagingFragment extends AppCompatActivity {
    ImageView imgView;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_messaging);

        getSupportActionBar().hide();



        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        //Menampilkan data session
        ButterKnife.bind(this);
        TextView txtView44 = (TextView) findViewById(R.id.textView44);
        sharedPrefManager = new SharedPrefManager(this);
        txtView44.setText(sharedPrefManager.getSpUsername());
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        txtView44.setTypeface(typeface);
    }
}
