package com.example.macbookpro.ubeatz;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*import com.pierfrancescosoffritti.androidyoutubeplayer.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerListener;*/

public class song_detail_youtube extends AppCompatActivity {

    //YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail_youtube);

        /*youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(final YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new YouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        String videoId = "5L9v3RajmdA";
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
        }, true);*/
    }
}
