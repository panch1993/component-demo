package com.pans.m.hilt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public class TestViewModel {
    Human human;

    //-- hilt自动注入
    Application application;
    Activity activity;
    Context context;

    @Inject
    public TestViewModel(Human human, Application application, Activity activity, Context context) {
        this.human = human;
        this.application = application;
        this.activity = activity;
        this.context = context;
    }

    public void test() {
        Logger.d(human);
        Logger.d(application);
        Logger.d(activity);
        Logger.d(context);
    }
}
