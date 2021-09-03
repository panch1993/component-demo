package com.pans.m.daggers.sub09;

import com.pans.m.daggers.dagger.CustomQualifier;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 * {@link StudentComponent}
 */
@Module
public class StudentModule {

    @Named("student1")
    @Provides
    Student provideStudent() {
        return new Student();
    }

    @Named("student2")
    @Provides
    Student provideStudent2() {
        return new Student("nnnnnnn");
    }

    @CustomQualifier
    @Provides
    Student provideStudent3() {
        return new Student("CustomQualifier");
    }

}
