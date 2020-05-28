package com.coroutine.bod.localkotlin.demo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.coroutine.bod.localkotlin.MainActivity
import com.coroutine.bod.localkotlin.OtherActivity
import com.coroutine.bod.localkotlin.R
import com.coroutine.bod.localkotlin.TestSenceActivity

/**
 *
 * @ClassName: MyService
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-11
 */
class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("my_service","前台Service通知",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val mainIntent = Intent(this, OtherActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(this, 0, mainIntent, 0)
        val notification = NotificationCompat.Builder(this, "my_service")
            .setContentTitle("content title")
            .setSmallIcon(R.drawable.dk_close_icon)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.like))
//            .setContentIntent(pendingIntent)
            .build()
        startForeground(0x11,notification)

    }

}

inline fun <reified T> Context.startJump(){
    val intent = Intent(this,T::class.java)
    startActivity(intent)
}