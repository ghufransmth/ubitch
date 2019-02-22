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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.Fruit;
import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.model.Song;
import com.example.macbookpro.ubeatz.searchPeopleAdapter;

import java.util.ArrayList;
import java.util.List;

public class searchSongAdapter extends ArrayAdapter<Song> {
    private static final String TAG = "SongArrayAdapter";
    private List<Song> songList = new ArrayList<Song>();
    private Typeface tf;

    static class SongViewHolder {
        ImageView songImg;
        TextView songName;
    }

    public searchSongAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Song object) {
        songList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.songList.size();
    }

    @Override
    public Song getItem(int index) {
        return this.songList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        searchSongAdapter.SongViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_search_song, parent, false);
            viewHolder = new searchSongAdapter.SongViewHolder();
            viewHolder.songImg = (ImageView) row.findViewById(R.id.songImg);
            viewHolder.songName = (TextView) row.findViewById(R.id.songName);
            viewHolder.songName.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (searchSongAdapter.SongViewHolder)row.getTag();
        }
        Song song = getItem(position);
        viewHolder.songImg.setImageResource(song.getImg());
        viewHolder.songName.setText(song.getSongName());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
