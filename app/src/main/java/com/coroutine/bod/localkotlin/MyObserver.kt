package com.coroutine.bod.localkotlin

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

/**
 *
 * @ClassName: MyObserver
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-21
 */
class MyObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun init(){
            Timber.d("init(): myobserver")
    }
}