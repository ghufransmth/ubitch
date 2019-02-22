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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class searchPeopleFragment extends Fragment {

    private static final String TAG = "ListViewActivity";

    private searchPeopleAdapter fruitArrayAdapter;
    private ListView listView;

    private static int colorIndex;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_people,container,false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        fruitArrayAdapter = new searchPeopleAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_search_people);
        listView.setAdapter(fruitArrayAdapter);

        List<String[]> fruitList = readData();
        for(String[] fruitData:fruitList ) {
            String fruitImg = fruitData[0];
            String fruitName = fruitData[1];
            int fruitImgResId = getResources().getIdentifier(fruitImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Fruit fruit = new Fruit(fruitImgResId,fruitName);
            fruitArrayAdapter.add(fruit);
        }



        return view;
    }

    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] fruit7 = new String[3];
        fruit7[0] = "ic_profile";
        fruit7[1] = "Selena Gomez";
        resultList.add(fruit7);

        String[] fruit1 = new String[3];
        fruit1[0] = "ic_profile";
        fruit1[1] = "Renata Woen";
        resultList.add(fruit1);


        String[] fruit3 = new String[3];
        fruit3[0] = "ic_profile";
        fruit3[1] = "Kanye West";
        resultList.add(fruit3);

        String[] fruit4 = new String[3];
        fruit4[0] = "ic_profile";
        fruit4[1] = "Jessie Imyut";
        resultList.add(fruit4);

        String[] fruit10 = new String[3];
        fruit10[0] = "ic_profile";
        fruit10[1] = "_Underscore_";
        resultList.add(fruit10);

        String[] fruit5 = new String[3];
        fruit5[0] = "ic_profile";
        fruit5[1] = "Kesyel_Akyu";
        resultList.add(fruit5);


        String[] fruit2 = new String[3];
        fruit2[0] = "ic_profile";
        fruit2[1] = "Get_to_know_me_better";
        resultList.add(fruit2);

        String[] fruit6 = new String[3];
        fruit6[0] = "ic_profile";
        fruit6[1] = "Selena Gomez";
        resultList.add(fruit6);

        String[] fruit8 = new String[3];
        fruit8[0] = "ic_profile";
        fruit8[1] = "Renata Woen";
        resultList.add(fruit8);

        String[] fruit9 = new String[3];
        fruit9[0] = "ic_profile";
        fruit9[1] = "Kanye West";
        resultList.add(fruit9);

        String[] fruit11 = new String[3];
        fruit11[0] = "ic_profile";
        fruit11[1] = "Jessie Imyut";
        resultList.add(fruit11);

        return  resultList;
    }

}
