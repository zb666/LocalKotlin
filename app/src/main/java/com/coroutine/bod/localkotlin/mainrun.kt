package com.coroutine.bod.localkotlin

import kotlinx.coroutines.runBlocking
import timber.log.Timber

/**
 *
 * @ClassName: mainrun
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-18
 */

fun main() = runBlocking {
    runBlocking {
        kotlinx.coroutines.delay(1000)
        print("11111")
    }
    print("22222")
}

//为变量的类型重新命名，经此而已
typealias Predicate<T> = (T)->Boolean
typealias BobList<T> = java.util.ArrayList<T>

typealias TestB<T> = (T)->String

fun a(){

    val testB:TestB<Int> = {
        it.toString()
    }

    val invoke = testB.invoke(1)


    val bobList = BobList<String>()
    bobList.add("Element")

    val pre:Predicate<Int> = {
        it>0
    }

    val invokedResult = pre.invoke(2)

    Timber.d("Result:$invokedResult")




}

private operator fun Int.invoke(function: () -> Unit): (Int) -> Boolean {
    return (1){

    }
}

fun aA(a:String) = false


