package com.example.macbookpro.ubeatz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;

import butterknife.ButterKnife;

public class profileFragment extends Fragment {

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private TextView name,name2,desc,desc2,tvFollowers,tvFollowing,tvPosts,textFollowers,textFollowing,textPosts;
    private Button editprofile,tmessaging,tsetting,tcustomerservice;
    SharedPrefManager sharedPrefManager;
    private int[] tabIcons = {
            R.drawable.ic_icon_ubeatz_blue_02,
            R.drawable.ic_icon_ubeatz_blue_08,
            R.drawable.ic_icon_ubeatz_blue_31,
            R.drawable.ic_icon_ubeatz_blue_05,
            R.drawable.ic_icon_ubeatz_blue_10
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.layout_view_newsfeed,container,false);

        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        mSectionsPageAdapter = new SectionsPageAdapter(getChildFragmentManager());
        mViewPager = (ViewPager) view.findViewById(R.id.container2);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs2);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//getting the fragments position to hide and show the toolbar

                if(position == 0){
                    tabLayout.getTabAt(0).getIcon().setAlpha(255);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 1){
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(255);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 2){
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(255);
                    tabLayout.getTabAt(3).getIcon().setAlpha(100);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 3){
                    tabLayout.getTabAt(0).getIcon().setAlpha(100);
                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
                    tabLayout.getTabAt(2).getIcon().setAlpha(100);
                    tabLayout.getTabAt(3).getIcon().setAlpha(255);
                    tabLayout.getTabAt(4).getIcon().setAlpha(100);
                }
                if(position == 4){
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
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

//        name2.setText(sharedPrefManager.getSpUsername());

        name = (TextView) view.findViewById(R.id.name);
        name2 = (TextView) view.findViewById(R.id.name2);
        desc = (TextView) view.findViewById(R.id.desc);
        desc2 = (TextView) view.findViewById(R.id.desc2);
        tvFollowers = (TextView) view.findViewById(R.id.tvFollowers);
        tvFollowing = (TextView) view.findViewById(R.id.tvFollowing);
        tvPosts = (TextView) view.findViewById(R.id.tvPosts);
        textFollowers = (TextView) view.findViewById(R.id.textFollowers);
        textFollowing = (TextView) view.findViewById(R.id.textFollowing);
        textPosts = (TextView) view.findViewById(R.id.textPosts);
        editprofile = (Button) view.findViewById(R.id.button6);
        tmessaging = (Button) view.findViewById(R.id.button13);
        tsetting = (Button) view.findViewById(R.id.button11);
        tcustomerservice = (Button) view.findViewById(R.id.button10);
        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(getActivity(), R.font.petitamedium);
        name.setTypeface(typeface);
        name2.setTypeface(typeface2);
        desc.setTypeface(typeface2);
        desc2.setTypeface(typeface2);
        tvFollowers.setTypeface(typeface2);
        tvFollowing.setTypeface(typeface2);
        tvPosts.setTypeface(typeface2);
        textFollowers.setTypeface(typeface);
        textFollowing.setTypeface(typeface);
        textPosts.setTypeface(typeface);
        editprofile.setTypeface(typeface);
        tcustomerservice.setTypeface(typeface2);

        //Menampilkan data session
        ButterKnife.bind(getActivity());
        sharedPrefManager = new SharedPrefManager(getActivity());
        name.setText(sharedPrefManager.getSpUsername());
        name2.setText(sharedPrefManager.getSpUsername());

        tvFollowers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(getActivity(),
                        followers.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        tvFollowing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(getActivity(),
                        followingandclosefriend.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        editprofile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(getActivity(),
                        edit_profile.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        tmessaging.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getActivity(),
                        messagingFragment.class);
                startActivity(intent);

            }
        });
        tsetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getActivity(),
                        setting.class);
                startActivity(intent);

            }
        });
        tcustomerservice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getActivity(),
                        customer_service.class);
                startActivity(intent);

            }
        });

        return view;
    }



    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getChildFragmentManager());
        adapter.addFragment(new profileGridviewFragment());
        adapter.addFragment(new profileListviewFragment());
        adapter.addFragment(new profileCloseFriendFragment());
        adapter.addFragment(new profilePlaylistFragment());
        adapter.addFragment(new profileGalleryFragment());
        viewPager.setAdapter(adapter);
    }


}
