package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.adapter.followersAdapter;
import com.example.macbookpro.ubeatz.adapter.followingAdapter;
import com.example.macbookpro.ubeatz.adapter.searchLocationAdapter;
import com.example.macbookpro.ubeatz.model.Followers;
import com.example.macbookpro.ubeatz.model.Location;
import com.example.macbookpro.ubeatz.response.responsefollowers;
import com.example.macbookpro.ubeatz.response.responsefollowing;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class followers extends AppCompatActivity implements followersAdapter.followersListener{

    private static final String TAG = "ListViewActivity";

    private followersAdapter followersArrayAdapter;
    private ListView listView;
    private ImageView imgView;
    private TextView follow;
    BaseApiService mApiService;
    Context mContext;
    private followersAdapter adapter;
    SharedPrefManager sharedPrefManager;
    EditText sessionID;
    ArrayList<Followers> followersList;

    private static int colorIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        getSupportActionBar().hide();

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        //Menampilkan data session
//        ButterKnife.bind(this);
//        sharedPrefManager = new SharedPrefManager(this);
//        follow.setText(sharedPrefManager.getSpUsername());

        follow = (TextView) findViewById(R.id.textView5);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        follow.setTypeface(typeface);

        colorIndex = 0;
        listView = (ListView) findViewById(R.id.listView);
//        followersArrayAdapter = new followersAdapter(this, R.layout.layout_custom_followers);
//        listView.setAdapter(followersArrayAdapter);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        sessionID=(EditText) findViewById(R.id.sessionID);
        sessionID.setText(sharedPrefManager.getSpId());
        sessionID.setVisibility(View.GONE);
        followersGet();

//        List<String[]> followersList = readData();
//        for (String[] followersData : followersList) {
//            String followersImg = followersData[0];
//            String followersName = followersData[1];
//            int followersImgResId = getResources().getIdentifier(followersImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");
//
//            Followers followers = new Followers(followersImgResId, followersName);
//            followersArrayAdapter.add(followers);
//        }
    }

    private void followersGet(){
        //Menampilkan data session
        Call<responsefollowers> call = mApiService.getMyFollowersRequest(sessionID.getText().toString());
        call.enqueue(new Callback<responsefollowers>() {
            @Override
            public void onResponse(Call<responsefollowers> call, Response<responsefollowers> response) {

                Log.d("TAG",response.code()+"");

                responsefollowers resource = response.body();
                followersList = resource.datafollower;

                adapter = new followersAdapter(mContext, followersList, followers.this);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<responsefollowers> call, Throwable t) {
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onfollowSelected(Followers off) {

        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertFollowingRequest(off.getIdUser(),sessionID.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(mContext, "Following", Toast.LENGTH_SHORT).show();
                followersGet();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onunfollowSelected(Followers off) {

        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertUnfollowingRequest(off.getIdUser(),sessionID.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(mContext, "Unfollow", Toast.LENGTH_SHORT).show();
                followersGet();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    public List<String[]> readData() {
//        List<String[]> resultList = new ArrayList<String[]>();
//
//        String[] followers7 = new String[3];
//        followers7[0] = "ic_profile";
//        followers7[1] = "alamsutera";
//        resultList.add(followers7);
//
//        String[] followers1 = new String[3];
//        followers1[0] = "ic_profile";
//        followers1[1] = "ujungpandang";
//        resultList.add(followers1);
//
//
//        String[] followers3 = new String[3];
//        followers3[0] = "ic_profile";
//        followers3[1] = "manado";
//        resultList.add(followers3);
//
//        String[] followers4 = new String[3];
//        followers4[0] = "ic_profile";
//        followers4[1] = "kemang";
//        resultList.add(followers4);
//
//        String[] followers10 = new String[3];
//        followers10[0] = "ic_profile";
//        followers10[1] = "citos";
//        resultList.add(followers10);
//
//        String[] followers5 = new String[3];
//        followers5[0] = "ic_profile";
//        followers5[1] = "plazasenayan";
//        resultList.add(followers5);
//
//
//        String[] followers2 = new String[3];
//        followers2[0] = "ic_profile";
//        followers2[1] = "jaksel";
//        resultList.add(followers2);
//
//        String[] followers6 = new String[3];
//        followers6[0] = "ic_profile";
//        followers6[1] = "kendal";
//        resultList.add(followers6);
//
//        String[] followers8 = new String[3];
//        followers8[0] = "ic_profile";
//        followers8[1] = "cikini";
//        resultList.add(followers8);
//
//        String[] followers9 = new String[3];
//        followers9[0] = "ic_profile";
//        followers9[1] = "gambir";
//        resultList.add(followers9);
//
//        String[] followers11 = new String[3];
//        followers11[0] = "ic_profile";
//        followers11[1] = "bankindonesia";
//        resultList.add(followers11);
//
//        return resultList;
//    }
}
