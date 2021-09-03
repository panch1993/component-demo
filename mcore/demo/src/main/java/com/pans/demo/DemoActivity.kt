package com.pans.demo

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.pans.common.constant.RoutePath
import com.pans.common.network.ApiService2
import com.pans.demo.databinding.ActivityDemoBinding
import com.pans.libbase.app.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
@Route(path = RoutePath.DEMO_ACTIVITY)
class DemoActivity : BaseActivity() {


    @Inject
    lateinit var service: ApiService2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Logger.d(service)

        launch {
            binding.tv.text = "pending"
            delay(2000)
            val systemInfoC = service.systemInfo()
            binding.tv.text = systemInfoC.toString()
        }
    }
}