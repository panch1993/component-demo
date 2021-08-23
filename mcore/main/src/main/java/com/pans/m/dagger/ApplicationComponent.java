package com.pans.m.dagger;

import android.content.Context;

import com.pans.m.binds10.TestModule;
import com.pans.m.net.MainApiService;
import com.pans.m.sub09.StudentComponent;
import com.pans.m.sub09.SubComponentModule;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
@MyScope //声明作用域
@Component(modules = {NetModule.class, SubComponentModule.class, TestModule.class})//注入provide
public interface ApplicationComponent {


    //*** 交给依赖组件
//    void inject(MainActivity mainActivity);


    //--- 交给子组件
//    void inject(TestActivity mainActivity);


    //*** 依赖组件需要暴露接口提供对象
    Retrofit re();

    MainApiService api();

    Context c();

    //--- sub09~ 子组件注入,可直接使用父组件module provide
    StudentComponent.Factory sf();
}
