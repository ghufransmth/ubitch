package com.example.macbookpro.ubeatz.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.model.Item;
import com.example.macbookpro.ubeatz.search;
import com.example.macbookpro.ubeatz.searchFragment;

import java.util.ArrayList;

public class searchGridViewAdapter extends ArrayAdapter {
    int count = 18;
    private Context mContext;
    private static LayoutInflater inflater=null;
    int layoutResourceId;
//    ArrayList<Item> data = new ArrayList<Item>();
    private String[] imageUrls;

//    public searchGridViewAdapter(Context mContext, int layoutResourceId, ArrayList<Item> data) {
//        // TODO Auto-generated constructor stub
//        super(mContext, layoutResourceId, data);
//        this.layoutResourceId = layoutResourceId;
//        this.mContext = mContext;
//        this.data = data;
////        inflater = ( LayoutInflater )mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
//    }

    public searchGridViewAdapter(Context mContext, String[] imageUrls) {
        // TODO Auto-generated constructor stub
        super(mContext, R.layout.layout_custom_grid_item, imageUrls);
//        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.imageUrls = imageUrls;
//        inflater = ( LayoutInflater )mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
    }

//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return count;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        // TODO Auto-generated method stub
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        // TODO Auto-generated method stub
//        return position;
//    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
//        int cellWidth = 400;
//        int cellHeight = 200;
//        View rowView = inflater.inflate(R.layout.layout_custom_grid_item, null);
//        return rowView;
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(R.layout.layout_custom_grid_item, parent, false);

            holder = new RecordHolder();
//            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.picture);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

//        Item item = data.get(position);
//        holder.txtTitle.setText(item.getTitle());
//        holder.imageItem.setImageBitmap(item.getImage());
        Glide.with(mContext)
                .load(imageUrls[position])
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.imageItem);

        return row;
    }
}
