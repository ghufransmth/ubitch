package com.example.macbookpro.ubeatz.holder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import im.ene.toro.ToroPlayer;
import im.ene.toro.ToroUtil;
import im.ene.toro.exoplayer.SimpleExoPlayerViewHelper;
import im.ene.toro.media.PlaybackInfo;
import im.ene.toro.widget.Container;

public class HomeNewsFeedViewHolder extends RecyclerView.ViewHolder implements ToroPlayer {

    SimpleExoPlayerView playerView;
    SimpleExoPlayerViewHelper helper;
    Uri mediaUri;
    public TextView textViewUsername, textViewDesc, textViewLikes, textViewComments, textViewShare, textLikes, textComments, textCommentsLink, textViewCountComment, textViewComments2, textViewTime;;
    public ImageView Likes,Dislikes,Commen,Share;
    LinearLayout mediaLayout;

    public HomeNewsFeedViewHolder(View itemView) {
        super(itemView);
        playerView = (SimpleExoPlayerView) itemView.findViewById(R.id.player);
        textViewUsername = (TextView) itemView.findViewById(R.id.nameuser);
        textViewDesc = (TextView) itemView.findViewById(R.id.description2);
        textViewLikes = (TextView) itemView.findViewById(R.id.textView6);
        textLikes = (TextView) itemView.findViewById(R.id.textView50);
        Likes = (ImageView) itemView.findViewById((R.id.imageView9));
        Dislikes = (ImageView) itemView.findViewById((R.id.imageView26));
        textViewComments = (TextView) itemView.findViewById(R.id.textView7);
        textComments = (TextView) itemView.findViewById(R.id.textView51);
        Commen = (ImageView) itemView.findViewById((R.id.imageView10));
        Share = (ImageView) itemView.findViewById((R.id.imageView11));
        textViewShare = (TextView) itemView.findViewById(R.id.textView9);
        textCommentsLink = (TextView) itemView.findViewById(R.id.comments_link);
        textViewCountComment = (TextView) itemView.findViewById(R.id.textView52);
        textViewComments2 = (TextView) itemView.findViewById(R.id.textView53);
        textViewTime = (TextView) itemView.findViewById(R.id.time_posted);
        mediaLayout = (LinearLayout)itemView.findViewById(R.id.media_layout);
    }

    @Override public View getPlayerView() {
        return playerView;
    }

    @Override public PlaybackInfo getCurrentPlaybackInfo() {
        return helper != null ? helper.getLatestPlaybackInfo() : new PlaybackInfo();
    }

    @Override
    public void initialize(Container container, PlaybackInfo playbackInfo) {
        if (helper == null) {
            helper = new SimpleExoPlayerViewHelper(container, this, mediaUri);
        }
        helper.initialize(playbackInfo);
    }

    @Override public void play() {
        if (helper != null) helper.play();
    }

    @Override public void pause() {
        if (helper != null) helper.pause();
    }

    @Override public boolean isPlaying() {
        return helper != null && helper.isPlaying();
    }

    @Override public void release() {
        if (helper != null) {
            helper.release();
            helper = null;
        }
    }

    @Override public boolean wantsToPlay() {
        return ToroUtil.visibleAreaOffset(this, itemView.getParent()) >= 0.85;
    }

    @Override public int getPlayerOrder() {
        return getAdapterPosition();
    }

    public void bind(Uri media) {
        this.mediaUri = media;
    }
}