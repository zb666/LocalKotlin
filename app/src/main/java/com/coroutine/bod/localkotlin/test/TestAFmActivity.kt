package com.coroutine.bod.localkotlin.test

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import test.BackFmActivity

/**
 *
 * @ClassName: TestAFmActivity
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-03
 */
class TestAFmActivity:BackFmActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv_guide.text = javaClass.name
        tv_guide.setOnClickListener {
            startActivity(Intent(this,TestBFmActivity::class.java))
        }
    }
}