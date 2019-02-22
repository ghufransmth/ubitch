package com.example.macbookpro.ubeatz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.macbookpro.ubeatz.adapter.categoryGridviewAdapter;
import com.example.macbookpro.ubeatz.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class category extends AppCompatActivity {

    GridView gv;
    ImageView imgView;
    private categoryGridviewAdapter categoryArrayAdapter;
    private static int colorIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportActionBar().hide();

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });


        colorIndex = 0;
        gv=(GridView) findViewById(R.id.gridView);
        categoryArrayAdapter = new categoryGridviewAdapter(this, R.layout.layout_custom_category_grid_item);
        gv.setAdapter(categoryArrayAdapter);
        // Populate a List from Array elements
//        final List<String> categoryList = new ArrayList<String>(Arrays.asList(category));


//        categoryList.add("Indonesia");
//        categoryList.add("Western");
//        categoryList.add("Chinese");
//        categoryList.add("Children");
//        categoryList.add("Malaysia");
//        categoryList.add("India");
//        categoryList.add("Folk");
//        categoryList.add("Japan");

        List<String[]> categoryList = readData();
        for (String[] categoryData : categoryList) {
            String categoryName = categoryData[0];

            Category cat = new Category(categoryName);
            categoryArrayAdapter.add(cat);
            // Update the GridView
            categoryArrayAdapter.notifyDataSetChanged();
        }


    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();

        String[] followers7 = new String[3];
        followers7[0] = "Indonesia";
        resultList.add(followers7);

        String[] followers1 = new String[3];
        followers1[0] = "Western";
        resultList.add(followers1);


        String[] followers3 = new String[3];
        followers3[0] = "Chinese";
        resultList.add(followers3);

        String[] followers4 = new String[3];
        followers4[0] = "Children";
        resultList.add(followers4);

        String[] followers10 = new String[3];
        followers10[0] = "Malaysia";
        resultList.add(followers10);

        String[] followers5 = new String[3];
        followers5[0] = "India";
        resultList.add(followers5);


        String[] followers2 = new String[3];
        followers2[0] = "Folk";
        resultList.add(followers2);

        String[] followers6 = new String[3];
        followers6[0] = "Japan";
        resultList.add(followers6);

        return resultList;
    }
}
