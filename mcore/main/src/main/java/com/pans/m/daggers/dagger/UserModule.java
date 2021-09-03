package com.pans.m.daggers.dagger;

import com.pans.libbase.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * @author Pan
 * @DATE 2021/8/18.
 * @TIME 21:14.
 */

@Module
public class UserModule {

    @UserScope
    @Provides
    User provideUser() {
        return new User();
    }
}
