package com.pans.m.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_weather.*

@Route(path = "/weather/weather")
class WeatherActivity : AppCompatActivity() {
    @Autowired
    @JvmField
    var city: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)  // Start auto

        setContentView(R.layout.activity_weather)

        tv_city.text = city

    }
}