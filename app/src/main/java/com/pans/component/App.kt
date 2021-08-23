package com.pans.component

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.pans.m.MainApplication

/**
 * Create by panchenhuan on 8/17/21
 * walkwindc8@foxmail.com
 * Description:
 */
public class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)


        val build = PrettyFormatStrategy.newBuilder()
            .tag("klog")
            .methodCount(1)
            .methodCount(1)
            .showThreadInfo(false)
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(build) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })

        MainApplication().initModuleApplication(this)
    }
}