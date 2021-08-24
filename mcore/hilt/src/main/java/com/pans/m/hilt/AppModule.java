package com.pans.m.hilt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.ActivityScoped;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 * 全局{@link ApplicationComponent}
 * 页面{@link ActivityComponent} {@link ActivityScoped}
 */
@InstallIn(ActivityComponent.class)
@Module
public class AppModule {

    @ActivityScoped
//    @Singleton
    @Provides
    Human provideHuman() {
        return new Human();
    }


    /**
     * @param human
     * @param application ApplicationComponent可提供
     * @param activity    只能ActivityComponent提供
     * @param context     限定符提供指定context
     * @return onenote : 组件默认绑定
     */
//    @ActivityScoped
    @Provides
    TestViewModel provideTestViewModel(Human human, Application application, Activity activity, @ActivityContext Context context) {
        return new TestViewModel(human, application, activity, context);
    }
}
