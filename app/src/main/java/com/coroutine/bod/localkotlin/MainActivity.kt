package com.coroutine.bod.localkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.coroutine.bod.localkotlin.api.UserViewModel
import com.coroutine.bod.localkotlin.jetpackdemo.test.TestViewModel
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.*
import test.FmOne
import timber.log.Timber
import kotlin.collections.ArrayList

//, CoroutineScope by MainScope()
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    var name = ""

    var globalJob: Job? = null

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    private val userViewModel by lazy {
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewModel.getData()
//        startActivity(Intent(this,BackFmActivity::class.java))
        name = "Main Name"
        testList()
        testMMKV()
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

        lifecycleScope.launch {

        }

        initFragment()

        viewModel.result.observe(this, androidx.lifecycle.Observer {
            Timber.d("Value Test:$this")
        })

    }

    private fun testMMKV() {
        val mmkvKey = MMKV.defaultMMKV()
        mmkvKey.encode("Code", "Code_String")
        Timber.d("MMKV File ${mmkvKey.decodeString("Code")}")
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, FmOne())
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
