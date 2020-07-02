package com.coroutine.bod.localkotlin

import android.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 *
 * @ClassName: jvmtest
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-09
 */


fun main() {
    listOf("1", "2", "3")

    val launchDemo = LaunchDemo()
    launchDemo.compute()
}

fun View.setOnLimitClickListener(defaultTime: Long = 500, limitListener: (view: View?) -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        private var lastedClickMill = 0L
        override fun onClick(view: View?) {
            val curTimeMill = System.currentTimeMillis()
            if (curTimeMill - lastedClickMill > defaultTime) {
                lastedClickMill = curTimeMill
                limitListener.invoke(view)
            }
        }
    })
}


class LaunchDemo : CoroutineScope by MainScope(){

    private var job: Job? = null

    fun compute() {
        job = launch {
            log("Main Result")
            delay(100)
            withContext(Dispatchers.IO){
                "Result"
                log("IO Result")
            }
        }
    }

    fun cancelScope(){
        cancel()
    }


}
