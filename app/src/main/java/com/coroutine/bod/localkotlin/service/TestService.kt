package com.coroutine.bod.localkotlin.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 *
 * @ClassName: TestService
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-05
 */
class TestService:Service() {

    override fun onCreate() {
        super.onCreate()
        startService(Intent(this,JobHandlerService::class.java))
    }

    override fun onBind(intent: Intent?): IBinder? = null


}