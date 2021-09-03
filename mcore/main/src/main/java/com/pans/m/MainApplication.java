package com.pans.m;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
public class MainApplication extends Application {

    //public static PApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("oncreate ");
        // initModuleApplication(this);
    }

}
