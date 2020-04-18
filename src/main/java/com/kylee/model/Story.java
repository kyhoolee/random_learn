package com.kylee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Story {
    @SerializedName("cover_url")
    @Expose
    private String cover_url;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("idx")
    @Expose
    private float idx;
    @SerializedName("latest_chapter")
    @Expose
    HrefTitle latest_chapter;
    @SerializedName("more_info")
    @Expose
    StoryMoreInfo more_info;
    @SerializedName("time_ago")
    @Expose
    private String time_ago;
    @SerializedName("title")
    @Expose
    private String title;


    public HrefTitle getLatest_chapter() {
        return latest_chapter;
    }

    public void setLatest_chapter(HrefTitle latest_chapter) {
        this.latest_chapter = latest_chapter;
    }

    public StoryMoreInfo getMore_info() {
        return more_info;
    }

    public void setMore_info(StoryMoreInfo more_info) {
        this.more_info = more_info;
    }

    // Getter Methods

    public String getCover_url() {
        return cover_url;
    }

    public String getHref() {
        return href;
    }

    public float getIdx() {
        return idx;
    }



    public String getTime_ago() {
        return time_ago;
    }

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setIdx(float idx) {
        this.idx = idx;
    }


    public void setTime_ago(String time_ago) {
        this.time_ago = time_ago;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}



