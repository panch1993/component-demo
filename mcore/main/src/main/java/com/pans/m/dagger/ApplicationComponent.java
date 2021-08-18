package com.pans.m.dagger;

import com.pans.m.main.TestActivity;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
@MyScope //声明作用域
@Component(modules = {NetModule.class})//注入provide
public interface ApplicationComponent {


//    void inject(MainActivity mainActivity);


    void inject(TestActivity mainActivity);

    Retrofit re();
}
