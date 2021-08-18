package com.pans.libbase.model;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
public class BaseModel<T> {

    private T data;
    private int code;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return code == 200;
    }
}
