package com.pans.libbase.util;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;

/**
 * Create by panchenhuan on 2021/8/25
 * walkwindc8@foxmail.com
 * Description:
 */
public class GSON {

    private static WeakReference<Gson> instance;

    private GSON() {

    }

    public static Gson get() {
        if (instance == null || instance.get() == null) {
            Gson gson = new Gson();
            instance = new WeakReference<Gson>(gson);
        }
        return instance.get();
    }
}
