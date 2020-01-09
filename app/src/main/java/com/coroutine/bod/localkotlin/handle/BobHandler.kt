package com.coroutine.bod.localkotlin.handle

import android.content.Context
import android.os.Looper
import androidx.appcompat.widget.SwitchCompat

/**
 *
 * @ClassName: BobHandler
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-05
 */

//每个线程都会有Handler
class BobHandler() {

    //有MessageQueue不过是由Looper负责去调度的
    private var mQueue:MessageQueue

    private lateinit var myLooper: BobLooper


    init {
        val bobLooper = BobLooper()
        mQueue = bobLooper.messageQueue
        myLooper = bobLooper
    }

    fun enqueueMessage(msg:BobMessage){
        msg.target = this //方便取回来,取回来之后调用dispatchMessage()方法
        mQueue.enqueueMessage(msg)
    }

    fun sendMessage(msg: BobMessage){
        enqueueMessage(msg)
    }

    //Looper->Handler完成Msg之后->回调这个方法
    fun dispatchMessage(msg: BobMessage) {
       handleMessage(msg)
    }

    private fun handleMessage(msg: BobMessage) {
        //1 New Handler
        // ->2 bind with MessageQueue&Looper
        // 2.1 MessageQueue queue
        // 2.2 Looper effect when MainThread started

        // usaged exm code
        // send->post ->enqueueMessage
        // -> by MessageQueue
        // step 1 mark msg's target as it self
        // step 2 dispatcher Msg
        // step handle it by developer or sys
    }


}