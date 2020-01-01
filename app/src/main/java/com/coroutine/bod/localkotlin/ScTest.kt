package com.coroutine.bod.localkotlin

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.coroutine.bod.localkotlin.adapter.MyAdapter
import com.coroutine.bod.localkotlin.adapter.MyTestVp
import kotlinx.android.synthetic.main.activity_sctest.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @ClassName: ScTest
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-19
 */
class ScTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sctest)

        //reportfragment-> dispatchEvent
        lifecycle.addObserver(Helper())

        viewpager.adapter = MyTestVp(supportFragmentManager)

        findTitle("MyName").observe(this, Observer {
            Timber.d("TitleObserver:$it")
        })

    }

    fun findTitle(titie:String) = liveData<String>(Dispatchers.IO){
        SystemClock.sleep(1_000)
        MutableLiveData<String>().apply {
            this.value = "${titie}MutableLiveData"
        }

        val safeAPiCall = safeAPiCall {
            ""
        }
    }

    suspend fun safeAPiCall(action:()->String):String = withContext(Dispatchers.IO){
        action.invoke()
    }


}


