package com.pans.m.daggers.net;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
public interface MainApiService {
    @GET("/info")
    Call<String> getInfo();
}
