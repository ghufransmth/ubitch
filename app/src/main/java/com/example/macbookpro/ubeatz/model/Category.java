package com.example.macbookpro.ubeatz.model;

public class Category {
    private static final String TAG = "Category";

    private String categoryName;

    public Category(String categoryName) {
        super();
        this.setCategoryName(categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String followersName) {
        this.categoryName = categoryName;
    }
}
