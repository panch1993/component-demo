package com.pans.m.sub09;

import com.pans.m.main.TestActivity;

import dagger.Subcomponent;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:子组件 声明在父组件中 不会生成对应Dagger*
 * 父组件 {@link com.pans.m.dagger.ApplicationComponent }
 */
@Subcomponent(modules = StudentModule.class)
public interface StudentComponent {

    //提供工厂方法给父组件使用
    @Subcomponent.Factory
    interface Factory {
        StudentComponent create();
    }

    void inject(TestActivity activity);
}
