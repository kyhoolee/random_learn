package com.kylee.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoryList {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("data")
    @Expose
    private ArrayList<Story> data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Story> getData() {
        return data;
    }

    public void setData(ArrayList<Story> data) {
        this.data = data;
    }
}
