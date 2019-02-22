package com.example.macbookpro.ubeatz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class followingandclosefriend extends AppCompatActivity {

    private searchTabViewPagerAdapter mSearchTabViewPagerAdapter;
    private ViewPager mViewPager;
    private ImageView imgView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followingandclosefriend);

        getSupportActionBar().hide();

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        mSearchTabViewPagerAdapter = new searchTabViewPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container3);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs3);
        tabLayout.setupWithViewPager(mViewPager);

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(typeface2);
                }
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        searchTabViewPagerAdapter adapter = new searchTabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new followingFragment(),"Following");
        adapter.addFragment(new friendsFragment(),"Close Friends");
        viewPager.setAdapter(adapter);
    }
}
