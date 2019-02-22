package com.example.macbookpro.ubeatz.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.model.Location;
import com.example.macbookpro.ubeatz.model.Song;

import java.util.ArrayList;
import java.util.List;

public class searchLocationAdapter extends ArrayAdapter<Location> {
    private static final String TAG = "LocationArrayAdapter";
    private List<Location> locationList = new ArrayList<Location>();
    private Typeface tf;

    static class LocationViewHolder {
        ImageView locationImg;
        TextView locationName;
    }

    public searchLocationAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Location object) {
        locationList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.locationList.size();
    }

    @Override
    public Location getItem(int index) {
        return this.locationList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        searchLocationAdapter.LocationViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_search_location, parent, false);
            viewHolder = new searchLocationAdapter.LocationViewHolder();
            viewHolder.locationImg = (ImageView) row.findViewById(R.id.locationImg);
            viewHolder.locationName = (TextView) row.findViewById(R.id.locationName);
            viewHolder.locationName.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (searchLocationAdapter.LocationViewHolder)row.getTag();
        }
        Location location = getItem(position);
        viewHolder.locationImg.setImageResource(location.getImg());
        viewHolder.locationName.setText(location.getLocationName());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
