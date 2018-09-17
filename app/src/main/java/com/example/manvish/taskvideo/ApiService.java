package com.example.manvish.taskvideo;

import com.example.manvish.taskvideo.POJO.Video;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("retrofit/json_object.json")
    Call<Video> getMyJSON();
}
