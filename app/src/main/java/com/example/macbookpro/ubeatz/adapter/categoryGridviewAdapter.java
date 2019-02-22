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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.model.Category;
import com.example.macbookpro.ubeatz.model.Followers;

import java.util.ArrayList;
import java.util.List;

public class categoryGridviewAdapter extends ArrayAdapter<Category> {

    private static final String TAG = "categoryGridviewAdapter";
    private List<Category> categoryList = new ArrayList<Category>();
    private Typeface tf;

    static class categoryGridviewHolder {
        TextView categoryName;
    }

    public categoryGridviewAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Category object) {
        categoryList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.categoryList.size();
    }

    @Override
    public Category getItem(int index) {
        return this.categoryList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        categoryGridviewAdapter.categoryGridviewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_category_grid_item, parent, false);
            viewHolder = new categoryGridviewAdapter.categoryGridviewHolder();
            viewHolder.categoryName = (TextView) row.findViewById(R.id.textView54);
            row.setTag(viewHolder);
        } else {
            viewHolder = (categoryGridviewAdapter.categoryGridviewHolder)row.getTag();
        }
        Category cat = getItem(position);
        viewHolder.categoryName.setText(cat.getCategoryName());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
