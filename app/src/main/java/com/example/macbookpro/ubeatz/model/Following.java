package com.example.macbookpro.ubeatz.model;

public class Following {
    private static final String TAG = "Following";

//    private String followingName;
//    private int followingImg;

    private String id_user;
    private String id;
    private String person;
    private int img;

    public Following(String id_user, String id, String person, int img) {
        this.id_user = id_user;
        this.id      = id;
        this.person  = person;
        this.img     = img;
//        super();
//        this.setFollowingImg(followingImg);
//        this.setFollowingName(followingName);
    }

    public String getIdUser() {
        return id_user;
    }

    public String getIds() {
        return id;
    }

    public String getPerson() {
        return person;
    }

    public int getImg() {
        return img;
    }

    public void setIdUser(String id_user) {
        this.id_user = id_user;
    }

    public void setIds(String id) {
        this.id = id;
    }

    public void setPerson(String person) {
        this.person = person;
    }

//    public String getFollowingName() {
//        return followingName;
//    }
//
//    public void setFollowingName(String followingName) {
//        this.followingName = followingName;
//    }
//
//    public int getImg() {
//        return followingImg;
//    }
//
//    public void setFollowingImg(int followingImg) {
//        this.followingImg = followingImg;
//    }
}
