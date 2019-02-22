package com.example.macbookpro.ubeatz;

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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class searchPeopleAdapter extends ArrayAdapter<Fruit> implements Filterable {
    private static final String TAG = "FruitArrayAdapter";
    private List<Fruit> fruitList = new ArrayList<Fruit>();
//    List<String> arrayList;
    List<Fruit> mOriginalValues;
    private Typeface tf;

    static class FruitViewHolder {
        ImageView fruitImg;
        TextView fruitName;
        Button button7;
    }

    public searchPeopleAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Fruit object) {
        fruitList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.fruitList.size();
    }

    @Override
    public Fruit getItem(int index) {
        return this.fruitList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FruitViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_search_people, parent, false);
            viewHolder = new FruitViewHolder();
            viewHolder.fruitImg = (ImageView) row.findViewById(R.id.fruitImg);
            viewHolder.fruitName = (TextView) row.findViewById(R.id.fruitName);
            viewHolder.button7 = (Button) row.findViewById(R.id.button7);
            viewHolder.fruitName.setTypeface(tf);
            viewHolder.button7.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (FruitViewHolder)row.getTag();
        }
        Fruit fruit = getItem(position);
        viewHolder.fruitImg.setImageResource(fruit.getFruitImg());
        viewHolder.fruitName.setText(fruit.getFruitName());
        return row;
    }

    // Filter method
    public void filter(CharSequence charText) {
        charText = charText.toString().toLowerCase(Locale.getDefault());
        fruitList.clear();
        if (charText.length() == 0) {
            fruitList.addAll(mOriginalValues);
        } else {
            for (Fruit s : mOriginalValues) {
                if (s.getFruitName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    fruitList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                fruitList = (List<Fruit>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                List<String> FilteredArrList = new ArrayList<String>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<Fruit>(fruitList); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {
                        Fruit data = mOriginalValues.get(i);
                        if (data.getFruitName().startsWith(constraint.toString())) {
                            FilteredArrList.add(data.getFruitName());
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
