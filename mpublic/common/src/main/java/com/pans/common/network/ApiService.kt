package com.pans.common.network;


import com.pans.common.model.SystemParamsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
public interface ApiService {

    @GET("dddadminuserserver/systemParameter/selectSystemParameterEdition")
    Observable<BaseResponse<SystemParamsBean>> systemInfo();
}
