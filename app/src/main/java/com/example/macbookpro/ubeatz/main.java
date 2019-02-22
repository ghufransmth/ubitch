package com.example.macbookpro.ubeatz;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import butterknife.ButterKnife;

public class main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPageAdapter mSectionsPageAdapter;
    private Button button6,findbox,mainmenu,tmessaging;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    private int[] tabIcons = {
            R.drawable.ic_icon_ubeatz_blue_03,
            R.drawable.ic_icon_ubeatz_blue_04,
            R.drawable.ic_icon_ubeatz_blue_06,
            R.drawable.ic_icon_ubeatz_blue_17,
            R.drawable.ic_icon_ubeatz_blue_09
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//getting the fragments position to hide and show the toolbar

                if(position == 0){
                    getSupportActionBar().show();
                    tabLayout.getTabAt(0).getIcon().setAlpha(255);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 1){
                    getSupportActionBar().hide();
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(255);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 2){
                    getSupportActionBar().hide();
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(255);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 3){
                    getSupportActionBar().hide();
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(255);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 4){
                    getSupportActionBar().hide();
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(255);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(mViewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();




//        View view1 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_home);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view1));
//
//        View view2 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_search);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view2));
//
//        View view3 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_focus);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view3));
//
//        View view4 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view4.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_love);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view4));
//
//        View view5 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view5.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_profile);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view5));



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_list_song);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));

        findbox = (Button) findViewById(R.id.button11);
        findbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(main.this,
                        findbox.class);
                startActivity(intent); // startActivity allow you to move
            }
        });

        mainmenu = (Button) findViewById(R.id.button12);
        mainmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Menu m = navigationView .getMenu();
//        for (int i=0;i<m.size();i++) {
//
//            MenuItem mi = m.getItem(i);
//
//            SpannableString s = new SpannableString(mi.getTitle());
//            s.setSpan(typeface2, 0, s.length(),
//                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            mi.setTitle(s);
//
//        }
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new newsfeedFragment());
        adapter.addFragment(new searchFragment());
        adapter.addFragment(new scanqr());
        adapter.addFragment(new searchFragment());
        adapter.addFragment(new profileFragment());
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all) {
            Intent intent = new Intent(main.this,
                    all_song.class);
            startActivity(intent);
        } else if (id == R.id.nav_popular) {
            Intent intent = new Intent(main.this,
                    popular_song.class);
            startActivity(intent);
        } else if (id == R.id.nav_hits) {
            Intent intent = new Intent(main.this,
                    hits_song.class);
            startActivity(intent);
        } else if (id == R.id.nav_new) {
            // Handle the camera action
            Intent intent = new Intent(main.this,
                    new_song.class);
            startActivity(intent);
        } else if (id == R.id.nav_playlist) {
            Intent intent = new Intent(main.this,
                    ubeatz_playlist.class);
            startActivity(intent);
        } else if (id == R.id.nav_category) {
            Intent intent = new Intent(main.this,
                    category.class);
            startActivity(intent);
        } else if (id == R.id.nav_trending) {
            Intent intent = new Intent(main.this,
                    detail_trend_topic.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            sharedPrefManager.saveSPString(SharedPrefManager.SP_ID, "");
            sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, "");
            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
            startActivity(new Intent(main.this, login.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
//        else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
