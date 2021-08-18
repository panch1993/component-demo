package com.pans.m.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.pans.libbase.model.User
import com.pans.m.dagger.DaggerApplicationComponent
import com.pans.m.net.MainApiService
import retrofit2.Retrofit
import javax.inject.Inject

@Route(path = "/main/main")
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var api: MainApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //执行注入,create使用在application中 可将作用域视为全局单例
        DaggerApplicationComponent.create().inject(this)

        Logger.i(user.toString())
        Logger.i(retrofit.toString())
        Logger.i(api.toString())
    }
}