package com.pans.libbase.network.di;

import com.pans.libbase.BuildConfig;
import com.pans.libbase.util.PropertiesUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client) {
        String baseUrl = PropertiesUtil.getProperty("baseUrl");
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //.addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Named("Moshi")
    @Singleton
    @Provides
    public Retrofit provideRetrofitNormal(OkHttpClient client) {
        String baseUrl = PropertiesUtil.getProperty("baseUrl");
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }


    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (PropertiesUtil.boolProperty("netLogEnable", BuildConfig.DEBUG)) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }
}
