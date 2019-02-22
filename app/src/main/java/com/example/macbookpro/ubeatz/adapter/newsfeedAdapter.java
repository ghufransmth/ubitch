package com.example.macbookpro.ubeatz.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.macbookpro.ubeatz.R;
import com.example.macbookpro.ubeatz.findbox_detail;
import com.example.macbookpro.ubeatz.model.Findbox;
import com.example.macbookpro.ubeatz.model.Newsfeed;

import java.util.List;

public class newsfeedAdapter extends ArrayAdapter<Newsfeed> {
    private Activity context;
    List<Newsfeed> newsfeed;
    MediaController mediaController;
    Uri video;
    VideoView videoView;
    private static final String VIDEO_URL = "http://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4";


    public newsfeedAdapter(Activity context, List<Newsfeed> newsfeed) {
        super(context, R.layout.layout_custom_newsfeed_listview, newsfeed);
        this.context = context;
        this.newsfeed = newsfeed;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_custom_newsfeed_listview, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.nameuser);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.description2);
        videoView = (VideoView) listViewItem.findViewById((R.id.video_view));

        Typeface typeface = ResourcesCompat.getFont(context, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(context, R.font.petitamedium);
        textViewName.setTypeface(typeface2);
        textViewDesc.setTypeface(typeface2);

        Newsfeed track = newsfeed.get(position);
        textViewName.setText(track.getNama());
        textViewDesc.setText(track.getDeskripsi());
        // Memulai MediaController
//        mediaController = new MediaController(context);
//        mediaController.setAnchorView(videoView);
//        // Video URL
//        video = Uri.parse(VIDEO_URL);
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(video);
//        videoView.requestFocus();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            // Menutup pDialog dan play video
//            public void onPrepared(MediaPlayer mp) {
//                videoView.start();
//            }
//        });

        return listViewItem;
    }
}
