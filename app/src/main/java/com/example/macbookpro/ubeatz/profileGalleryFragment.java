package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.macbookpro.ubeatz.adapter.profileGalleryAdapter;
import com.example.macbookpro.ubeatz.adapter.profileGridViewAdapter;
import com.example.macbookpro.ubeatz.adapter.searchGridViewAdapter;


public class profileGalleryFragment extends Fragment {
    private GridView gv;
    public static String[] gridall = {
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages1.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages2.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages3.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages4.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages5.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages6.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages7.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages8.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages1.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages2.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages3.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages4.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages5.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages6.jpg",
            "http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages7.jpg",
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_gallery, container, false);

        gv=(GridView) view.findViewById(R.id.gridView);
//        gv.setAdapter(new profileGalleryAdapter(getActivity()));
        gv.setAdapter(new searchGridViewAdapter(getActivity(),gridall));

        return view;
    }
}
