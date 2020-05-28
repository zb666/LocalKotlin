package com.coroutine.bod.localkotlin

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.alibaba.android.arouter.launcher.ARouter
import com.alibaba.android.arouter.routes.`ARouter$$Group$$arouter`
import com.alibaba.android.arouter.routes.`ARouter$$Providers$$arouterapi`

import com.didichuxing.doraemonkit.DoraemonKit
import com.tencent.mmkv.MMKV

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

        val rootDir = MMKV.initialize(this)
        Timber.d("MMKV File:$rootDir")

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
//        `ARouter$$Providers$$arouterapi`
    }
}
