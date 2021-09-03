package com.pans.m.daggers.dagger;

import com.pans.m.daggers.main.MainActivity;

import dagger.Component;

/**
 * @author Pan
 * @DATE 2021/8/18.
 * @TIME 21:12.
 */
@UserScope
@Component(modules = UserModule.class, dependencies = PApplicationComponent.class)
public interface UserComponent {

    void inject(MainActivity mainActivity);

}
