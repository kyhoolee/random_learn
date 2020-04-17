package com.kylee.api;

import com.kylee.model.Story;
import com.kylee.model.StoryList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ApiUtils {

    //https://pizza.yobimind.com/manga-reader/story-list?type_href=http://truyenqq.com/the-loai/adult-68.html&page=2
    public static final String BASE_URL = "https://pizza.yobimind.com";

    public static StoryService getStoryService() {
        return RetrofitClient.getClient(BASE_URL).create(StoryService.class);
    }


    public static void main(String[] args) {
        StoryService mService = ApiUtils.getStoryService();

        Call<StoryList> c = mService.getStoryList();
        c.enqueue(new Callback<StoryList>() {
            @Override
            public void onResponse(Call<StoryList> call, Response<StoryList> response) {
                System.out.println(response.toString());
                System.out.println(response.isSuccessful());

                if(response.isSuccessful()) {
                    StoryList s = response.body();
                    List<Story> ls = s.getData();
                    int i = 0;
                    for(Story story : ls) {
                        i ++;
                        System.out.println(i + " -- " + story);
                    }
                }
            }

            @Override
            public void onFailure(Call<StoryList> call, Throwable t) {

            }
        });
    }
}