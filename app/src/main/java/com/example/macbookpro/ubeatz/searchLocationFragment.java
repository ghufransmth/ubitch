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

import com.example.macbookpro.ubeatz.adapter.searchLocationAdapter;
import com.example.macbookpro.ubeatz.adapter.searchSongAdapter;
import com.example.macbookpro.ubeatz.model.Location;
import com.example.macbookpro.ubeatz.model.Song;

import java.util.ArrayList;
import java.util.List;


public class searchLocationFragment extends Fragment {

    private static final String TAG = "ListViewActivity";

    private searchLocationAdapter locationArrayAdapter;
    private ListView listView;

    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_location, container, false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        locationArrayAdapter = new searchLocationAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_search_location);
        listView.setAdapter(locationArrayAdapter);

        List<String[]> locationList = readData();
        for (String[] locationData : locationList) {
            String locationImg = locationData[0];
            String locationName = locationData[1];
            int locationImgResId = getResources().getIdentifier(locationImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Location location = new Location(locationImgResId, locationName);
            locationArrayAdapter.add(location);
        }

        return view;
    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();

        String[] location7 = new String[3];
        location7[0] = "ic_profile";
        location7[1] = "alamsutera";
        resultList.add(location7);

        String[] location1 = new String[3];
        location1[0] = "ic_profile";
        location1[1] = "ujungpandang";
        resultList.add(location1);


        String[] location3 = new String[3];
        location3[0] = "ic_profile";
        location3[1] = "manado";
        resultList.add(location3);

        String[] location4 = new String[3];
        location4[0] = "ic_profile";
        location4[1] = "kemang";
        resultList.add(location4);

        String[] location10 = new String[3];
        location10[0] = "ic_profile";
        location10[1] = "citos";
        resultList.add(location10);

        String[] location5 = new String[3];
        location5[0] = "ic_profile";
        location5[1] = "plazasenayan";
        resultList.add(location5);


        String[] location2 = new String[3];
        location2[0] = "ic_profile";
        location2[1] = "jaksel";
        resultList.add(location2);

        String[] location6 = new String[3];
        location6[0] = "ic_profile";
        location6[1] = "kendal";
        resultList.add(location6);

        String[] location8 = new String[3];
        location8[0] = "ic_profile";
        location8[1] = "cikini";
        resultList.add(location8);

        String[] location9 = new String[3];
        location9[0] = "ic_profile";
        location9[1] = "gambir";
        resultList.add(location9);

        String[] location11 = new String[3];
        location11[0] = "ic_profile";
        location11[1] = "bankindonesia";
        resultList.add(location11);

        return resultList;
    }
}
