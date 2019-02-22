package com.example.macbookpro.ubeatz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.adapter.newsAdapter;
import com.example.macbookpro.ubeatz.model.News;
import com.example.macbookpro.ubeatz.model.Newsfeed;
import com.example.macbookpro.ubeatz.response.responsenewsfeed;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;
import com.google.firebase.database.DatabaseReference;
import com.volokh.danylo.visibility_utils.calculator.DefaultSingleItemCalculatorCallback;
import com.volokh.danylo.visibility_utils.calculator.ListItemsVisibilityCalculator;
import com.volokh.danylo.visibility_utils.calculator.SingleListViewItemActiveCalculator;
import com.volokh.danylo.visibility_utils.scroll_utils.RecyclerViewItemPositionGetter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.FacebookSdk.getApplicationContext;

public class newsfeedFragment extends Fragment implements newsAdapter.NewsfeedListener{

    private Button mainmenu;
    // [START define_database_reference]
    private DatabaseReference mDatabase;
    List<Newsfeed> newsfeeds;
    ArrayList<News> newsfeedsList;
    ListView listViewNewsfeed;
    private newsAdapter adapter;
    EditText sessionID;
    RecyclerView recyclerView;
    TextView id;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
//    private final ListItemsVisibilityCalculator mListItemVisibilityCalculator =
//            new SingleListViewItemActiveCalculator(new DefaultSingleItemCalculatorCallback(), newsfeedsList);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newsfeed,container,false);



//        TextView username = (TextView) view.findViewById(R.id.username);
        id = (TextView) view.findViewById(R.id.textView6);
        TextView textView7 = (TextView) view.findViewById(R.id.textView7);
        TextView textView9 = (TextView) view.findViewById(R.id.textView9);
        TextView description = (TextView) view.findViewById(R.id.name);
//        TextView description2 = (TextView) view.findViewById(R.id.description2);
        TextView comments_link = (TextView) view.findViewById(R.id.comments_link);
        TextView time_posted = (TextView) view.findViewById(R.id.time_posted);
        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(getActivity(), R.font.petitamedium);
        sessionID=(EditText) view.findViewById(R.id.sessionID);
        sessionID.setVisibility(View.INVISIBLE);
//        username.setTypeface(typeface);
//        textView6.setTypeface(typeface2);
//        textView7.setTypeface(typeface2);
//        textView9.setTypeface(typeface2);
//        description.setTypeface(typeface2);
//        description2.setTypeface(typeface2);
//        comments_link.setTypeface(typeface2);
//        time_posted.setTypeface(typeface2);

        //FIREBASE NEWSFEED//
//        newsfeeds = new ArrayList<>();
//        mDatabase = FirebaseDatabase.getInstance().getReference("newsfeed");
//        listViewNewsfeed = (ListView) view.findViewById(R.id.listView);
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                newsfeeds.clear();
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    Newsfeed locate = postSnapshot.getValue(Newsfeed.class);
//                    newsfeeds.add(locate);
//                }
//                newsfeedAdapter trackListAdapter = new newsfeedAdapter(getActivity(), newsfeeds);
//                listViewNewsfeed.setAdapter(trackListAdapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
//                mScrollState = scrollState;
//                if(scrollState == RecyclerView.SCROLL_STATE_IDLE && !mList.isEmpty()){
//
//                    mListItemVisibilityCalculator.onScrollStateIdle(
//                            mItemsPositionGetter,
//                            mLayoutManager.findFirstVisibleItemPosition(),
//                            mLayoutManager.findLastVisibleItemPosition());
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                if(!mList.isEmpty()){
//                    mListItemVisibilityCalculator.onScroll(
//                            mItemsPositionGetter,
//                            mLayoutManager.findFirstVisibleItemPosition(),
//                            mLayoutManager.findLastVisibleItemPosition() - mLayoutManager.findFirstVisibleItemPosition() + 1,
//                            mScrollState);
//                }
//            }
//        });
//
//        mItemsPositionGetter = new RecyclerViewItemPositionGetter(mLayoutManager, mRecyclerView);



        ButterKnife.bind(getActivity());
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(getActivity());

        sessionID.setText(sharedPrefManager.getSpId());

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getMyNewsFeedRequest();


        return view;
    }

    public interface ListItem {
        int getVisibilityPercents(View view);
        void setActive(View newActiveView, int newActiveViewPosition);
        void deactivate(View currentView, int position);
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if(!mList.isEmpty()){
//            // need to call this method from list view handler in order to have filled list
//
//            recyclerView.post(new Runnable() {
//                @Override
//                public void run() {
//
//                    mListItemVisibilityCalculator.onScrollStateIdle(
//                            mItemsPositionGetter,
//                            mLayoutManager.findFirstVisibleItemPosition(),
//                            mLayoutManager.findLastVisibleItemPosition());
//
//                }
//            });
//        }
//    }

    private void getMyNewsFeedRequest(){
        //Menampilkan data session
        Call<responsenewsfeed> call = mApiService.getMyNewsFeedRequest(sessionID.getText().toString());
        call.enqueue(new Callback<responsenewsfeed>() {
            @Override
            public void onResponse(Call<responsenewsfeed> call, Response<responsenewsfeed> response) {

                Log.d("TAG",response.code()+"");

                responsenewsfeed resource = response.body();
                newsfeedsList = resource.datanews;

                adapter = new newsAdapter(getActivity(), newsfeedsList, newsfeedFragment.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<responsenewsfeed> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNewsfeedLikeSelected(News off) {
        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertLikesRequest(sessionID.getText().toString(),off.getId());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Likes", Toast.LENGTH_SHORT).show();
                getMyNewsFeedRequest();
//                adapter.notifyDataSetChanged();
//                adapter.notifyDataSetChanged();
//                String update = "Approve Timeoff";
//                updateHistory(update);
//                ((ApproveTimeoffActivity) mContext).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNewsfeedDislikeSelected(News off) {
        mApiService = UtilsApi.getAPIService();
        Call<ResponseBody> call = mApiService.getInsertDislikesRequest(sessionID.getText().toString(),off.getId());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Unlikes", Toast.LENGTH_SHORT).show();
                getMyNewsFeedRequest();
//                adapter.notifyDataSetChanged();
//                adapter.notifyDataSetChanged();
//                String update = "Approve Timeoff";
//                updateHistory(update);
//                ((ApproveTimeoffActivity) mContext).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNewsfeedDetail(News off) {

    }


}
