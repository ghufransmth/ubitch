package com.example.macbookpro.ubeatz.adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.comment;
import com.example.macbookpro.ubeatz.holder.HomeNewsFeedViewHolder;
import com.example.macbookpro.ubeatz.model.News;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class newsAdapterNew extends RecyclerView.Adapter<HomeNewsFeedViewHolder> {

    ArrayList<News> myArray;
    Context context;
    private Typeface tf;
    private NewsfeedListener listener;

    public newsAdapterNew(ArrayList<News> myArray, Context context, NewsfeedListener listener) {

        this.myArray = myArray;
        this.context = context;
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
        this.listener = listener;
    }

    @Override public HomeNewsFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_custom_newsfeed_listview_version_2, parent, false);
        return new HomeNewsFeedViewHolder(view);
    }

    @Override public void onBindViewHolder(final HomeNewsFeedViewHolder holder, final int position) {
        final SharedPrefManager sharedPrefManager = new SharedPrefManager(context);
        holder.bind(Uri.parse(""+myArray.get(position).getImages()));
        holder.textViewUsername.setText(myArray.get(position).getImages());

        holder.textViewUsername.setText(myArray.get(position).getPostBy());
        holder.textViewDesc.setText(myArray.get(position).getNews());
        holder.textViewLikes.setText(myArray.get(position).getLikes());
        holder.textViewComments.setText(myArray.get(position).getComments());
        holder.textViewCountComment.setText(myArray.get(position).getComments());
        holder.textViewUsername.setTypeface(tf);
        holder.textViewDesc.setTypeface(tf);
        holder.textViewLikes.setTypeface(tf);
        holder.textLikes.setTypeface(tf);
        holder.textViewComments.setTypeface(tf);
        holder.textCommentsLink.setTypeface(tf);
        holder.textComments.setTypeface(tf);
        holder.textViewShare.setTypeface(tf);
        holder.textViewCountComment.setTypeface(tf);
        holder.textViewComments2.setTypeface(tf);
        holder.textViewTime.setTypeface(tf);

        if(myArray.get(position).getTot() == null){
            holder.Dislikes.setVisibility(View.GONE);
            holder.Likes.setVisibility(View.VISIBLE);
        }else{
            holder.Likes.setVisibility(View.GONE);
            holder.Dislikes.setVisibility(View.VISIBLE);
        }

        holder.Likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.Likes.setVisibility(View.GONE);
                holder.Dislikes.setVisibility(View.VISIBLE);
                listener.onNewsfeedLikeSelected(myArray.get(position));
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
        holder.Dislikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.Dislikes.setVisibility(View.GONE);
                holder.Likes.setVisibility(View.VISIBLE);
                listener.onNewsfeedDislikeSelected(myArray.get(position));
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
        holder.textCommentsLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_NEWS, myArray.get(position).getId());
                Intent intent = new Intent(context, comment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.textComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_NEWS, myArray.get(position).getId());
                Intent intent = new Intent(context, comment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.Commen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_NEWS, myArray.get(position).getId());
                Intent intent = new Intent(context, comment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pictureUri = Uri.parse("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/ubeatzmusictaiment.png");
                Intent sendIntent = new Intent();
                sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, myArray.get(position).getNews()+" "+"Posted By"+" "+myArray.get(position).getPostBy());
                sendIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);
                sendIntent.setType("image/*");
                sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                context.startActivity(sendIntent);
            }
        });
        holder.textViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pictureUri = Uri.parse("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/ubeatzmusictaiment.png");
                Intent sendIntent = new Intent();
                sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, myArray.get(position).getNews()+" "+"Posted By"+" "+myArray.get(position).getPostBy());
                sendIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);
                sendIntent.setType("image/*");
                sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                context.startActivity(sendIntent);
            }
        });
    }

    @Override public int getItemCount() {
        return myArray.size();
    }

    public interface NewsfeedListener {
        void onNewsfeedLikeSelected(News off);

        void onNewsfeedDislikeSelected(News off);

        void onNewsfeedDetail(News off);
    }
}