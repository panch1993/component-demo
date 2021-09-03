package com.pans.m.coroutine

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.pans.common.constant.RoutePath
import com.pans.m.daggers.main.R
import kotlinx.coroutines.*
import kotlin.coroutines.*

/**
 * Create by panchenhuan on 2021/9/2
 * walkwindc8@foxmail.com
 * Description:kotlin 协程 test
 */
@DelicateCoroutinesApi
@Route(path = RoutePath.COROUTINE_ACTIVITY) //方式二.委托作用域对象
class CoroutineTestActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    //方式一.声明作用域
    private val mainScope = MainScope()

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_coroutine_test)
        tv = findViewById(R.id.textView)
        tv.text = "on create"

        findViewById<View>(R.id.button).setOnClickListener {
            //顶级协程,开启作用域,指定默认
            GlobalScope.launch(Dispatchers.Main) {
                //test()
            }
            mainScope.launch {
                //test()
            }
        }

    }

    private suspend fun test() {
        val text = load()
        show(text)
    }

    private suspend fun load() = withContext(Dispatchers.IO) {
        Logger.d(Thread.currentThread().name)
        delay(2000)
        "text"
    }

    private fun show(text: String) {
        tv.text = text
    }


    private fun source() {
        val createCoroutine = suspend {
            5
        }.createCoroutine(completion = object : Continuation<Int> {
            override val context: CoroutineContext = EmptyCoroutineContext

            override fun resumeWith(result: Result<Int>) {
                Logger.d(result)
            }
        })

        createCoroutine.resume(Unit)
    }


    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
        cancel()
    }
}