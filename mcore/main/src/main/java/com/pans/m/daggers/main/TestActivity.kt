package com.pans.m.daggers.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.pans.m.daggers.binds10.AInterface
import com.pans.m.daggers.dagger.CustomQualifier
import com.pans.m.daggers.sub09.Student
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Pan
 * @DATE 2021/8/18.
 * @TIME 21:44.
 */
@Route(path = "/main/TestActivity")
class TestActivity : AppCompatActivity() {


    /*@Inject
    lateinit var retrofit: Retrofit*/


    @Named("student1")
    @Inject
    lateinit var student: Student

    @Named("student2")
    @Inject
    lateinit var student2: Student

    @CustomQualifier
    @Inject
    lateinit var student3: Student


    @Inject
    lateinit var aInterface: AInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MainApplication.applicationComponent.inject(this)
       /* MainApplication.applicationComponent.sf().create().inject(this)
        Logger.d(student)
        Logger.d(student2)
        Logger.d(student3)
        Logger.d(aInterface)*/
    }
}