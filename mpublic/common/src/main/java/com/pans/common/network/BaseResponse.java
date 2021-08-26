package com.pans.common.network;

import com.pans.libbase.network.response.IResponse;

/**
 * Create by Pan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public class BaseResponse<T> implements IResponse<T> {
    private String code;
    private String message;
    private T data;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return code;
    }
}
