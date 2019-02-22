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
import com.example.macbookpro.ubeatz.model.Myplaylist;

import java.util.ArrayList;
import java.util.List;

public class profileMyPlaylistAdapter extends ArrayAdapter<Myplaylist> {
    private static final String TAG = "MyplaylistArrayAdapter";
    private List<Myplaylist> myplaylistList = new ArrayList<Myplaylist>();
    private Typeface tf,tf2;

    static class MyplaylistViewHolder {
        ImageView myplaylistImg;
        TextView myplaylistName;
        TextView myplaylistName2;
    }

    public profileMyPlaylistAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf2 = ResourcesCompat.getFont(context, R.font.petitamedium);
        this.tf = ResourcesCompat.getFont(context, R.font.petitabold);
    }

    @Override
    public void add(Myplaylist object) {
        myplaylistList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.myplaylistList.size();
    }

    @Override
    public Myplaylist getItem(int index) {
        return this.myplaylistList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        profileMyPlaylistAdapter.MyplaylistViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_profile_playlist, parent, false);
            viewHolder = new profileMyPlaylistAdapter.MyplaylistViewHolder();
            viewHolder.myplaylistImg = (ImageView) row.findViewById(R.id.profileImg);
            viewHolder.myplaylistName = (TextView) row.findViewById(R.id.profileName);
            viewHolder.myplaylistName2 = (TextView) row.findViewById(R.id.profileName2);
            viewHolder.myplaylistName.setTypeface(tf);
            viewHolder.myplaylistName2.setTypeface(tf2);
            row.setTag(viewHolder);
        } else {
            viewHolder = (profileMyPlaylistAdapter.MyplaylistViewHolder)row.getTag();
        }
        Myplaylist myplaylist = getItem(position);
        viewHolder.myplaylistImg.setImageResource(myplaylist.getImg());
        viewHolder.myplaylistName.setText(myplaylist.getMyplaylistName());
        viewHolder.myplaylistName2.setText(myplaylist.getMyplaylistName2());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
