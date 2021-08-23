package com.pans.m.binds10;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
@Module
public abstract class TestModule {

    @Binds
    abstract AInterface bindAinterface(AImpl02 impl);

    //static ??
    @Provides
    static AImpl01 provideAImpl01() {
        return new AImpl01();
    }

    @Provides
    static AImpl02 provideAImpl02() {
        return new AImpl02();
    }
}
