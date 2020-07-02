package com.coroutine.bod.localkotlin


import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_state_start.*
import kotlinx.coroutines.*

class ModelObsViewActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_start)


        launch {
            delay(2000)
            mStateConstraintLayout.loadLayoutDescription(R.xml.constraint_set_test)
            mStateConstraintLayout.postDelayed(Runnable {
                tvLoading.text = "数据加载完成"
                mStateConstraintLayout.setState(R.id.success, 0, 0)
            }, 3_000)
        }

    }

}



