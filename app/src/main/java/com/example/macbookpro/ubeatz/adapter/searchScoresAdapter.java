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
import com.example.macbookpro.ubeatz.model.Scores;

import java.util.ArrayList;
import java.util.List;

public class searchScoresAdapter extends ArrayAdapter<Scores>  {
    private static final String TAG = "ScoresArrayAdapter";
    private List<Scores> scoresList = new ArrayList<Scores>();
    private Typeface tf;

    static class ScoresViewHolder {
        ImageView scoresImg;
        TextView scoresName;
    }

    public searchScoresAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Scores object) {
        scoresList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoresList.size();
    }

    @Override
    public Scores getItem(int index) {
        return this.scoresList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        searchScoresAdapter.ScoresViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_search_scores, parent, false);
            viewHolder = new searchScoresAdapter.ScoresViewHolder();
            viewHolder.scoresImg = (ImageView) row.findViewById(R.id.scoresImg);
            viewHolder.scoresName = (TextView) row.findViewById(R.id.scoresName);
            viewHolder.scoresName.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (searchScoresAdapter.ScoresViewHolder)row.getTag();
        }
        Scores scores = getItem(position);
        viewHolder.scoresImg.setImageResource(scores.getImg());
        viewHolder.scoresName.setText(scores.getScoresName());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
