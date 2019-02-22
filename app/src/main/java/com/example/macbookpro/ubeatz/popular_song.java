package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.adapter.newReleaseSongAdapter;
import com.example.macbookpro.ubeatz.model.NewSong;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class popular_song extends AppCompatActivity {

    BaseApiService mApiService;
    Context mContext;
    private newReleaseSongAdapter adapter;
    //    ArrayList<NewSong> newSongList;
    ListView list;
    SharedPrefManager sharedPrefManager;
    TextView textView49;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_song);

        getSupportActionBar().hide();

        textView49 = (TextView) findViewById(R.id.textView49);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        textView49.setTypeface(typeface2);

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        list      = (ListView) findViewById(R.id.listView);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        PopularSong();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(popular_song.this,song_detail.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });
    }

    private void PopularSong(){
        //Menampilkan data session
        mApiService.getNewSongRequest()
                .enqueue(new Callback<List<NewSong>>() {
                    @Override
                    public void onResponse(Call<List<NewSong>> call, Response<List<NewSong>> response) {
                        Log.d("TAG",response.code()+"");
                        List<NewSong> newSongList = response.body();

                        adapter = new newReleaseSongAdapter(popular_song.this, newSongList);
                        list.setAdapter(adapter);


                    }

                    @Override
                    public void onFailure(Call<List<NewSong>> call, Throwable t) {
                        Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
