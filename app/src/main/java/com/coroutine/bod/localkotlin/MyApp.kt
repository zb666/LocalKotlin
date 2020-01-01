package com.coroutine.bod.localkotlin

import android.app.Application

import com.didichuxing.doraemonkit.DoraemonKit

import timber.log.Timber

/**
 * @ClassName: MyApp
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-09-22
 */
open class MyApp : Application() {

    protected var a  ="aaaaa"

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        DoraemonKit.install(this)
    }
}
