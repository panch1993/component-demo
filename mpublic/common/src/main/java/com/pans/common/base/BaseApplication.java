package com.pans.common.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;
import com.pans.libbase.BuildConfig;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i("BaseApplication onCreate: ");
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
