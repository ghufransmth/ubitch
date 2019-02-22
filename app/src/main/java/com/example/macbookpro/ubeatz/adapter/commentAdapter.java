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
import com.example.macbookpro.ubeatz.model.Comment;
import com.example.macbookpro.ubeatz.model.Following;

import java.util.ArrayList;
import java.util.List;

public class commentAdapter extends ArrayAdapter<Comment> {

    private static final String TAG = "CommentArrayAdapter";
    private List<Comment> commentList = new ArrayList<Comment>();
    Context context;
    private LayoutInflater mInflater;
    private Typeface tf;

    static class CommentViewHolder {
        ImageView commentImg;
        TextView commentName,comment,comment_time_posted,comment_reply,comment_likes;
    }

    public commentAdapter(Context context, List<Comment> objects) {
        super(context, 0, objects);
        this.context = context;
//        this.listener = listener;
        this.mInflater = LayoutInflater.from(context);
        commentList = objects;
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public void add(Comment object) {
        commentList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.commentList.size();
    }

    @Override
    public Comment getItem(int index) {
        return this.commentList.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final commentAdapter.CommentViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_custom_comment_listview, parent, false);
            viewHolder = new commentAdapter.CommentViewHolder();
            viewHolder.commentImg = (ImageView) row.findViewById(R.id.imageView28);
            viewHolder.commentName = (TextView) row.findViewById(R.id.comment_username);
            viewHolder.comment = (TextView) row.findViewById(R.id.comment);
            viewHolder.comment_time_posted = (TextView) row.findViewById(R.id.comment_time_posted);
            viewHolder.comment_likes = (TextView) row.findViewById(R.id.comment_likes);
            viewHolder.comment_reply = (TextView) row.findViewById(R.id.comment_reply);
            viewHolder.commentName.setTypeface(tf);
            viewHolder.comment.setTypeface(tf);
            viewHolder.comment_time_posted.setTypeface(tf);
            viewHolder.comment_likes.setTypeface(tf);
            viewHolder.comment_reply.setTypeface(tf);
            row.setTag(viewHolder);
        } else {
            viewHolder = (commentAdapter.CommentViewHolder)row.getTag();
        }
        Comment comment = getItem(position);
        viewHolder.commentName.setText(comment.getPostBy());
        viewHolder.comment.setText(comment.getComment());
        viewHolder.commentImg.setImageResource(comment.getImages());
//        viewHolder.unfollowbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

}
