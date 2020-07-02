package com.coroutine.bod.localkotlin

import android.view.View

/**
 *
 * @ClassName: ViewUtils
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-18
 */

fun View.limitClick(block:()->Unit){
    setOnClickListener {
        block()
    }
}

fun View.registerLifeCycle(){

}