package com.pans.libbase.network.exception;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public class ApiException extends Exception {
    private String code;
    private String message;

    public ApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiException handleException(Throwable throwable) {
        return new ApiException("0", throwable.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
