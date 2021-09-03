package com.pans.m.daggers.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.pans.common.constant.RoutePath
import com.pans.libbase.model.User
import com.pans.m.daggers.net.MainApiService
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * daggger test activity
 */
@Route(path = RoutePath.MAIN_ACTIVITY)
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var user2: User

    @Inject
    lateinit var retrofit: Retrofit

    /**
     * 若声明作用域,形成局部单例.
     * 配合application component 可全局单例
     * retrofit2 == retrofit = true
     */
    @Inject
    lateinit var retrofit2: Retrofit

    @Inject
    lateinit var api: MainApiService

    @Inject
    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //执行注入,create使用在application中 可将作用域视为全局单例
        //DaggerApplicationComponent.create().inject(this)

        //user可局部单例,application可全局单例
        /* DaggerUserComponent.builder()
             .pApplicationComponent(MainApplication.applicationComponent)
             .build().inject(this)
         Logger.i(user.toString() + user2.toString())
         Logger.i(retrofit.toString() + retrofit2.toString())
         Logger.i(context.toString())*/
    }
}