package com.pans.libbase.network;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public interface ApiService {

    @GET("/")
    Observable<String> test();

}
