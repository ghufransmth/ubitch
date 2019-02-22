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
import com.example.macbookpro.ubeatz.model.Scores;
import com.example.macbookpro.ubeatz.model.Ubeatzbox;

import java.util.ArrayList;
import java.util.List;

public class searchUbeatzboxAdapter extends ArrayAdapter<Ubeatzbox> {
    private static final String TAG = "UbeatzboxArrayAdapter";
    private List<Ubeatzbox> ubeatzboxList = new ArrayList<Ubeatzbox>();
    private Typeface tf;

    static class UbeatzboxViewHolder {
        ImageView ubeatzboxImg;
        TextView ubeatzboxName;
    }

    public searchUbeatzboxAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Ubeatzbox object) {
        ubeatzboxList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.ubeatzboxList.size();
    }

    @Override
    public Ubeatzbox getItem(int index) {
        return this.ubeatzboxList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        searchUbeatzboxAdapter.UbeatzboxViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_search_ubeatz_box, parent, false);
            viewHolder = new searchUbeatzboxAdapter.UbeatzboxViewHolder();
            viewHolder.ubeatzboxImg = (ImageView) row.findViewById(R.id.ubeatzboxImg);
            viewHolder.ubeatzboxName = (TextView) row.findViewById(R.id.ubeatzboxName);
            viewHolder.ubeatzboxName.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (searchUbeatzboxAdapter.UbeatzboxViewHolder)row.getTag();
        }
        Ubeatzbox ubeatzbox = getItem(position);
        viewHolder.ubeatzboxImg.setImageResource(ubeatzbox.getImg());
        viewHolder.ubeatzboxName.setText(ubeatzbox.getUbeatzboxName());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
