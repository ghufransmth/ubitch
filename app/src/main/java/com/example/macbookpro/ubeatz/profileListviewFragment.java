package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class profileListviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_listview, container, false);

        TextView username = (TextView) view.findViewById(R.id.username);
        TextView textView6 = (TextView) view.findViewById(R.id.textView6);
        TextView textView7 = (TextView) view.findViewById(R.id.textView7);
        TextView textView9 = (TextView) view.findViewById(R.id.textView9);
        TextView description = (TextView) view.findViewById(R.id.name);
        TextView description2 = (TextView) view.findViewById(R.id.description2);
        TextView comments_link = (TextView) view.findViewById(R.id.comments_link);
        TextView time_posted = (TextView) view.findViewById(R.id.time_posted);
        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(getActivity(), R.font.petitamedium);
        username.setTypeface(typeface);
        textView6.setTypeface(typeface2);
        textView7.setTypeface(typeface2);
        textView9.setTypeface(typeface2);
        description.setTypeface(typeface2);
        description2.setTypeface(typeface2);
        comments_link.setTypeface(typeface2);
        time_posted.setTypeface(typeface2);

        return view;
    }
}
