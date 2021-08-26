package com.pans.m.weather

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.pans.common.constant.RoutePath
import com.pans.common.model.SystemParamsBean
import com.pans.common.network.ApiService
import com.pans.libbase.network.RequestModel
import com.pans.libbase.network.exception.ApiException
import com.pans.libbase.network.response.ICallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_weather.*
import javax.inject.Inject

@Route(path = RoutePath.WEATHER_ACTIVITY)
@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    @Autowired
    @JvmField
    var city: String? = null

    @Inject
    lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)  // Start auto

        setContentView(R.layout.activity_weather)

        tv_city.text = city


        Logger.d(service)

        RequestModel.request(service.systemInfo(), this, object : ICallback<SystemParamsBean> {
            override fun onSuccess(data: SystemParamsBean) {
                Logger.d(data)
                Toast.makeText(this@WeatherActivity, data.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(exception: ApiException) {
                Logger.d(exception)
            }
        })
    }
}