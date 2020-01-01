package com.coroutine.bod.localkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import test.BackFmActivity
import test.FmOne
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

//, CoroutineScope by MainScope()
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    var name = ""

    var globalJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        startActivity(Intent(this,BackFmActivity::class.java))
        name = "Main Name"
        testList()
        R.string.brvah_app_name
        launch(Dispatchers.IO) {
            globalJob = GlobalScope.launch {
                repeat(100) {
                    startPrint(name + "$it")
                    if (it == 5) {
//                        startActivity(Intent(this@MainActivity, OtherActivity::class.java))
//                        finish()
                    }
                    if (it == 15) {
                        cancel()
                    }
                    delay(1000)
                }
            }
        }

        launch(Dispatchers.IO) {
            GlobalScope.launch {
                repeat(100) {
                    delay(1_000)
                    if (it == 10) cancel()
                    startPrint("Scope Test $it")
                }
            }
        }

        initFragment()

    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container,FmOne())
            .commit()
    }

    private fun testList() {
        val arrayListOf = arrayListOf("1", "1").toArray()
        val applySizeException = ArrayList<String>(2).apply {
            add("1")
            add("1")
        }.toArray()
    }


    private suspend fun reUpload(index: Int) {
        delay(1_000)
        if (index == 10) cancel()
    }

    fun startPrint(info: String) {
        Timber.d("Print:$info")
    }

    override fun onDestroy() {
        super.onDestroy()
        startPrint("onDestory")
        cancel()
//        globalJob?.cancel()
//        name = "InitState"
    }
}
