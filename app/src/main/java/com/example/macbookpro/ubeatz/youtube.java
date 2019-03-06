package com.example.macbookpro.ubeatz;

import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerListener;

public class youtube extends AppCompatActivity{
    /*public static final String API_KEY = "AIzaSyBx7v0YOb140fDO7EbfMx4l87raxezDWFw";
    public static final String VIDEO_ID = "-m3V8w_7vhk";
    // YouTube player view
    private YouTubePlayerView youTubeView;*/

    YouTubePlayerView youTubePlayerView;
    //YouTubePlayer youTubePlayer;
    Boolean isPlaying = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        /*youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        // Initializing video player with developer key
        youTubeView.initialize(API_KEY, this);*/

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        //View customUiView = youTubePlayerView.inflateCustomPlayerUI(R.layout.custome_uicontroller_youtube);
        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(final com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new YouTubePlayerListener() {
                    @Override
                    public void onReady() {

                        String videoId = "K2p6T1-2QGU";
                        initializedYouTubePlayer.loadVideo(videoId, 0);
                    }

                    @Override
                    public void onStateChange(@NonNull PlayerConstants.PlayerState state) {

                    }

                    @Override
                    public void onPlaybackQualityChange(@NonNull PlayerConstants.PlaybackQuality playbackQuality) {

                    }

                    @Override
                    public void onPlaybackRateChange(@NonNull PlayerConstants.PlaybackRate playbackRate) {

                    }

                    @Override
                    public void onError(@NonNull PlayerConstants.PlayerError error) {

                    }

                    @Override
                    public void onApiChange() {

                    }

                    @Override
                    public void onCurrentSecond(float second) {

                    }

                    @Override
                    public void onVideoDuration(float duration) {

                    }

                    @Override
                    public void onVideoLoadedFraction(float loadedFraction) {

                    }

                    @Override
                    public void onVideoId(@NonNull String videoId) {

                    }
                });
            }
        }, true);

        /*Button playPauseButton = customUiView.findViewById(R.id.play_pause_button);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying)
                {
                    youTubePlayer.pause();
                }
                else
                {
                    youTubePlayer.play();
                }
                isPlaying = !isPlaying;
            }
        });*/

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        youTubePlayerView.release();
    }
    /*
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if(null== player) return;

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }

        // Add listeners to YouTubePlayer instance
        player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override public void onAdStarted() { }
            @Override public void onError(YouTubePlayer.ErrorReason arg0) { }
            @Override public void onLoaded(String arg0) { }
            @Override public void onLoading() { }
            @Override public void onVideoEnded() { }
            @Override public void onVideoStarted() { }
        });


        player.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
            @Override public void onBuffering(boolean arg0) { }
            @Override public void onPaused() { }
            @Override public void onPlaying() { }
            @Override public void onSeekTo(int arg0) { }
            @Override public void onStopped() { }
        });
    }*/
}
