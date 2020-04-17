package com.kylee.api;

import com.kylee.model.StoryList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StoryService {

    @GET("/manga-reader/story-list?type_href=http://truyenqq.com/the-loai/adult-68.html&page=2")
    Call<StoryList> getStoryList();
}
