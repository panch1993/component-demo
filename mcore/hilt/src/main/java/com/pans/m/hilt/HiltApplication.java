package com.pans.m.hilt;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
@HiltAndroidApp
public class HiltApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
