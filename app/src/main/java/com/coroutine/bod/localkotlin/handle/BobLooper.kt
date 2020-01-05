package com.coroutine.bod.localkotlin.handle

import android.os.Handler
import android.os.Message
import java.lang.RuntimeException
import kotlin.concurrent.thread

/**
 *
 * @ClassName: BobLooper
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-05
 */
class BobLooper {

    var messageQueue: MessageQueue

    private val threadLocal = ThreadLocal<BobLooper>()

    init {
        messageQueue = MessageQueue()
    }

    fun prepare() {
        if (threadLocal.get() != null) {
            throw RuntimeException("thread can only create one looper")
        }
        threadLocal.set(BobLooper())
    }

    fun myLooper() = threadLocal.get()

    fun next() {
        try {
            myLooper()?.run {
                messageQueue
            }?.run {
                next()
            }?.run {
                target.dispatchMessage(this)
            }
        }catch (t:Throwable){

        }

    }

}