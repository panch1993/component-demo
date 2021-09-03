package com.pans.component

import com.google.gson.Gson
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val start = System.currentTimeMillis()
        val g = Gson()
        val g2 = Gson()
        val end = System.currentTimeMillis()
        println(end - start)

    }
}