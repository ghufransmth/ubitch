package com.example.macbookpro.ubeatz.model;

public class Comment {

    private static final String TAG = "Comment";

    private String id;
    private String id_news;
    private String post_by;
    private String comment;
    private int image;
    private String created_at;

    public Comment(String id, String id_news, String post_by, String comment, int image, String created_at) {
        this.id = id;
        this.id_news  = id_news;
        this.post_by  = post_by;
        this.comment  = comment;
        this.image  = image;
        this.created_at  = created_at;
    }

    public String getId() {
        return id;
    }

    public String getIdNews() {
        return id_news;
    }

    public String getPostBy() {
        return post_by;
    }

    public String getComment() {
        return comment;
    }

    public int getImages() {
        return image;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setIdNews(String id_news){
        this.id_news = id_news;
    }

    public void setPostBy(String post_by){
        this.post_by = post_by;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setImages(int image){
        this.image = image;
    }

    public void setCreatedAt(String created_at){
        this.created_at = created_at;
    }
}
