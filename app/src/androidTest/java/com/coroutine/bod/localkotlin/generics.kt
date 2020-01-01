package com.coroutine.bod.localkotlin

import timber.log.Timber
import kotlin.math.log

/**
 *
 * @ClassName: generics
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-26
 */

class Contains<T> {//super 生产者，向外输出数据

    fun test(t: T): T {
        return t
    }

}

fun <T> test(result: T) {

}

//范型约束
fun <T : Number> put(input: T) {

}


interface OnClick {
    val onClick: String
    fun test()
}

interface OnLongclick {

}

class AAA : OnClick {

    override fun test() {
        print("11")
    }

    override val onClick: String
        get() = "A"

}

fun <T> put2(t: T) where T : OnClick, T : OnLongClick {

}


interface OnLongClick {

}

fun main() {
    listOf(listOf(1,2), listOf(3,4)).flatMap {intRange->
        intRange.map { "map result: $it " }
    }.forEach {
        println("$it")
    }
}