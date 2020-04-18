package com.kylee.api;

import com.kylee.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface StoryService {

    @GET("/manga-reader/story-list")
    Call<JsonResponse< ArrayList<Story> >> getStoryList(
            @Query("type_href") String typeHref,
            @Query("page") int page,
            @Query("sort") int sort);

    @GET("/manga-reader/type-list")
    Call<JsonResponse< ArrayList<HrefTitle> >> getTypeList();

    @GET("/manga-reader/story-detail")
    Call<JsonResponse< StoryDetail>> getStoryDetail(
            @Query("story_href") String storyHref);

    @GET("/manga-reader/list-chapters")
    Call<JsonResponse< ArrayList<HrefTitleDate> >> getStoryChapters(
            @Query("story_href") String storyHref);

    @GET("/manga-reader/chapter-detail")
    Call<JsonResponse< ArrayList<String> >> getChapterDetail(
            @Query("chapter_href") String chapterHref,
            @Query("result_type") String resultType);

    @GET("/manga-reader/story-search")
    Call<JsonResponse< ArrayList<Story> >> getStorySearch(
            @Query("q") String q,
            @Query("page") int page);
}
