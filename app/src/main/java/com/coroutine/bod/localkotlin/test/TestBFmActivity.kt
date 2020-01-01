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
class TestBFmActivity:BackFmActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv_guide.text = "BBBBB"
        window.decorView.setOnClickListener {
            startActivity(Intent(this,TestAFmActivity::class.java))
        }
    }
}