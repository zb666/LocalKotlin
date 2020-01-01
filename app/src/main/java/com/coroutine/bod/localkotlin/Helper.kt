package com.coroutine.bod.localkotlin

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 *
 * @ClassName: Helper
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-25
 */
class Helper:ViewModel(),LifecycleObserver {

    init {
        var aaa = "aaaaa"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeAction(){
        Timber.d("resumeAction:invoke")
    }
}