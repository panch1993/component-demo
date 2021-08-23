package com.pans.m.hilt;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
@InstallIn(ApplicationComponent.class)
@Module
public class AppModule {

    //@Singleton
    @Provides
    Human provideHuman() {
        return new Human();
    }
}
