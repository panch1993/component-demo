package com.pans.component

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.pans.common.constant.RoutePath
import com.pans.libbase.extension.loadImage
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        iv.loadImage("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8b13632762d0f70379f2e1750cfa513d2797c5d3.jpg")
    }

    fun goMain(view: View) {
        ARouter.getInstance().build(RoutePath.MAIN_ACTIVITY).navigation()
    }

    fun goWeather(view: View) {
        ARouter.getInstance().build(RoutePath.WEATHER_ACTIVITY)
            .withString("city", "shanghai")
            .navigation()
    }

    fun goTest(view: View) {
        ARouter.getInstance().build(RoutePath.COROUTINE_ACTIVITY)
            .navigation()
    }

    fun goHilt(view: View) {
        ARouter.getInstance().build("/hilt/HiltTestActivity")
            .navigation()
    }

    fun goDemo(view: View) {
        ARouter.getInstance().build(RoutePath.DEMO_ACTIVITY)
            .navigation()
    }
}