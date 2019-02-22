package com.example.macbookpro.ubeatz;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class search extends AppCompatActivity {

    private searchTabViewPagerAdapter mSearchTabViewPagerAdapter;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private ImageView imgView;
    private EditText editts;
    private searchPeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();
//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setTitle(getString(R.string.app_name));
//        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.white)));

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
                    ((TextView) tabViewChild).setTextColor(getResources().getColor(R.color.colorBlue));
                    ((TextView) tabViewChild).setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                }
            }
        }

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        editts = (EditText) findViewById(R.id.editText2);
        editts.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s);
//                if (TextUtils.isEmpty(s)) {
//                    adapter.filter("");
//                    listView.clearTextFilter();
//                } else {
//                    adapter.filter();
//                }
//                return true;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


//        SearchView searchView = (SearchView) findViewById(R.id.action_search);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view_menu_item, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchViewAndroidActionBar.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void setupViewPager(ViewPager viewPager) {
        searchTabViewPagerAdapter adapter = new searchTabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new searchPeopleFragment(),"People");
        adapter.addFragment(new searchSongFragment(),"Song");
        adapter.addFragment(new searchLocationFragment(),"Location");
        adapter.addFragment(new searchUbeatzBoxFragment(),"Ubeatz Box");
        adapter.addFragment(new searchScoresFragment(),"Scores");
        viewPager.setAdapter(adapter);
    }



}
