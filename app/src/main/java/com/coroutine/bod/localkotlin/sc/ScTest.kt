package com.coroutine.bod.localkotlin.sc

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.coroutine.bod.localkotlin.R
import com.coroutine.bod.localkotlin.adapter.MyAdapter
import com.coroutine.bod.localkotlin.adapter.MyTestVp
import kotlinx.android.synthetic.main.activity_sctest.*
import kotlinx.android.synthetic.main.coordnidate_nes.*

/**
 * @ClassName: ScTest
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-19
 */
class ScTestClone : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordnidate_nes)

        vp_adviser.adapter = MyTestVp(supportFragmentManager)


    }



}


