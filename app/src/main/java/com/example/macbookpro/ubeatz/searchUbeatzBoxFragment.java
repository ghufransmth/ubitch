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
import com.example.macbookpro.ubeatz.adapter.searchUbeatzboxAdapter;
import com.example.macbookpro.ubeatz.model.Song;
import com.example.macbookpro.ubeatz.model.Ubeatzbox;

import java.util.ArrayList;
import java.util.List;


public class searchUbeatzBoxFragment extends Fragment {
    private static final String TAG = "ListViewActivity";

    private searchUbeatzboxAdapter ubeatzboxArrayAdapter;
    private ListView listView;

    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_ubeatz_box,container,false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        ubeatzboxArrayAdapter = new searchUbeatzboxAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_search_ubeatz_box);
        listView.setAdapter(ubeatzboxArrayAdapter);

        List<String[]> ubeatzboxList = readData();
        for(String[] ubeatzboxData:ubeatzboxList ) {
            String ubeatzboxImg = ubeatzboxData[0];
            String ubeatzboxName = ubeatzboxData[1];
            int ubeatzboxImgResId = getResources().getIdentifier(ubeatzboxImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Ubeatzbox ubeatzbox = new Ubeatzbox(ubeatzboxImgResId,ubeatzboxName);
            ubeatzboxArrayAdapter.add(ubeatzbox);
        }

        return view;
    }

    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] ubeatzbox7 = new String[3];
        ubeatzbox7[0] = "ic_profile";
        ubeatzbox7[1] = "Ubeatz Box Alam Sutera";
        resultList.add(ubeatzbox7);

        String[] ubeatzbox1 = new String[3];
        ubeatzbox1[0] = "ic_profile";
        ubeatzbox1[1] = "Ubeatz Box Makassar";
        resultList.add(ubeatzbox1);


        String[] ubeatzbox3 = new String[3];
        ubeatzbox3[0] = "ic_profile";
        ubeatzbox3[1] = "Ubeatz Box Manado";
        resultList.add(ubeatzbox3);

        String[] ubeatzbox4 = new String[3];
        ubeatzbox4[0] = "ic_profile";
        ubeatzbox4[1] = "Ubeatz Box Alam Sutera";
        resultList.add(ubeatzbox4);

        String[] ubeatzbox10 = new String[3];
        ubeatzbox10[0] = "ic_profile";
        ubeatzbox10[1] = "Ubeatz Box Tangerang";
        resultList.add(ubeatzbox10);

        String[] ubeatzbox5 = new String[3];
        ubeatzbox5[0] = "ic_profile";
        ubeatzbox5[1] = "Ubeatz Box Tanjung Duren";
        resultList.add(ubeatzbox5);


        String[] ubeatzbox2 = new String[3];
        ubeatzbox2[0] = "ic_profile";
        ubeatzbox2[1] = "Ubeatz Box Alam Sutera";
        resultList.add(ubeatzbox2);

        String[] ubeatzbox6 = new String[3];
        ubeatzbox6[0] = "ic_profile";
        ubeatzbox6[1] = "Ubeatz Box Semarang";
        resultList.add(ubeatzbox6);

        String[] ubeatzbox8 = new String[3];
        ubeatzbox8[0] = "ic_profile";
        ubeatzbox8[1] = "Ubeatz Box Purwakarta";
        resultList.add(ubeatzbox8);

        String[] ubeatzbox9 = new String[3];
        ubeatzbox9[0] = "ic_profile";
        ubeatzbox9[1] = "Ubeatz Box Solo";
        resultList.add(ubeatzbox9);

        String[] ubeatzbox11 = new String[3];
        ubeatzbox11[0] = "ic_profile";
        ubeatzbox11[1] = "Ubeatz Box Malang";
        resultList.add(ubeatzbox11);

        return  resultList;
    }
}
