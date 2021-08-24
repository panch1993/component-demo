package com.pans.component

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.pans.m.MainApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
@HiltAndroidApp
class MyApplication : Application() {
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