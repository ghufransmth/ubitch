package com.example.macbookpro.ubeatz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.macbookpro.ubeatz.R;

public class profileGalleryAdapter extends BaseAdapter {
    int count = 18;
    private Context mContext;
    private static LayoutInflater inflater=null;

    public profileGalleryAdapter(Context mContext) {
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
        inflater = ( LayoutInflater )mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return count;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        int cellHeight = 200;
        // TODO Auto-generated method stub
        View rowView = inflater.inflate(R.layout.layout_custom_grid_item, null);
//        View rowView = inflater.inflate(R.layout.layout_custom_search_gridview, null);
//        rowView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, cellHeight));
        return rowView;
    }
}
