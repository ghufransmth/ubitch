package com.example.macbookpro.ubeatz.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.comment;
import com.example.macbookpro.ubeatz.model.News;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.MyViewHolder>  {

    public List<News> newsList;
    ArrayList<News> arraylist;
    private NewsfeedListener listener;
    private Context context;
    private Typeface tf;
    private MediaController mediaController;
    SharedPrefManager sharedPrefManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUsername, textViewDesc, textViewLikes, textViewComments, textViewShare, textLikes, textComments, textCommentsLink, textViewCountComment, textViewComments2, textViewTime;
        ImageView Likes,Dislikes,Commen,Share;
        VideoView videoView;
        LinearLayout mediaLayout;

        public MyViewHolder(View view) {
            super(view);
            textViewUsername = (TextView) view.findViewById(R.id.nameuser);
            textViewDesc = (TextView) view.findViewById(R.id.description2);
            textViewLikes = (TextView) view.findViewById(R.id.textView6);
            textLikes = (TextView) view.findViewById(R.id.textView50);
            Likes = (ImageView) view.findViewById((R.id.imageView9));
            Dislikes = (ImageView) view.findViewById((R.id.imageView26));
            textViewComments = (TextView) view.findViewById(R.id.textView7);
            textComments = (TextView) view.findViewById(R.id.textView51);
            Commen = (ImageView) view.findViewById((R.id.imageView10));
            Share = (ImageView) view.findViewById((R.id.imageView11));
            textViewShare = (TextView) view.findViewById(R.id.textView9);
            textCommentsLink = (TextView) view.findViewById(R.id.comments_link);
            textViewCountComment = (TextView) view.findViewById(R.id.textView52);
            textViewComments2 = (TextView) view.findViewById(R.id.textView53);
            textViewTime = (TextView) view.findViewById(R.id.time_posted);
            videoView = (VideoView) view.findViewById((R.id.video_view));
            mediaLayout = (LinearLayout)view.findViewById(R.id.media_layout);
            sharedPrefManager = new SharedPrefManager(context);
        }
    }

    public newsAdapter(Context context,List<News> objects,NewsfeedListener listener) {
        this.context = context;
        this.newsList = objects;
        this.listener = listener;
        newsList = objects;
        this.arraylist = new ArrayList<News>();
        this.arraylist.addAll(newsList);
        this.tf = ResourcesCompat.getFont(context, R.font.petitamedium);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_custom_newsfeed_listview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {

        try {

            final News off = newsList.get(position);

            holder.textViewUsername.setText(off.getPostBy());
            holder.textViewDesc.setText(off.getNews());
            holder.textViewLikes.setText(off.getLikes());
            holder.textViewComments.setText(off.getComments());
            holder.textViewCountComment.setText(off.getComments());
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


            //play video using android api, when video view is clicked.
            String url = off.getImages(); // your URL here
            Uri videoUri = Uri.parse(url);
            holder.videoView.setVideoURI(videoUri);
            holder.videoView.requestFocus();
            mediaController = new MediaController(context);


            // Set MediaController for VideoView
//            holder.videoView.setMediaController(mediaController);
//            mediaController.setAnchorView(holder.videoView);
//            holder.videoView.seekTo(1);
//            holder.videoView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//
//                @Override
//                public void onScrollChanged() {
//                    mediaController.hide();
//                }
//            });
            holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    // Set the media controller buttons
//                    if (mediaController == null) {
//                        mediaController = new MediaController(context);
//
//                        // Set the videoView that acts as the anchor for the MediaController.
//                        mediaController.setAnchorView(holder.videoView);
//
//                        // Set MediaController for VideoView
//                        holder.videoView.setMediaController(mediaController);
//                    }



//                    holder.videoView.seekTo(100);
//                    if (position == 0) {
//                        mp.setLooping(true);
//                        holder.videoView.pause();
//                        holder.videoView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//
//                            @Override
//                            public void onScrollChanged() {
//                                mediaController.hide();
//                            }
//                        });
//                    }

                    // When video Screen change size.
//                    mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
//                        @Override
//                        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
//
//                            // Re-Set the videoView that acts as the anchor for the MediaController
//                            mediaController.setAnchorView(holder.videoView);
//                        }
//                    });


//                    mp.setLooping(true);
//                    holder.videoView.pause();
                }
            });
            holder.videoView.start();

            if(off.getTot() == null){
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
                    listener.onNewsfeedLikeSelected(newsList.get(holder.getAdapterPosition()));
                    notifyItemChanged(holder.getAdapterPosition());
                }
            });
            holder.Dislikes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.Dislikes.setVisibility(View.GONE);
                    holder.Likes.setVisibility(View.VISIBLE);
                    listener.onNewsfeedDislikeSelected(newsList.get(holder.getAdapterPosition()));
                    notifyItemChanged(holder.getAdapterPosition());
                }
            });
            holder.textCommentsLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_NEWS, off.getId());
                    Intent intent = new Intent(context, comment.class);
                    context.startActivity(intent);
                }
            });
            holder.textComments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_NEWS, off.getId());
                    Intent intent = new Intent(context, comment.class);
                    context.startActivity(intent);
                }
            });
            holder.Commen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_NEWS, off.getId());
                    Intent intent = new Intent(context, comment.class);
                    context.startActivity(intent);
                }
            });
            holder.Share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri pictureUri = Uri.parse("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/ubeatzmusictaiment.png");
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, off.getNews()+" "+"Posted By"+" "+off.getPostBy());
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
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, off.getNews()+" "+"Posted By"+" "+off.getPostBy());
                    sendIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);
                    sendIntent.setType("image/*");
                    sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    context.startActivity(sendIntent);
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public interface NewsfeedListener {
        void onNewsfeedLikeSelected(News off);

        void onNewsfeedDislikeSelected(News off);

        void onNewsfeedDetail(News off);
    }

//    List<News> newsList;
//    Context context;
//    private LayoutInflater mInflater;
//
//    public newsAdapter(Context context, List<News> objects){
//        super(context, 0, objects);
//        this.context = context;
//        this.mInflater = LayoutInflater.from(context);
//        newsList = objects;
//    }
//
//    @Override
//    public News getItem(int position) {
//        return newsList.get(position);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final newsAdapter.ViewHolder vh;
//        if (convertView == null) {
//            View view = mInflater.inflate(R.layout.layout_custom_newsfeed_listview, parent, false);
//            vh = newsAdapter.ViewHolder.create((RelativeLayout) view);
//            view.setTag(vh);
//        } else {
//            vh = (newsAdapter.ViewHolder) convertView.getTag();
//        }
//
//        News item = getItem(position);
//
//        vh.textViewUsername.setText(item.getPostBy());
//        vh.textViewDesc.setText(item.getNews());
//        vh.textViewLikes.setText(item.getLikes());
//        vh.textViewComments.setText(item.getComments());
//        return vh.rootView;
//    }
//
//    private static class ViewHolder {
//        public final RelativeLayout rootView;
//        public final TextView textViewUsername;
//        public final TextView textViewDesc;
//        public final TextView textViewLikes;
//        public final TextView textViewComments;
//
//        private ViewHolder(RelativeLayout rootView, TextView textViewUsername, TextView textViewDesc, TextView textViewLikes, TextView textViewComments) {
//            this.rootView = rootView;
//            this.textViewUsername = textViewUsername;
//            this.textViewDesc = textViewDesc;
//            this.textViewLikes = textViewLikes;
//            this.textViewComments = textViewComments;
//        }
//
//        public static newsAdapter.ViewHolder create(RelativeLayout rootView) {
//            TextView textViewUsername = (TextView) rootView.findViewById(R.id.nameuser);
//            TextView textViewDesc = (TextView) rootView.findViewById(R.id.description2);
//            TextView textViewLikes = (TextView) rootView.findViewById(R.id.textView6);
//            TextView textViewComments = (TextView) rootView.findViewById(R.id.textView7);
//            return new newsAdapter.ViewHolder(rootView, textViewUsername, textViewDesc, textViewLikes, textViewComments);
//        }
//
//    }
}
