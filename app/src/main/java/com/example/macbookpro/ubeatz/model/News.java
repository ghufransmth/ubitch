package com.example.macbookpro.ubeatz.model;

public class News {
    private String id;
    private String id_user;
    private String post_by;
    private String news;
    private String image;
    private String likes;
    private String tot;
    private String comments;
    private String created_at;

//    public AttendanceItem(String id,String username,String image, String created_on, String time) {
//        this.id = id;
//        this.username = username;
//        this.image = image;
//        this.created_on = created_on;
//        this.time = time;
//    }

    public News(String id,String id_user,String post_by,String news,String image,String likes,String tot,String comments,String created_at) {
        this.id = id;
        this.id_user = id_user;
        this.post_by = post_by;
        this.news = news;
        this.image = image;
        this.likes = likes;
        this.tot = tot;
        this.comments = comments;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return id_user;
    }

    public String getPostBy() {
        return post_by;
    }

    public String getNews() {
        return news;
    }

    public String getImages() {
        return image;
    }

    public String getLikes() {
        return likes;
    }

    public String getTot() {
        return tot;
    }

    public String getComments() {
        return comments;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setIdUser(String id_user){
        this.id_user = id_user;
    }

    public void setPostBy(String post_by){
        this.post_by = post_by;
    }

    public void setNews(String news){
        this.news = news;
    }

    public void setImages(String image){
        this.image = image;
    }

    public void setLikes(String likes){
        this.likes = likes;
    }

    public void setTot(String tot){
        this.tot = tot;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public void setCreatedAt(String created_at){
        this.created_at = created_at;
    }
}
