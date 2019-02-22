package com.example.macbookpro.ubeatz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.adapter.searchGridViewAdapter;
import com.example.macbookpro.ubeatz.model.Item;

import java.util.ArrayList;
import java.util.List;

public class searchFragment extends Fragment {

    private Button buttonsearch;
    private GridView gv;
    ArrayList<Item> gridArray = new ArrayList<Item>();
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
        View view = inflater.inflate(R.layout.fragment_search,container,false);

        //set grid view item
//        Bitmap gettyimages1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages1);
//        Bitmap gettyimages2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages2);
//        Bitmap gettyimages3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages3);
//        Bitmap gettyimages4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages4);
//        Bitmap gettyimages5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages5);
//        Bitmap gettyimages6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages6);
//        Bitmap gettyimages7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages7);
//        Bitmap gettyimages8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gettyimages8);
//
//        gridArray.add(new Item("Nice",gettyimages1));
//        gridArray.add(new Item("Yeah",gettyimages2));
//        gridArray.add(new Item("Nice",gettyimages3));
//        gridArray.add(new Item("Yeah",gettyimages4));
//        gridArray.add(new Item("Nice",gettyimages5));
//        gridArray.add(new Item("Yeah",gettyimages6));
//        gridArray.add(new Item("Nice",gettyimages7));
//        gridArray.add(new Item("Yeah",gettyimages8));
//        gridArray.add(new Item("Nice",gettyimages1));
//        gridArray.add(new Item("Yeah",gettyimages2));
//        gridArray.add(new Item("Nice",gettyimages3));
//        gridArray.add(new Item("Yeah",gettyimages4));
//        gridArray.add(new Item("Yeah",gettyimages5));
//        gridArray.add(new Item("Nice",gettyimages6));
//        gridArray.add(new Item("Yeah",gettyimages7));



        buttonsearch = (Button) view.findViewById(R.id.buttonSearch);
        buttonsearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(getActivity(),
                        search.class);
                startActivity(intent); // startActivity allow you to move
            }
        });


        gv=(GridView) view.findViewById(R.id.gridView);
        gv.setAdapter(new searchGridViewAdapter(getActivity(),gridall));

        TextView Search = (TextView) view.findViewById(R.id.textView8);
        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.petitabold);
        Search.setTypeface(typeface);


        return view;
    }

}
