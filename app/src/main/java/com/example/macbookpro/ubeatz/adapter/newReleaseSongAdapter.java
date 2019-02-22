package com.example.macbookpro.ubeatz.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.model.NewSong;

import java.util.List;

public class newReleaseSongAdapter extends ArrayAdapter<NewSong> {

    List<NewSong> newsongList;
    Context context;
    private LayoutInflater mInflater;
    private Typeface tf;

    // Constructors
    public newReleaseSongAdapter(Context context, List<NewSong> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        newsongList = objects;
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public NewSong getItem(int position) {
        return newsongList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_custom_new_song_listview, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        NewSong item = getItem(position);

        vh.textViewJudul.setText(item.getJudulName());
        vh.textViewArtis.setText(item.getArtis());
        vh.textViewJudul.setTypeface(tf);
        vh.textViewArtis.setTypeface(tf);
        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final TextView textViewJudul;
        public final TextView textViewArtis;

        private ViewHolder(RelativeLayout rootView, TextView textViewJudul, TextView textViewArtis) {
            this.rootView = rootView;
            this.textViewJudul = textViewJudul;
            this.textViewArtis = textViewArtis;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewJudul = (TextView) rootView.findViewById(R.id.profileName);
            TextView textViewArtis = (TextView) rootView.findViewById(R.id.profileName2);
            return new ViewHolder(rootView,  textViewJudul, textViewArtis);
        }
    }
}
