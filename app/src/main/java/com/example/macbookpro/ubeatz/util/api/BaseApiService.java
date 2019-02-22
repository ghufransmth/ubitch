package com.example.macbookpro.ubeatz.util.api;


import com.example.macbookpro.ubeatz.model.NewSong;
import com.example.macbookpro.ubeatz.response.responsecomment;
import com.example.macbookpro.ubeatz.response.responsefollowers;
import com.example.macbookpro.ubeatz.response.responsefollowing;
import com.example.macbookpro.ubeatz.response.responsefriends;
import com.example.macbookpro.ubeatz.response.responsenewsfeed;
import com.example.macbookpro.ubeatz.util.ServerResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by Ghufran on 11/26/2017.
 */

public interface BaseApiService {
    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
    @FormUrlEncoded
    @POST("users/login")
    Call<ResponseBody> loginRequest(@Field("userid") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("users/register")
    Call<ResponseBody> registerRequest(@Field("username") String username,
                                       @Field("password") String password,
                                       @Field("fullname") String fullname,
                                       @Field("email") String email,
                                       @Field("phone") String phone,
                                       @Field("address") String address,
                                       @Field("city") String city,
                                       @Field("country") String country,
                                       @Field("profile_pic") String profile_pic);

//    @Multipart
//    @POST("users/updatedata")
//    Call<ResponseBody> updateprofileRequest(@Part("id") RequestBody id,
//                                       @Part("fullname") RequestBody fullname,
//                                       @Part("username") RequestBody username,
//                                       @Part("bio") RequestBody bio,
//                                       @Part("email") RequestBody email,
//                                       @Part("birthday") RequestBody birthday,
//                                       @Part("phone") RequestBody phone,
//                                       @Part("gender") RequestBody gender, @Part MultipartBody.Part photo);

    @Multipart
    @POST("users/updatedata")
    Call<ResponseBody> updateprofileRequest(@Part MultipartBody.Part photo,
                                            @PartMap Map<String,RequestBody> text);

    @FormUrlEncoded
    @POST("users/verify")
    Call<ResponseBody> verifyRequest(@Field("email") String email,
                                    @Field("kode") String kode);

//    @FormUrlEncoded
//    @POST("users/getMyFollowers")
//    Call<ResponseBody> getMyFollowersRequest(@Field("id") String id);

    @FormUrlEncoded
    @POST("users/detail_profile")
    Call<ResponseBody> getMyProfileRequest(@Field("id_user") String id);

    @FormUrlEncoded
    @POST("users/getMyFriends")
    Call<responsefriends> getMyFriendsRequest(@Field("id_user") String id);

    @FormUrlEncoded
    @POST("users/add_friend")
    Call<ResponseBody> getInsertFriendRequest(@Field("id_user") String id_user,@Field("id_friend") String id_friend);

    @FormUrlEncoded
    @POST("users/getMyNewsFeed")
    Call<responsenewsfeed> getMyNewsFeedRequest(@Field("id_user") String id);

    @FormUrlEncoded
    @POST("users/getMyFollowing")
    Call<responsefollowing> getMyFollowingRequest(@Field("id_user") String id);

    @FormUrlEncoded
    @POST("users/getMyFollowers")
    Call<responsefollowers> getMyFollowersRequest(@Field("id_user") String id);

    @FormUrlEncoded
    @POST("users/add_feedback")
    Call<ResponseBody> getInsertFeedbackRequest(@Field("id_user") String id_user,@Field("feedback") String feedback);

    @FormUrlEncoded
    @POST("users/following")
    Call<ResponseBody> getInsertFollowingRequest(@Field("id_user") String id_user,@Field("id_follower") String id_follower);

    @FormUrlEncoded
    @POST("users/unfollowing")
    Call<ResponseBody> getInsertUnfollowingRequest(@Field("id_user") String id_user,@Field("id_follower") String id_follower);

    @FormUrlEncoded
    @POST("users/getIdNewsFeed")
    Call<ResponseBody> getIdNewsFeedRequest(@Field("id") String id);

    @FormUrlEncoded
    @POST("users/getIdComment")
    Call<responsecomment> getIdCommentRequest(@Field("id") String id);

    @FormUrlEncoded
    @POST("users/add_comment")
    Call<ResponseBody> getaddCommentRequest(@Field("id_user") String id_user,@Field("id_news") String id_news,@Field("comment") String comment);

    @FormUrlEncoded
    @POST("users/insert_like")
    Call<ResponseBody> getInsertLikesRequest(@Field("id_user") String id_user,@Field("id_news") String id_news);

    @FormUrlEncoded
    @POST("users/insert_dislike")
    Call<ResponseBody> getInsertDislikesRequest(@Field("id_user") String id_user,@Field("id_news") String id_news);

    @GET("musics/new_judul")
    Call<List<NewSong>> getNewSongRequest();


}
