package com.coroutine.bod.localkotlin.simple5.s04

import android.view.View
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 *
 * @ClassName: Test
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-16
 */
class Test {
    val i = "AAA"

    //这是嵌套类
    class Sub{
        fun show(){
        }
    }
}

inline fun <T,R> T.test(block:(T)->R):R{
//    contract {
//        callsInPlace(block,InvocationKind.EXACTLY_ONCE)
//    }
    return block(this)
}


interface Foo{
    companion object{

        @JvmStatic
        val answer:Int = 40

        @JvmStatic
        fun sayHello(){
            print("hello bob")
        }

        fun View.onLimit(){

        }

    }
}

