package com.pans.libbase.network.response;

import java.util.Objects;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public interface IResponse<T> {

    T getData();

    String getMessage();

    String getCode();

    default boolean isSuccess() {
        return Objects.equals(getCode(), "200");
    }
}
