package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.adapter.followingAdapter;
import com.example.macbookpro.ubeatz.adapter.newReleaseSongAdapter;
import com.example.macbookpro.ubeatz.adapter.newsAdapter;
import com.example.macbookpro.ubeatz.adapter.searchLocationAdapter;
import com.example.macbookpro.ubeatz.model.Following;
import com.example.macbookpro.ubeatz.model.Location;
import com.example.macbookpro.ubeatz.model.NewSong;
import com.example.macbookpro.ubeatz.response.responsefollowing;
import com.example.macbookpro.ubeatz.response.responsenewsfeed;
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

public class followingFragment extends Fragment implements followingAdapter.followingListener{
    private static final String TAG = "ListViewActivity";

    private followingAdapter followingArrayAdapter;
    private ListView listView;
    ArrayList<Following> followingList;
    BaseApiService mApiService;
    Context mContext;
    private followingAdapter adapter;
    SharedPrefManager sharedPrefManager;
    EditText sessionID;
    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_following, container, false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
        ButterKnife.bind(getActivity());
        mContext = getActivity();
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(getActivity());
        sessionID=(EditText) view.findViewById(R.id.sessionID);
        sessionID.setText(sharedPrefManager.getSpId());
        followingGet();
//        followingArrayAdapter = new followingAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_following);
//        listView.setAdapter(followingArrayAdapter);

//        List<String[]> followingList = readData();
//        for (String[] followingData : followingList) {
//            String followingImg = followingData[0];
//            String followingName = followingData[1];
//            int followingImgResId = getResources().getIdentifier(followingImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");
//
//            Following following = new Following(followingImgResId, followingName);
//            followingArrayAdapter.add(following);
//        }

        return view;
    }

    private void followingGet(){
        //Menampilkan data session
        Call<responsefollowing> call = mApiService.getMyFollowingRequest(sessionID.getText().toString());
        call.enqueue(new Callback<responsefollowing>() {
            @Override
            public void onResponse(Call<responsefollowing> call, Response<responsefollowing> response) {

                Log.d("TAG",response.code()+"");

                responsefollowing resource = response.body();
                followingList = resource.datafollow;

                adapter = new followingAdapter(getActivity(), followingList, followingFragment.this);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<responsefollowing> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onfollowSelected(Following off) {

        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertFollowingRequest(sessionID.getText().toString(),off.getIds());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Follow", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onunfollowSelected(Following off) {

        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertUnfollowingRequest(sessionID.getText().toString(),off.getIds());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Unfollow", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();

        String[] following7 = new String[3];
        following7[0] = "ic_profile";
        following7[1] = "alamsutera";
        resultList.add(following7);

        String[] following1 = new String[3];
        following1[0] = "ic_profile";
        following1[1] = "ujungpandang";
        resultList.add(following1);


        String[] following3 = new String[3];
        following3[0] = "ic_profile";
        following3[1] = "manado";
        resultList.add(following3);

        String[] following4 = new String[3];
        following4[0] = "ic_profile";
        following4[1] = "kemang";
        resultList.add(following4);

        String[] following10 = new String[3];
        following10[0] = "ic_profile";
        following10[1] = "citos";
        resultList.add(following10);

        String[] following5 = new String[3];
        following5[0] = "ic_profile";
        following5[1] = "plazasenayan";
        resultList.add(following5);


        String[] following2 = new String[3];
        following2[0] = "ic_profile";
        following2[1] = "jaksel";
        resultList.add(following2);

        String[] following6 = new String[3];
        following6[0] = "ic_profile";
        following6[1] = "kendal";
        resultList.add(following6);

        String[] following8 = new String[3];
        following8[0] = "ic_profile";
        following8[1] = "cikini";
        resultList.add(following8);

        String[] following9 = new String[3];
        following9[0] = "ic_profile";
        following9[1] = "gambir";
        resultList.add(following9);

        String[] following11 = new String[3];
        following11[0] = "ic_profile";
        following11[1] = "bankindonesia";
        resultList.add(following11);

        return resultList;
    }
}
