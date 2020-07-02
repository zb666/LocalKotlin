package com.coroutine.bod.localkotlin.service

import android.annotation.TargetApi
import android.app.Service
import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build

/**
 *
 * @ClassName: JobHandlerService
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-05
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class JobHandlerService : JobService() {

    private fun getJobInfo() {
        val builder = JobInfo.Builder(888, ComponentName(packageName, JobHandlerService::class.java.name))
        builder.setPeriodic(2000L)
        val jobScheduler = application.getSystemService(Context.JOB_SCHEDULER_SERVICE) as? JobScheduler
        jobScheduler?.cancelAll()
        //Service守护
        val ret = jobScheduler?.schedule(builder.build())

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_STICKY
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        getJobInfo()
        return false
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        return false //表示执行完毕
    }
}