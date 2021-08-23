package com.pans.m.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hilt_test.*
import javax.inject.Inject


@Route(path = "/hilt/HiltTestActivity")
@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity() {
    @Inject
    lateinit var user: Human

    @Inject
    lateinit var user2: Human

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_test)

        tv.text = user.toString() + user2.toString()
    }
}