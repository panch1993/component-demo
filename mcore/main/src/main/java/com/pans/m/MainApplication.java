package com.pans.m;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.pans.libbase.app.IApp;
import com.pans.m.dagger.ApplicationComponent;
import com.pans.m.dagger.DaggerApplicationComponent;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
public class MainApplication extends Application implements IApp {

    public static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("oncreate ");
        initModuleApplication(this);
    }

    @Override
    public void initModuleApplication(Application context) {
        applicationComponent = DaggerApplicationComponent.create();
    }

}
