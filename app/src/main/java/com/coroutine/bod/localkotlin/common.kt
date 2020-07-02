package com.coroutine.bod.localkotlin

import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.io.File

/**
 *
 * @ClassName: common
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-04
 */

const val IMAGE_URL = "https://www.wanandroid.com/blogimgs/cbbd174c-2c68-4e67-9342-ba029a985502.png"


object Obj {

    @JvmStatic
    fun View.callStatic() {

    }

}

class Test1 {
    var name = "body chen"
    init {
        temp()

        val file = File("")
        file.readLines()
        file.readText()
    }
}

fun Test1.temp(action: ((String) -> Unit)? = null) {
    println("添加了扩展函数")
    action?.invoke("Demo")
}


fun main() {
    """
        <!DOCTYPE html>
        bbbbbbbb
        ccccccc
        ddddddd
        eeeee
    """.let {
        print(it)
    }
    val liveData = MutableLiveData<String>()

//    Transformations.switchMap(liveData){
//        //拿着String请求网络
//    }

    val file = File("/Users/bod/Downloads/brainco/filetest.txt")
    file.readLines().forEach {
        print(it)
    }

    val textView:TextView? = null

    runBlocking {
        launch {
          textView?.text = withContext(Dispatchers.Default) {
              delay(100)
              "NetWork String"
          }
        }
    }
}

