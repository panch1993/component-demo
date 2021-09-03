package com.pans.common.network

import com.pans.common.model.SystemParamsBean
import retrofit2.http.GET

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
interface ApiService2 {

    @GET("dddadminuserserver/systemParameter/selectSystemParameterEdition")
    suspend fun systemInfo(): BaseResponse<SystemParamsBean>

}