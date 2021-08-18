package com.pans.libbase.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
public class RetrofitManager {
    public static boolean isLogEnable = true;

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private String baseUrl;

    public void init(String baseUrl) {
        init(baseUrl, createOkHttpClient());
    }

    public void init(String baseUrl, OkHttpClient okHttpClient) {
        this.baseUrl = baseUrl;
        this.okHttpClient = okHttpClient;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static OkHttpClient createOkHttpClient() {
        final OkHttpClient.Builder builder =
                new OkHttpClient.Builder();
        if (isLogEnable) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        return builder.connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 请求接口
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

    private static class Holder {
        private static final RetrofitManager ourInstance = new RetrofitManager();
    }

    private RetrofitManager() {
    }

    public static RetrofitManager getInstance() {
        return Holder.ourInstance;
    }

}
