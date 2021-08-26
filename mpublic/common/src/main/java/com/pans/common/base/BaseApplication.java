package com.pans.common.base;

import android.app.Application;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;
import com.pans.libbase.util.PropertiesUtil;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i("BaseApplication onCreate: ");
        String isRelease = PropertiesUtil.getProperty("isRelease");
        if (!TextUtils.equals(isRelease, "true")) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
