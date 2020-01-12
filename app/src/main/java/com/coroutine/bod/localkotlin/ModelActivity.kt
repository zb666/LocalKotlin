package com.coroutine.bod.localkotlin

import android.animation.ObjectAnimator
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.SparseArray
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.TimeUtils
import com.coroutine.bod.localkotlin.handle.BobHandler
import com.coroutine.bod.localkotlin.handle.BobLooper
import com.coroutine.bod.localkotlin.handle.BobMessage
import com.coroutine.bod.localkotlin.view.CircleDrawable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.util.*
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class ModelActivity : AppCompatActivity() {

    val liveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model)

        iv_drawable.setImageDrawable(
            CircleDrawable(BitmapFactory.decodeResource(resources,R.mipmap.leak_canary_icon))
        )

        funTest()

        val file = File(cacheDir, "test")
        val exists = file.exists()

        "05:14:49".run {
            Timber.d("Time: ${substring(0,2)} ${substring(3,5)} ${substring(6,8)}")
        }

        ObjectAnimator
            .ofFloat(tv_selector, "rotation", 0.0F, -180.0F)
            .apply {
                duration = 0L
                repeatCount = 10
            }
            .start()

        TimeUtils.millis2Date(100*1000).run {
            Timber.d("ForMatTime:${this.time}")
        }

        val arrayDeque = ArrayDeque<String>()
        arrayDeque.add("")
        arrayDeque.pollFirst()

        tv_selector.setOnClickListener {
            it.isSelected = !it.isSelected
        }

        lifecycle.addObserver(MyObserver())

        val strSubject = PublishSubject.create<String>()
        strSubject.subscribe {
            //            Timber.d("OnSub:$it")
        }


        dailyView.setProgress(3)
        dailyView.setOnClickListener {
            liveData.value = (0..10).random().toString()
        }

        repeat(10) {
            liveData.value = it.toString()
        }

        liveData.observe(this, Observer {
            Timber.d("DailyView: $it")
            liveData.value.run {
                Timber.d("DailyView: $this")
            }
        })

        tv_click.setOnClickListener {
            //            findTitle("MyName").observe(this, Observer {
//                Timber.d("MyData:$it")
//            })

            it.isSelected = true
            val b = it.context is LifecycleOwner

            strSubject.onNext("111")
        }

        strSubject.onNext("333")


        strSubject.subscribe {
            Timber.d("OnSub:$it")
        }
        strSubject.onNext("222")
        testSp()

        listOf(1..10).takeLast(1).forEach {
            Timber.d("Bob:$it")
        }

        testBobHandler()
    }

    private fun testBobHandler() {
        BobLooper().prepare()
        BobHandler().enqueueMessage(BobMessage("Any Boj"))
        BobHandler().sendMessage(BobMessage("send msg"))
    }

    private val sparseArray = SparseArray<String>()

    private fun testSp() {
        sparseArray.put(R.string.sparsearray, "")
    }

    fun copy(dest: Array<Double>, scr: Array<Double>) {

    }

    private fun funTest() {
        val arrayOfNulls = arrayOfNulls<Int>(3)
        val map = mapOf("1" to 1, "2" to 2)

        (11..20).forEachIndexed { index, value ->
            Timber.d("IndexValue:$index $value")
        }

//        @kotlin.internal.InlineOnly
//        public inline fun <R> run(block: () -> R): R {
//            contract {
//                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//            }
//            return block()
//        }

        bobRun {
            ""
        }

        test("1") {

        }

        val takeIf = "".takeIf {
            it.length > 0 //满足条件就返回 否则返回null
        }

        val plusList = listOf(1, 2, 3) + listOf(4, 5, 6)
        plusList.forEach {
            Timber.d("OpePlus:$it")
        }

        synchronized(Looper.getMainLooper()) {

        }

    }

    fun <R> bobRun(block: () -> R): R {
        return block.invoke()
    }

}

interface Source<out T> {
    fun getT(): T
}

fun findTitle(titie: String) = liveData(Dispatchers.IO) {
    delay(2_000)
    emit("111$titie")
//    SystemClock.sleep(1_000)
//    MutableLiveData<String>()
}

fun test(a: String, display: (String) -> Unit) {
    display.invoke(a)
}

fun test1(func: () -> Unit) {
    fun test2() {

    }
    return test2()
}
