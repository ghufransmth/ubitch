package com.example.macbookpro.ubeatz.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.findbox_detail;
import com.example.macbookpro.ubeatz.model.Findbox;
import com.example.macbookpro.ubeatz.model.Location;

import java.util.List;

public class locationAdapter extends ArrayAdapter<Findbox> {
    private Activity context;
    List<Findbox> findbox;

    public locationAdapter(Activity context, List<Findbox> findbox) {
        super(context, R.layout.layout_custom_findbox_listview, findbox);
        this.context = context;
        this.findbox = findbox;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_custom_findbox_listview, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.locationName);
        TextView descName = (TextView) listViewItem.findViewById(R.id.addressName);
        TextView viewLocate = (TextView) listViewItem.findViewById(R.id.viewLocation);
        viewLocate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                context.startActivity(new Intent(context, findbox_detail.class));
            }
        });

        Typeface typeface = ResourcesCompat.getFont(context, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(context, R.font.petitamedium);
        textViewName.setTypeface(typeface2);
        descName.setTypeface(typeface2);
        viewLocate.setTypeface(typeface2);

        Findbox track = findbox.get(position);
        textViewName.setText(track.getNama());
        descName.setText(track.getDesc());

        return listViewItem;
    }
}
