package com.kylee.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HrefTitle {
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("title")
    @Expose
    private String title;


    // Getter Methods

    public String getHref() {
        return href;
    }

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setHref(String href) {
        this.href = href;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
