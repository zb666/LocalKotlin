package com.coroutine.bod.localkotlin

import android.os.Process
import android.os.SystemClock
import timber.log.Timber
import kotlin.concurrent.thread
import kotlin.math.log

/**
 *
 * @ClassName: TestStr
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-13
 */

class AAA{

    fun main() {

        val thread3 = Thread(A())

        log("Before start()")
        thread3.start()
        log("After start()")

        val thread2 = Thread(B())

        thread2.start()


        val a = 1.0f/21*100
        log("$a")

        thread {  }.priority = Thread.MIN_PRIORITY

        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)

    }

}


fun log(info: String) {
    Timber.d("${Thread.currentThread().name}: ${Thread.currentThread().state}: $info")
}

class A : Runnable {
    override fun run() {
        Thread.sleep(500)
    }

}

class B  : Runnable {
    override fun run() {
        AAA::class.java
    }

}
