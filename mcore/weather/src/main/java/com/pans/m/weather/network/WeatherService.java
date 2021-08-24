package com.pans.m.weather.network;

import com.pans.libbase.network.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
public interface WeatherService {

    @GET("systemParameter/selectSystemParameterEdition")
    Observable<BaseResponse<SystemParamsBean>> systemInfo();
}
