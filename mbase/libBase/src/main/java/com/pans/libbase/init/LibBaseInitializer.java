package com.pans.libbase.init;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.startup.Initializer;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.pans.libbase.BuildConfig;
import com.pans.libbase.util.PropertiesUtil;

import java.util.Collections;
import java.util.List;

/**
 * Create by panchenhuan on 2021/8/25
 * walkwindc8@foxmail.com
 * Description:
 * 初始化器
 * 1.默认在application on create之前调用
 * <meta-data
 * android:name="com.pans.libbase.init.LibBaseInitializer"
 * android:value="@string/androidx_startup" />
 * 2.懒加载 通过tools:node="remove"来标记该初始化器
 * AppInitializer.getInstance(context).initializeComponent(LibBaseInitializer.class);
 */
public class LibBaseInitializer implements Initializer<Object> {
    //2.加载自己
    @NonNull
    @Override
    public Object create(@NonNull Context context) {

        PropertiesUtil.init(context, "appConfig.properties");
        PrettyFormatStrategy build = PrettyFormatStrategy.newBuilder()
                .tag(PropertiesUtil.getProperty("loggerTag", "TAG"))
                .methodCount(1)
                .showThreadInfo(false)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(build) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return PropertiesUtil.boolProperty("loggerEnable", BuildConfig.DEBUG);
            }
        });

        return "LibBaseInitializer";
    }

    //1.优先加载依赖的startup
    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(OtherInitializer.class);
    }
}
