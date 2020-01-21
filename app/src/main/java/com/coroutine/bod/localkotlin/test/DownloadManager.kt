package com.coroutine.bod.localkotlin.test

import com.blankj.utilcode.util.Utils
import test.ITask
import java.io.File

/**
 *
 * @ClassName: DownloadManager
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-12
 */
object DownloadManager {

    private val downLoadDirectory by lazy {
        File(Utils.getApp().filesDir,"download").also {
            it.mkdirs()
        }
    }

    sealed class DownStatus:ITask{

        object DonwLoading:DownStatus() {
            override fun a(name: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        class Progress(val progress:Int):DownStatus() {
            override fun a(name: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        object Finish : DownStatus() {
            override fun a(name: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }


}