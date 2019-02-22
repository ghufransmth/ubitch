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
import com.example.macbookpro.ubeatz.adapter.friendsAdapter;
import com.example.macbookpro.ubeatz.model.Followers;
import com.example.macbookpro.ubeatz.model.Following;
import com.example.macbookpro.ubeatz.model.Friends;
import com.example.macbookpro.ubeatz.response.responsefollowing;
import com.example.macbookpro.ubeatz.response.responsefriends;
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

public class friendsFragment extends Fragment implements friendsAdapter.friendsListener{
    private static final String TAG = "ListViewActivity";

    private friendsAdapter friendsArrayAdapter;
    private ListView listView;
    EditText sessionID;
    BaseApiService mApiService;
    ArrayList<Friends> friendsList;
    Context mContext;
    private friendsAdapter adapter;
    SharedPrefManager sharedPrefManager;

    private static int colorIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        colorIndex = 0;
        listView = (ListView) view.findViewById(R.id.listView);
//        friendsArrayAdapter = new friendsAdapter(getActivity().getApplicationContext(), R.layout.layout_custom_friends);
//        listView.setAdapter(friendsArrayAdapter);
        ButterKnife.bind(getActivity());
        mContext = getActivity();
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(getActivity());
        sessionID=(EditText) view.findViewById(R.id.sessionID);
        sessionID.setText(sharedPrefManager.getSpId());
        sessionID.setVisibility(View.GONE);
        friendsGet(sharedPrefManager.getSpId());
//        List<String[]> friendsList = readData();
//        for (String[] friendsData : friendsList) {
//            String friendsImg = friendsData[0];
//            String friendsName = friendsData[1];
//            int friendsImgResId = getResources().getIdentifier(friendsImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");
//
//            Friends friends = new Friends(friendsImgResId, friendsName);
//            friendsArrayAdapter.add(friends);
//        }

        return view;
    }

    private void friendsGet(String id){
        //Menampilkan data session
        Call<responsefriends> call = mApiService.getMyFriendsRequest(id);
        call.enqueue(new Callback<responsefriends>() {
            @Override
            public void onResponse(Call<responsefriends> call, Response<responsefriends> response) {

                Log.d("TAG",response.code()+"");

                responsefriends resource = response.body();
                friendsList = resource.datafriends;

                adapter = new friendsAdapter(getActivity(), friendsList, friendsFragment.this);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<responsefriends> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void addfriend(Friends off) {

        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertFriendRequest(sessionID.getText().toString(),off.getIdUser());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Add Friend", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();

        String[] friends7 = new String[3];
        friends7[0] = "ic_profile";
        friends7[1] = "alamsutera";
        resultList.add(friends7);

        String[] friends1 = new String[3];
        friends1[0] = "ic_profile";
        friends1[1] = "ujungpandang";
        resultList.add(friends1);


        String[] friends3 = new String[3];
        friends3[0] = "ic_profile";
        friends3[1] = "manado";
        resultList.add(friends3);

        String[] friends4 = new String[3];
        friends4[0] = "ic_profile";
        friends4[1] = "kemang";
        resultList.add(friends4);

        String[] friends10 = new String[3];
        friends10[0] = "ic_profile";
        friends10[1] = "citos";
        resultList.add(friends10);

        String[] friends5 = new String[3];
        friends5[0] = "ic_profile";
        friends5[1] = "plazasenayan";
        resultList.add(friends5);


        String[] friends2 = new String[3];
        friends2[0] = "ic_profile";
        friends2[1] = "jaksel";
        resultList.add(friends2);

        String[] friends6 = new String[3];
        friends6[0] = "ic_profile";
        friends6[1] = "kendal";
        resultList.add(friends6);

        String[] friends8 = new String[3];
        friends8[0] = "ic_profile";
        friends8[1] = "cikini";
        resultList.add(friends8);

        String[] friends9 = new String[3];
        friends9[0] = "ic_profile";
        friends9[1] = "gambir";
        resultList.add(friends9);

        String[] friends11 = new String[3];
        friends11[0] = "ic_profile";
        friends11[1] = "bankindonesia";
        resultList.add(friends11);

        return resultList;
    }
}
