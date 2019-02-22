package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.macbookpro.ubeatz.adapter.searchSongAdapter;
import com.example.macbookpro.ubeatz.model.Song;

import java.util.ArrayList;
import java.util.List;


public class searchSongFragment extends Fragment {

    private static final String TAG = "ListViewActivity";

    private searchSongAdapter songArrayAdapter;
    private ListView listView;

    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_song,container,false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        songArrayAdapter = new searchSongAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_search_song);
        listView.setAdapter(songArrayAdapter);

        List<String[]> songList = readData();
        for(String[] songData:songList ) {
            String songImg = songData[0];
            String songName = songData[1];
            int songImgResId = getResources().getIdentifier(songImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Song song = new Song(songImgResId,songName);
            songArrayAdapter.add(song);
        }

        return view;
    }

    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] song7 = new String[3];
        song7[0] = "ic_profile";
        song7[1] = "I like it";
        resultList.add(song7);

        String[] song1 = new String[3];
        song1[0] = "ic_profile";
        song1[1] = "bodak yellow";
        resultList.add(song1);


        String[] song3 = new String[3];
        song3[0] = "ic_profile";
        song3[1] = "24 magic";
        resultList.add(song3);

        String[] song4 = new String[3];
        song4[0] = "ic_profile";
        song4[1] = "ddu-du ddu-du";
        resultList.add(song4);

        String[] song10 = new String[3];
        song10[0] = "ic_profile";
        song10[1] = "muara";
        resultList.add(song10);

        String[] song5 = new String[3];
        song5[0] = "ic_profile";
        song5[1] = "tunggu apa lagi";
        resultList.add(song5);


        String[] song2 = new String[3];
        song2[0] = "ic_profile";
        song2[1] = "cukup tau";
        resultList.add(song2);

        String[] song6 = new String[3];
        song6[0] = "ic_profile";
        song6[1] = "tenda biru";
        resultList.add(song6);

        String[] song8 = new String[3];
        song8[0] = "ic_profile";
        song8[1] = "cinta terlarang";
        resultList.add(song8);

        String[] song9 = new String[3];
        song9[0] = "ic_profile";
        song9[1] = "waton guyon";
        resultList.add(song9);

        String[] song11 = new String[3];
        song11[0] = "ic_profile";
        song11[1] = "I love you bibeh";
        resultList.add(song11);

        return  resultList;
    }
}
