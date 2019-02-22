package com.example.macbookpro.ubeatz;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginandregister extends AppCompatActivity {

    private Button buttonlogin,buttonregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginandregister);
        getSupportActionBar().hide();

        buttonlogin    = (Button) findViewById(R.id.button3);
        buttonregister = (Button) findViewById(R.id.button4);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        buttonlogin.setTypeface(typeface);
        buttonregister.setTypeface(typeface);
        buttonlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(loginandregister.this,
                        login.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        buttonregister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(loginandregister.this,
                        register.class);
                startActivity(intent); // startActivity allow you to move
            }
        });

    }
}
