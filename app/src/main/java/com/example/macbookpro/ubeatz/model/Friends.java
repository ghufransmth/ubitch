package com.example.macbookpro.ubeatz.model;

public class Friends {
    private static final String TAG = "Friends";

    private String id_user;
    private String fullname;
    private String profile_pic;

    public Friends(String id_user, String fullname, String profile_pic) {
        this.id_user        = id_user;
        this.fullname       = fullname;
        this.profile_pic    = profile_pic;
//        super();
//        this.setFriendsImg(friendsImg);
//        this.setFriendsName(friendsName);
    }

    public String getIdUser() {
        return id_user;
    }

    public void setIdUser(String id_user) {
        this.id_user = id_user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getProfilePic() {
        return profile_pic;
    }

    public void setProfilePic(String profile_pic) {
        this.profile_pic = profile_pic;
    }
}
