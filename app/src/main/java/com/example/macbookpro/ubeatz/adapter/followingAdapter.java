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

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.model.Followers;
import com.example.macbookpro.ubeatz.model.Following;

import java.util.ArrayList;
import java.util.List;

public class followingAdapter extends ArrayAdapter<Following>  {

    private static final String TAG = "FollowingArrayAdapter";
    private List<Following> followingList = new ArrayList<Following>();
    Context context;
    private LayoutInflater mInflater;
    private followingListener listener;
    private Typeface tf;

    static class FollowingViewHolder {
        ImageView followingImg;
        TextView followingName;
        Button followbutton;
        Button unfollowbutton;
    }

    public followingAdapter(Context context, List<Following> objects, followingListener listener) {
        super(context, 0, objects);
        this.context = context;
        this.listener = listener;
        this.mInflater = LayoutInflater.from(context);
        followingList = objects;
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Following object) {
        followingList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.followingList.size();
    }

    @Override
    public Following getItem(int index) {
        return this.followingList.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final followingAdapter.FollowingViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_following, parent, false);
            viewHolder = new followingAdapter.FollowingViewHolder();
            viewHolder.followingImg = (ImageView) row.findViewById(R.id.followingImg);
            viewHolder.followingName = (TextView) row.findViewById(R.id.followingName);
            viewHolder.followbutton = (Button) row.findViewById(R.id.button7);
            viewHolder.unfollowbutton = (Button) row.findViewById(R.id.button9);
            viewHolder.followbutton.setTypeface(tf);
            viewHolder.unfollowbutton.setTypeface(tf);
            viewHolder.followingName.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (followingAdapter.FollowingViewHolder)row.getTag();
        }
        Following following = getItem(position);
        viewHolder.followingImg.setImageResource(following.getImg());
        viewHolder.followingName.setText(following.getPerson());
//        viewHolder.followbutton.setVisibility(View.VISIBLE);
//        viewHolder.unfollowbutton.setVisibility(View.GONE);
        viewHolder.unfollowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.followbutton.setVisibility(View.VISIBLE);
                viewHolder.unfollowbutton.setVisibility(View.GONE);
                listener.onfollowSelected(followingList.get(position));
                notifyDataSetChanged();
            }
        });
        viewHolder.followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.followbutton.setVisibility(View.GONE);
                viewHolder.unfollowbutton.setVisibility(View.VISIBLE);
                listener.onunfollowSelected(followingList.get(position));
                notifyDataSetChanged();
            }
        });
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public interface followingListener {
        void onfollowSelected(Following off);

        void onunfollowSelected(Following off);
    }

}
