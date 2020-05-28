package com.coroutine.bod.localkotlin

import android.view.View
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

/**
 *
 * @ClassName: WorkManagerJob
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-09
 */
fun main(){
    WorkManager.getInstance()
}

/**
 * 在连接网络，插入电源，并且处于空闲的时候才会触发
 * 内部做了电量优化 Android App不耗电
 * 约束条件
 * 约束后台执行
 *
 * 包活被限制了 做不了
 */
fun testWorkBackground(view:View){
    val myConstraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)//网络连接中
        .setRequiresCharging(true)//充电中
        .setRequiresDeviceIdle(true)//处于空闲的时候
        .build()
    //更多的约束都在笔记里

    //内部状态变化的监听还是会使用到广播
    val workManager = WorkManager.getInstance()
//    workManager.beginWith(OneTimeWorkRequest())

}