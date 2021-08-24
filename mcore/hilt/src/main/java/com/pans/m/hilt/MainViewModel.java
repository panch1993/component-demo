package com.pans.m.hilt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import com.orhanobut.logger.Logger;

import dagger.hilt.android.qualifiers.ActivityContext;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public class MainViewModel extends ViewModel {
    Human human;

    //-- hilt自动注入
    Application application;
    Activity activity;
    Context context;

    @ViewModelInject
    public MainViewModel(Human human, Application application, Activity activity, @ActivityContext Context context) {
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
