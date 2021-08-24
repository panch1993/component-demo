package com.pans.component;

import com.pans.m.weather.network.WeatherService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;

/**
 * Create by Pan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
@InstallIn(ApplicationComponent.class)
@Module
public class TestModule {

    @Singleton
    @Provides
    WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }
}
