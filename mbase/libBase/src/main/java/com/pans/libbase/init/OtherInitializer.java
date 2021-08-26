package com.pans.libbase.init;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.Collections;
import java.util.List;

/**
 * Create by panchenhuan on 2021/8/25
 * walkwindc8@foxmail.com
 * Description:
 */
public class OtherInitializer implements Initializer<Object> {
    @NonNull
    @Override
    public Object create(@NonNull Context context) {
        System.out.println("OtherInitializer create");
        return "OtherInitializer";
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
