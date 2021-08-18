package com.pans.m.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * @author Pan
 * @DATE 2021/8/18.
 * @TIME 21:44.
 */
class TestActivity : AppCompatActivity() {


    @Inject
    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}