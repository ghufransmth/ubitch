package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.content.Intent;
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

import com.example.macbookpro.ubeatz.adapter.commentAdapter;
import com.example.macbookpro.ubeatz.adapter.followingAdapter;
import com.example.macbookpro.ubeatz.adapter.newReleaseSongAdapter;
import com.example.macbookpro.ubeatz.adapter.newsAdapter;
import com.example.macbookpro.ubeatz.model.Comment;
import com.example.macbookpro.ubeatz.model.Following;
import com.example.macbookpro.ubeatz.model.NewSong;
import com.example.macbookpro.ubeatz.model.News;
import com.example.macbookpro.ubeatz.response.responsecomment;
import com.example.macbookpro.ubeatz.response.responsefollowing;
import com.example.macbookpro.ubeatz.response.responsenewsfeed;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class comment extends AppCompatActivity {

    BaseApiService mApiService;
    Context mContext;
    SharedPrefManager sharedPrefManager;
    TextView textView55,textView56,textView57;
    EditText editText4,sessionID;
    ImageView imgView,imageView27;
    ArrayList<Comment> commentList;
    ArrayList<Following> followingList;
    private commentAdapter adapter;
    ListView list;
    private Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        textView55 = (TextView) findViewById(R.id.textView55);
        textView56 = (TextView) findViewById(R.id.textView56);
        textView57 = (TextView) findViewById(R.id.textView57);
        editText4 = (EditText) findViewById(R.id.editText4);
        sessionID = (EditText) findViewById(R.id.sessionID);
        list = (ListView) findViewById(R.id.listView);
        imageView27 = (ImageView) findViewById(R.id.imageView27);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        textView55.setTypeface(typeface2);
        textView56.setTypeface(typeface2);
        textView57.setTypeface(typeface2);
        editText4.setTypeface(typeface2);
        commentGet(sharedPrefManager.getSpIdNews());
        CommentDetail(sharedPrefManager.getSpIdNews());
        imageView27.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendComment(sharedPrefManager.getSpId(),sharedPrefManager.getSpIdNews(),editText4.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void commentGet(String id){
        //Menampilkan data session
        Call<responsecomment> call = mApiService.getIdCommentRequest(id);
        call.enqueue(new Callback<responsecomment>() {
            @Override
            public void onResponse(Call<responsecomment> call, Response<responsecomment> response) {

                Log.d("TAG",response.code()+"");

                responsecomment resource = response.body();
                commentList = resource.datacomment;

                adapter = new commentAdapter(mContext, commentList);
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<responsecomment> call, Throwable t) {
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

//        Call<responsefollowing> call = mApiService.getMyFollowingRequest(sessionID.getText().toString());
//        call.enqueue(new Callback<responsefollowing>() {
//            @Override
//            public void onResponse(Call<responsefollowing> call, Response<responsefollowing> response) {
//
//                Log.d("TAG",response.code()+"");
//
//                responsefollowing resource = response.body();
//                followingList = resource.datafollow;
//
//                adapter = new followingAdapter(mContext, followingList, comment.this);
//                list.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<responsefollowing> call, Throwable t) {
//                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void CommentDetail(String id){
        //Menampilkan data session
        mApiService.getIdNewsFeedRequest(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RETURN);
                        if (result == true){
                            String news = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("news");
                            textView55.setText(news);
                        } else {
//                            String error_message = jsonRESULTS.getString("status");
//                            DialogForm(error_message);
////                                    DialogForm(error_message);
                            Toast.makeText(mContext, "Tidak dapat menampilkan", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(mContext, "Gagal login", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void sendComment(String id_user, String id_news, String comment){
        mApiService.getaddCommentRequest(id_user, id_news, comment).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                editText4.setText("");
                commentGet(sharedPrefManager.getSpIdNews());
//                if (response.isSuccessful()){
//                    try {
//                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                        result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RETURN);
//                        if (result == true){
//                            Toast.makeText(mContext, "sukses", Toast.LENGTH_SHORT).show();
//                        } else {
////                            String error_message = jsonRESULTS.getString("status");
////                            DialogForm(error_message);
//////                                    DialogForm(error_message);
//                            Toast.makeText(mContext, "Tidak dapat menampilkan", Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Toast.makeText(mContext, "Gagal login", Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void oncommentSelected(Comment off) {
//
//
//    }


}
