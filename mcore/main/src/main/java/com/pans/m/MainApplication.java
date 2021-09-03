package com.pans.m;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.pans.libbase.app.IApp;
import com.pans.m.daggers.dagger.DaggerPApplicationComponent;
import com.pans.m.daggers.dagger.NetModule;
import com.pans.m.daggers.dagger.PApplicationComponent;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
public class MainApplication extends Application implements IApp {

    public static PApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("oncreate ");
        initModuleApplication(this);
    }

    @Override
    public void initModuleApplication(Application context) {
//        Logger.d(context.toString());
//        applicationComponent = DaggerApplicationComponent.create();
        //传入 带参module
        applicationComponent = DaggerPApplicationComponent.builder().netModule(new NetModule(context)).build();
    }

}
