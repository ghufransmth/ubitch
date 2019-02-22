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
import com.example.macbookpro.ubeatz.model.Location;

import java.util.ArrayList;
import java.util.List;

public class followersAdapter extends ArrayAdapter<Followers> {

    private static final String TAG = "FollowersArrayAdapter";
    private List<Followers> followersList = new ArrayList<Followers>();
    private Typeface tf;
    Context context;
    private LayoutInflater mInflater;
    private followersListener listener;

    static class FollowersViewHolder {
        ImageView followersImg;
        TextView followersName;
        Button  followbutton,followingbutton;
    }

    public followersAdapter(Context context, List<Followers> objects, followersListener listener) {
        super(context, 0,objects);
        this.context = context;
        this.listener = listener;
        this.mInflater = LayoutInflater.from(context);
        followersList = objects;
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Followers object) {
        followersList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.followersList.size();
    }

    @Override
    public Followers getItem(int index) {
        return this.followersList.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        followersAdapter.FollowersViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_followers, parent, false);
            viewHolder = new followersAdapter.FollowersViewHolder();
            viewHolder.followersImg = (ImageView) row.findViewById(R.id.followersImg);
            viewHolder.followersName = (TextView) row.findViewById(R.id.followersName);
            viewHolder.followbutton = (Button) row.findViewById(R.id.button9);
            viewHolder.followingbutton = (Button) row.findViewById(R.id.button7);
            viewHolder.followbutton.setTypeface(tf);
            viewHolder.followingbutton.setTypeface(tf);
            viewHolder.followersName.setTypeface(tf);
//            viewHolder.followbutton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    v.setEnabled(true);
//                }
//            });
            row.setTag(viewHolder);
        } else {
            viewHolder = (followersAdapter.FollowersViewHolder)row.getTag();
        }
        Followers followers = getItem(position);
//        viewHolder.followersImg.setImageResource(followers.getProfilePic());
        viewHolder.followersName.setText(followers.getFullname());
        if(followers.getFollowing() == null){
            viewHolder.followbutton.setVisibility(View.VISIBLE);
            viewHolder.followingbutton.setVisibility(View.GONE);
        }else{
            viewHolder.followbutton.setVisibility(View.GONE);
            viewHolder.followingbutton.setVisibility(View.VISIBLE);
        }
        viewHolder.followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onfollowSelected(followersList.get(position));
                notifyDataSetChanged();
            }
        });
        viewHolder.followingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onunfollowSelected(followersList.get(position));
                notifyDataSetChanged();
            }
        });

        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public interface followersListener {
        void onfollowSelected(Followers off);

        void onunfollowSelected(Followers off);
    }



}
