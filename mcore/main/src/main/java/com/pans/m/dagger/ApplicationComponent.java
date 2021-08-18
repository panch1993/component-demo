package com.pans.m.dagger;

import com.pans.m.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
@Singleton
@Component(modules = {NetModule.class})
public interface ApplicationComponent {


    void inject(MainActivity mainActivity);
}
