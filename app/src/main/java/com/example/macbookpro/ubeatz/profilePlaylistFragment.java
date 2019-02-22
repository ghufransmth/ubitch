package com.example.macbookpro.ubeatz;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.adapter.profileMyPlaylistAdapter;
import com.example.macbookpro.ubeatz.model.Myplaylist;

import java.util.ArrayList;
import java.util.List;


public class profilePlaylistFragment extends Fragment {

    private static final String TAG = "ListViewActivity";

    private profileMyPlaylistAdapter myplaylistArrayAdapter;
    private ListView listView;

    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_playlist, container, false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        myplaylistArrayAdapter = new profileMyPlaylistAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_profile_playlist);
        listView.setAdapter(myplaylistArrayAdapter);

        List<String[]> myplaylistList = readData();
        for (String[] myplaylistData : myplaylistList) {
            String myplaylistImg = myplaylistData[0];
            String myplaylistName = myplaylistData[1];
            String myplaylistName2 = myplaylistData[2];
            int myplaylistImgResId = getResources().getIdentifier(myplaylistImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Myplaylist myplaylist = new Myplaylist(myplaylistImgResId, myplaylistName, myplaylistName2);
            myplaylistArrayAdapter.add(myplaylist);
        }

        TextView textView16 = (TextView) view.findViewById(R.id.textView16);
        TextView textView17 = (TextView) view.findViewById(R.id.textView17);
        TextView textView18 = (TextView) view.findViewById(R.id.textView18);
        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(getActivity(), R.font.petitamedium);
        textView16.setTypeface(typeface);
        textView17.setTypeface(typeface);
        textView18.setTypeface(typeface);

        return view;
    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();

        String[] myplaylist7 = new String[3];
        myplaylist7[0] = "ic_profile";
        myplaylist7[1] = "Happier";
        myplaylist7[2] = "Marshmello, Bastille";
        resultList.add(myplaylist7);

        String[] myplaylist1 = new String[3];
        myplaylist1[0] = "ic_profile";
        myplaylist1[1] = "I Love It";
        myplaylist1[2] = "Kanye West & Lil Pump";
        resultList.add(myplaylist1);


        String[] myplaylist3 = new String[3];
        myplaylist3[0] = "ic_profile";
        myplaylist3[1] = "Promises";
        myplaylist3[2] = "Calvin Harris, Sam Smith, Jessie J";
        resultList.add(myplaylist3);

        String[] myplaylist4 = new String[3];
        myplaylist4[0] = "ic_profile";
        myplaylist4[1] = "Labirin";
        myplaylist4[2] = "Tulus";
        resultList.add(myplaylist4);

        String[] myplaylist10 = new String[3];
        myplaylist10[0] = "ic_profile";
        myplaylist10[1] = "DDU-DU DDU-DU";
        myplaylist10[2] = "Blackpink";
        resultList.add(myplaylist10);

        String[] myplaylist5 = new String[3];
        myplaylist5[0] = "ic_profile";
        myplaylist5[1] = "Meraih Bintang";
        myplaylist5[2] = "Via Vallen";
        resultList.add(myplaylist5);


        String[] myplaylist2 = new String[3];
        myplaylist2[0] = "ic_profile";
        myplaylist2[1] = "Kependem Tresno";
        myplaylist2[2] = "Waton Guyon";
        resultList.add(myplaylist2);

        String[] myplaylist6 = new String[3];
        myplaylist6[0] = "ic_profile";
        myplaylist6[1] = "Akal Sehat";
        myplaylist6[2] = "Ada Band";
        resultList.add(myplaylist6);

        String[] myplaylist8 = new String[3];
        myplaylist8[0] = "ic_profile";
        myplaylist8[1] = "Satu Senyum Saja";
        myplaylist8[2] = "Letto";
        resultList.add(myplaylist8);

        String[] myplaylist9 = new String[3];
        myplaylist9[0] = "ic_profile";
        myplaylist9[1] = "Rasa Yang Tertinggal";
        myplaylist9[2] = "ST12";
        resultList.add(myplaylist9);

        String[] myplaylist11 = new String[3];
        myplaylist11[0] = "ic_profile";
        myplaylist11[1] = "Apa Kabar Sayang";
        myplaylist11[2] = "Armada";
        resultList.add(myplaylist11);

        return resultList;
    }
}
