package com.pans.m.dagger;

import com.pans.m.net.MainApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
@Module //声明为提供生成对象实例的module
public class NetModule {

    /**
     * 2.告知dagger  通过provides注解获取注入对象实例 (无法通过构造函数时使用)
     *
     * @return 实例类型
     */
    @MyScope //作用域  使用该module的组件作用域保持一样 ,用来管理component来获取对象实例的生命周期
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://www.baidu.com/").build();
    }

    //Dagger会自动传入module构建的对象
    @MyScope
    @Provides
    public MainApiService provideMainApiService(Retrofit retrofit) {
        return retrofit.create(MainApiService.class);
    }

    @MyScope
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }
}
