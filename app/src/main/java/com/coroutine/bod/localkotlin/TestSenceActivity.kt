package com.coroutine.bod.localkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.util.Function
import androidx.asynclayoutinflater.view.AsyncLayoutInflater
import androidx.lifecycle.*
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ToastUtils
import com.coroutine.bod.localkotlin.db.AppDataBase
import com.coroutine.bod.localkotlin.db.User
import com.coroutine.bod.localkotlin.db.UserAppViewModel
import com.coroutine.bod.localkotlin.db.UserRepository
import com.coroutine.bod.localkotlin.demo.MyService
import com.coroutine.bod.localkotlin.service.JobHandlerService
import com.coroutine.bod.localkotlin.service.TestService
import com.tencent.mmkv.MMKV
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_testsence.*
import kotlinx.android.synthetic.main.activity_your.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.locks.ReentrantLock

/**
 *
 * @ClassName: TestSenceActivity
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-29
 */
class TestSenceActivity : AppCompatActivity() {

    private val userAppViewModel by lazy {
        ViewModelProvider(this).get(UserAppViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_testsence)

        Observable.just("1")
            .subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.newThread())
            .subscribe {

            }
        AsyncLayoutInflater(this).inflate(
            R.layout.activity_testsence,
            null
        ) { view, resid, parent ->
            setContentView(view)
            val grayView = findViewById<View>(android.R.id.content)
    //        window.decorView.setBackgroundColor(R.color.colorGray)
    //        Glide.with(this).load("")
    //            .error(R.drawable.asia)
    //            .into(iv_error)
    //        iv_error.setImageResource(R.drawable.focus_earth)

            BarUtils.getActionBarHeight()
            startGuardService()
            val userLiveData = MutableLiveData<String>()
//            Transformations.switchMap(*userLiveData, Function<String, LiveData<Int>> {
//                //这里的数据可以从数据库中进行获取 Room或者Paging
//                getIntLiveData(it)
//            }).observe(this, Observer {
//                Timber.d("sence hashcode :$it")
//            })
//
//            Glide.with(this).load(IMAGE_URL)
//                .thumbnail(0.2f)
//                .into()

            val okHttpClient = OkHttpClient()
            val request = Request.Builder()
                .url("url start request")
                .get()
                .build()
            val newCall = okHttpClient.newCall(request)

            newCall.enqueue(object:Callback{
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {
                }
            })

            val reentrantLock = ReentrantLock()
            reentrantLock.tryLock()

            tv_limit.setOnLimitClickListener {
                print("item clicked")
                Timber.d("Item Clicked")
            }
            //从数据库中拉取
            userLiveData.postValue("MyName")
            iv_error.setOnClickListener {
                ARouter.getInstance()
                    .build("/app/activity")
                    .withString("Key","Value:Bob")
                    .navigation()

                it.animate().x(200f).y(200f).setDuration(3000)
                    .scaleX(0.5f).scaleY(0.5f).interpolator = BounceInterpolator()

                //Log.d("Bob", "Test")
    //                    Timber.d("BobTest")
    //                    GlobalScope.launch(Dispatchers.IO) {
    //                        val userDao = AppDataBase.getDataBase(this@TestSenceActivity.applicationContext).userBean()
    //                        val repository = UserRepository(userDao)
    //                        repository.insert(User(name = "Bob", sex = "man"))
    //                        val allUser = repository.allUser
    //                        val size = allUser.size
    //                        launch(Dispatchers.Main) {
    //                            ToastUtils.showLong("$size ${allUser.get(0).name}")
    //                        }
    //                    }
    //           GlobalScope.launch {
    //               val selectAll = userAppViewModel.selectAll()
    //                selectAll.observe(this@TestSenceActivity, Observer {
    //                    it.map {
    //                        print(it)
    //                    }
    //                })
    //               userAppViewModel.insert(User(name = "Bob",sex = "man"))
    //               userAppViewModel.insert(User(name = "Bob2",sex = "woman"))
    //           }
            }
        }

        testMMKV()

//        ToastUtils.showLong(BuildConfig.BugId)
    }


    private fun startGuardService() {
        startService(Intent(this, TestService::class.java))
    }

    private fun testMMKV() {
        val mmkvKey = MMKV.defaultMMKV()
        mmkvKey.encode("Code", "Code_String")
        Timber.d("MMKV File ${mmkvKey.decodeString("Code")}")
    }

    override fun onResume() {
        super.onResume()
//        startActivity(Intent(this,MyService::class.java))

        addClass {
            it.let { }
        }
    }

    private fun getIntLiveData(it: String?): LiveData<Int> {
        return MutableLiveData<Int>().apply {
            value = it.hashCode()
        }
    }

    fun addClass(callback: ((String) -> Unit)? = null) {
        callback?.invoke("")
    }
}