package com.pans.m.weather.network;

import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
public interface WeatherService {
    @GET("/weather")
    Flowable<JsonObject> getWeather();
}
