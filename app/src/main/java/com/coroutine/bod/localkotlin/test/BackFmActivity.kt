package test

import android.content.BroadcastReceiver
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.coroutine.bod.localkotlin.FocusBaseActivity
import com.coroutine.bod.localkotlin.ModelActivity
import com.coroutine.bod.localkotlin.R
import com.coroutine.bod.localkotlin.ScTest
import com.coroutine.bod.localkotlin.sc.Example
import com.coroutine.bod.localkotlin.test.TestAFmActivity
import com.coroutine.bod.localkotlin.view.PathMeasureView
import com.coroutine.bod.localkotlin.view.PathPosTanView
import com.coroutine.bod.localkotlin.viewmodel.HomeViewModel
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_back_fm.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import timber.log.Timber


/**
 *
 * @ClassName: BackFmActivity
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-09-26
 */
open class BackFmActivity : FocusBaseActivity(), ITask {

    init {
        val iTask = this as ITask
        iTask.getName {
            "TaskName"
        }.run {
            Timber.d("HomeWorkViewModel:$this")
        }



    }

    var aStr = "StrA"

    val pubSub = PublishSubject.create<String>()

    private val homeViewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, ModelActivity::class.java))
//        window.setBackgroundDrawable(null)
        val layoutParams = myBerizer.layoutParams as LinearLayout.LayoutParams
        layoutParams.bottomMargin = 100

        GlobalScope.launch(Dispatchers.Main) {
            segmentView.startCircle()
        }

//        startActivity(Intent(this,ScTest::class.java))

        posTanView.setOnClickListener {
            (it as PathPosTanView).startRotate()
        }

        val any = aStr.takeIf {
            it.isEmpty()
        } ?: Timber.d("空判断: ?: is invoked")

        Timber.d("最终结果为: $any")

        tv_guide.setOnClickListener {
            pubSub.onNext(System.currentTimeMillis().toString())

//            startActivity(Intent(this,TestAFmActivity::class.java))
        }


        pubSub
            .subscribe {
                Timber.d("PubSub:$it")
            }


        listOf("1")

        homeViewModel.homeLiveData.observe(this, Observer {

        })

        homeViewModel.curLiveDat.observe(this, Observer {
            Timber.d("HomeViewModel:$it")
        })

        val name = ::name
        runBlocking {
            delay(2000)
            name.invoke("HomeViewModel: I am Bob")
        }

        var a = "".let {
            //lamder表达式最后一行是返回值
            1
        }

        "".runBob {

        }

        val runApplyResult = "".runApply {
            123456
            "flmfkdlmdlk"
            "BobRunApplyResult"
        }

        Timber.d("HomeViewModel:$runApplyResult")

        "".also {

        }
        "".alsoBob {
            it.toString()
        }
        val with = with("") {
            1
            true
        }

        testAs(1.0f)

        crossTest {

            return
        }

        bytest()
        invokeTest()

    }

    private fun invokeTest() {
        val test = Test::class.java
        val newInstance = test.newInstance()
        val field = test.getDeclaredField("name")
        field.isAccessible = true

        field.set(newInstance,"FinalName")

        Timber.d("Field:${field.name}  ${field.get(newInstance)}")

    }

    fun testAs(number: Number) {
        val asResult = number as? Int
        Timber.d("HomeViewModel:$asResult")
    }


    inline fun crossTest(a: () -> Unit) {

    }

    companion object {
        class A
    }

    fun String.bobTest(): Int {
        return length //扩展函数不用传递it
    }

    inline fun <T> T.runApply(block: T.() -> T): T {
        return block.invoke(this)
    }

    inline fun <T, R> T.runBob(block: T.() -> R): R {
        return block() //传递的是扩展函数
    }

    inline fun <T, R> T.letBob(block: (T) -> R): R {
        return block(this)
    }

    //最终返回函数本身就行,中途可以进行任何的操作
    inline fun <T> T.alsoBob(block: (T) -> Unit): T {
        block.invoke(this)
        return this
    }

    //入参普通函数，调用者使用的是Lamder函数
    inline fun <T, R> with(receiver: T, block: T.() -> R): R {
        return receiver.block()
    }

    fun name(name: String) {
        Timber.d("Name: $name")
    }

    fun <T> copyIn(dest: Array<in T>, src: Array<T>) {

    }

    interface SourceTest<out T> {
        fun getT(): T
    }

    fun test(src: SourceTest<String>) {
        val sourceTest = src
    }

    private fun bytest() {
        (0..100).takeWhile {
            it < 50
        }.forEach {
            Timber.d(":TakeWhile:$it")
        }
        //pair -> map
        val mapPair = mapOf("1" to "1")

        val user = User(mutableMapOf("name" to "Bob", "age" to 123))
        user.name //委托给了 map:Map
        user.age

        user.age =10

        val example = Example()

        Timber.d("HomeViewModel: ${user.name}  ${user.age}  ${example.prop}")
    }

    class User(map: MutableMap<String, Any?>) {
        var name: String by map
        var age: Int by map
    }


}

class Test{
    private val name = "NameTest"
}

interface ITask {
    fun getName(a: () -> String): String {
        return a.invoke()
    }
}