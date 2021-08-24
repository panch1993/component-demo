package com.pans.component

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.pans.libbase.extension.loadImage
import com.pans.m.weather.network.WeatherService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_start.*
import javax.inject.Inject

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    @Inject
    lateinit var service: WeatherService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        iv.loadImage("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8b13632762d0f70379f2e1750cfa513d2797c5d3.jpg")
        Logger.d(service)
//        RequestModel.
    }

    fun goMain(view: View) {
        ARouter.getInstance().build("/main/MainActivity").navigation()
    }

    fun goWeather(view: View) {
        ARouter.getInstance().build("/weather/weather")
            .withString("city", "shanghai")
            .navigation()
    }

    fun goTest(view: View) {
        ARouter.getInstance().build("/main/TestActivity")
            .navigation()
    }

    fun goHilt(view: View) {
        ARouter.getInstance().build("/hilt/HiltTestActivity")
            .navigation()
    }
}