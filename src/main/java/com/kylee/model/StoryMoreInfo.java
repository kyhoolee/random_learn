package com.kylee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoryMoreInfo {
    @SerializedName("excerpt")
    @Expose
    private String excerpt;

    @SerializedName("stat_info")
    @Expose
    public ArrayList< String > stat_info = new ArrayList< String >();
    @SerializedName("tags")
    @Expose
    public ArrayList < HrefTitle > tags = new ArrayList < HrefTitle > ();


    // Getter Methods

    public String getExcerpt() {
        return excerpt;
    }

    // Setter Methods

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
