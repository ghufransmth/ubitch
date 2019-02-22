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
import com.example.macbookpro.ubeatz.model.Friends;

import java.util.ArrayList;
import java.util.List;

public class friendsAdapter extends ArrayAdapter<Friends> {

    private static final String TAG = "FriendsArrayAdapter";
    private List<Friends> friendsList = new ArrayList<Friends>();
    Context context;
    private LayoutInflater mInflater;
    private friendsListener listener;
    private Typeface tf;

    static class FriendsViewHolder {
        ImageView friendsImg;
        TextView friendsName;
        Button followbutton;
    }

    public friendsAdapter(Context context,  List<Friends> objects, friendsListener listener) {
        super(context, 0, objects);
        this.context = context;
        this.listener = listener;
        this.mInflater = LayoutInflater.from(context);
        friendsList = objects;
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Friends object) {
        friendsList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.friendsList.size();
    }

    @Override
    public Friends getItem(int index) {
        return this.friendsList.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        friendsAdapter.FriendsViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_friends, parent, false);
            viewHolder = new friendsAdapter.FriendsViewHolder();
            viewHolder.friendsImg = (ImageView) row.findViewById(R.id.friendsImg);
            viewHolder.friendsName = (TextView) row.findViewById(R.id.friendsName);
            viewHolder.followbutton = (Button) row.findViewById(R.id.button7);
            viewHolder.followbutton.setTypeface(tf);
            viewHolder.friendsName.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (friendsAdapter.FriendsViewHolder)row.getTag();
        }
        Friends friends = getItem(position);
//        viewHolder.friendsImg.setImageResource(friends.getProfilePic());
        viewHolder.friendsName.setText(friends.getFullname());
        viewHolder.followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.addfriend(friendsList.get(position));
                notifyDataSetChanged();
            }
        });
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public interface friendsListener {
        void addfriend(Friends off);
    }

}
