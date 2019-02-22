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

import com.example.macbookpro.ubeatz.adapter.searchScoresAdapter;
import com.example.macbookpro.ubeatz.adapter.searchSongAdapter;
import com.example.macbookpro.ubeatz.model.Scores;
import com.example.macbookpro.ubeatz.model.Song;

import java.util.ArrayList;
import java.util.List;


public class searchScoresFragment extends Fragment {

    private static final String TAG = "ListViewActivity";

    private searchScoresAdapter scoresArrayAdapter;
    private ListView listView;

    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_scores,container,false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        scoresArrayAdapter = new searchScoresAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_search_scores);
        listView.setAdapter(scoresArrayAdapter);

        List<String[]> scoresList = readData();
        for(String[] scoresData:scoresList ) {
            String scoresImg = scoresData[0];
            String scoresName = scoresData[1];
            int scoresImgResId = getResources().getIdentifier(scoresImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Scores scores = new Scores(scoresImgResId,scoresName);
            scoresArrayAdapter.add(scores);
        }

        return view;
    }

    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] scores7 = new String[3];
        scores7[0] = "ic_profile";
        scores7[1] = "5.000 pts";
        resultList.add(scores7);

        String[] scores1 = new String[3];
        scores1[0] = "ic_profile";
        scores1[1] = "3.000 pts";
        resultList.add(scores1);


        String[] scores3 = new String[3];
        scores3[0] = "ic_profile";
        scores3[1] = "1.000 pts";
        resultList.add(scores3);

        String[] scores4 = new String[3];
        scores4[0] = "ic_profile";
        scores4[1] = "20.000 pts";
        resultList.add(scores4);

        String[] scores10 = new String[3];
        scores10[0] = "ic_profile";
        scores10[1] = "7.000 pts";
        resultList.add(scores10);

        String[] scores5 = new String[3];
        scores5[0] = "ic_profile";
        scores5[1] = "9.000 pts";
        resultList.add(scores5);


        String[] scores2 = new String[3];
        scores2[0] = "ic_profile";
        scores2[1] = "10.000 pts";
        resultList.add(scores2);

        String[] scores6 = new String[3];
        scores6[0] = "ic_profile";
        scores6[1] = "8.000 pts";
        resultList.add(scores6);

        String[] scores8 = new String[3];
        scores8[0] = "ic_profile";
        scores8[1] = "2.000 pts";
        resultList.add(scores8);

        String[] scores9 = new String[3];
        scores9[0] = "ic_profile";
        scores9[1] = "4.000 pts";
        resultList.add(scores9);

        String[] scores11 = new String[3];
        scores11[0] = "ic_profile";
        scores11[1] = "6.000 pts";
        resultList.add(scores11);

        return  resultList;
    }
}