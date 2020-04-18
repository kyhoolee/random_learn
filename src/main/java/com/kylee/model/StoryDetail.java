package com.kylee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoryDetail {
    @SerializedName("author")
    @Expose
    private HrefTitle author;

    @SerializedName("cover_url")
    @Expose
    private String cover_url;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("first_chapter_url")
    @Expose
    String first_chapter_url;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("tags")
    @Expose
    public ArrayList< HrefTitle > tags = new ArrayList < HrefTitle > ();

    @SerializedName("title")
    @Expose
    private String title;


    public HrefTitle getAuthor() {
        return author;
    }

    public void setAuthor(HrefTitle author) {
        this.author = author;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_chapter_url() {
        return first_chapter_url;
    }

    public void setFirst_chapter_url(String first_chapter_url) {
        this.first_chapter_url = first_chapter_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<HrefTitle> getTags() {
        return tags;
    }

    public void setTags(ArrayList<HrefTitle> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
