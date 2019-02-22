package com.example.macbookpro.ubeatz.model;

public class Followers {
    private static final String TAG = "Followers";

//    private String followersName;
//    private int followersImg;

    private String id_follower;
    private String fullname;
    private String profile_pic;
    private String following;

    public Followers(String id_follower, String fullname, String profile_pic, String following) {
        this.id_follower  = id_follower;
        this.fullname     = fullname;
        this.profile_pic  = profile_pic;
        this.following    = following;
        //        super();
//        this.setFollowersImg(followersImg);
//        this.setFollowersName(followersName);
    }

//    public String getFollowersName() {
//        return followersName;
//    }
//
//    public void setFollowersName(String followersName) {
//        this.followersName = followersName;
//    }
//
//    public int getImg() {
//        return followersImg;
//    }
//
//    public void setFollowersImg(int followersImg) {
//        this.followersImg = followersImg;
//    }

    public String getIdUser() {
        return id_follower;
    }

    public String getFullname() {
        return fullname;
    }

    public String getProfilePic() {
        return profile_pic;
    }

    public String getFollowing() {
        return following;
    }

    public void setIdUser(String id_follower) {
        this.id_follower = id_follower;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setProfilePic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setFollowing(String following) {
        this.following = following;
    }
}
