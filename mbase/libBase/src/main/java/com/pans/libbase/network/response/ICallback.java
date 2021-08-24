package com.pans.libbase.network.response;

import com.pans.libbase.network.exception.ApiException;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public interface ICallback<T> {

    void onSuccess(T data);

    void onFailure(ApiException exception);
}
