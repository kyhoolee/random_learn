package com.kylee.api;

import com.kylee.model.HrefTitleDate;
import com.kylee.model.JsonResponse;
import com.kylee.model.Story;
import com.kylee.model.StoryDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class ApiUtils {

    //https://pizza.yobimind.com/manga-reader/story-list?type_href=http://truyenqq.com/the-loai/adult-68.html&page=2
    public static final String BASE_URL = "https://pizza.yobimind.com";

    public static StoryService getStoryService() {
        return RetrofitClient.getClient(BASE_URL).create(StoryService.class);
    }


    public static void main(String[] args) {
        //sampleStoryList();
        //sampleStoryDetail();
        //sampleListChapter();
        //sampleChapterDetail();
        sampleStorySearch();
    }

    public static void sampleStorySearch() {
        StoryService mService = ApiUtils.getStoryService();
        String q = "hoa phung";
        int page = 1;
        Call<JsonResponse< ArrayList<Story> > > c = mService.getStorySearch(q, page);
        c.enqueue(new Callback<JsonResponse< ArrayList<Story> > >() {
            @Override
            public void onResponse(Call<JsonResponse< ArrayList<Story> > > call, Response<JsonResponse< ArrayList<Story> > > response) {
                System.out.println(response.toString());
                System.out.println(response.isSuccessful());

                if(response.isSuccessful()) {
                    JsonResponse< ArrayList<Story> >  s = response.body();
                    List<Story> ls = s.getData();
                    int i = 0;
                    for(Story story : ls) {
                        i ++;
                        System.out.println(i + " -- " + story);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse< ArrayList<Story> > > call, Throwable t) {

            }
        });
    }

    public static void sampleChapterDetail() {
        StoryService mService = ApiUtils.getStoryService();
        String chapterHref = "http://truyenqq.com/truyen-tranh/hai-mat-8758-chap-15.html";
        //String resultType = "json";
        Call<JsonResponse< ArrayList<String>>> c = mService.getChapterDetail(chapterHref, "json");
        c.enqueue(new Callback<JsonResponse< ArrayList<String>>>() {
            @Override
            public void onResponse(Call<JsonResponse< ArrayList<String>>> call,
                                   Response<JsonResponse< ArrayList<String>>> response) {
                System.out.println(response.toString());
                System.out.println(response.isSuccessful());

                if(response.isSuccessful()) {
                    JsonResponse< ArrayList<String>> sd = response.body();
                    List<String> cs = sd.getData();
                    for(String c : cs) {
                        System.out.println(c);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse< ArrayList<String>>> call, Throwable t) {

            }
        });
    }

    public static void sampleListChapter() {
        StoryService mService = ApiUtils.getStoryService();
        String storyHref = "http://truyenqq.com/truyen-tranh/loser-5436";
        Call<JsonResponse< ArrayList<HrefTitleDate>>> c = mService.getStoryChapters(storyHref);
        c.enqueue(new Callback<JsonResponse< ArrayList<HrefTitleDate>>>() {
            @Override
            public void onResponse(Call<JsonResponse< ArrayList<HrefTitleDate>>> call,
                                   Response<JsonResponse< ArrayList<HrefTitleDate>>> response) {
                System.out.println(response.toString());
                System.out.println(response.isSuccessful());

                if(response.isSuccessful()) {
                    JsonResponse< ArrayList<HrefTitleDate>> sd = response.body();
                    List<HrefTitleDate> cs = sd.getData();
                    for(HrefTitleDate c : cs) {
                        System.out.println(c);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse< ArrayList<HrefTitleDate>>> call, Throwable t) {

            }
        });
    }

    public static void sampleStoryDetail() {
        StoryService mService = ApiUtils.getStoryService();
        String storyHref = "http://truyenqq.com/truyen-tranh/loser-5436";
        Call<JsonResponse< StoryDetail>> c = mService.getStoryDetail(storyHref);
        c.enqueue(new Callback<JsonResponse< StoryDetail>>() {
            @Override
            public void onResponse(Call<JsonResponse< StoryDetail>> call, Response<JsonResponse< StoryDetail>> response) {
                System.out.println(response.toString());
                System.out.println(response.isSuccessful());

                if(response.isSuccessful()) {
                    JsonResponse< StoryDetail> sd = response.body();
                    System.out.println(sd.getData());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse< StoryDetail>> call, Throwable t) {

            }
        });
    }

    public static void sampleStoryList() {
        StoryService mService = ApiUtils.getStoryService();
        String typeHref = "http://truyenqq.com/the-loai/adult-68.html";
        int page = 1;
        int sort = 4;
        Call<JsonResponse< ArrayList<Story> > > c = mService.getStoryList(typeHref, page, sort);
        c.enqueue(new Callback<JsonResponse< ArrayList<Story> > >() {
            @Override
            public void onResponse(Call<JsonResponse< ArrayList<Story> > > call, Response<JsonResponse< ArrayList<Story> > > response) {
                System.out.println(response.toString());
                System.out.println(response.isSuccessful());

                if(response.isSuccessful()) {
                    JsonResponse< ArrayList<Story> >  s = response.body();
                    List<Story> ls = s.getData();
                    int i = 0;
                    for(Story story : ls) {
                        i ++;
                        System.out.println(i + " -- " + story);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse< ArrayList<Story> > > call, Throwable t) {

            }
        });
    }
}