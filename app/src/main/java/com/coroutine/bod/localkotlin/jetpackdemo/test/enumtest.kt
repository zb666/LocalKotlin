package com.coroutine.bod.localkotlin.jetpackdemo.test

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @ClassName: enumtest
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-13
 */
enum class Type(val china: String, val usa: String) {
    ENG("", ""),
    SIMPLE("AAA", "CCC")
}

fun main() = runBlocking{

    print(Type.SIMPLE.china)

    val kFunction2 = ::method
    kFunction2.invoke("",2)

    flow {
        for(i in 1..3){
            kotlinx.coroutines.delay(1000)
            emit(i)
        }
    }.collect {
        printLog("$it")
    }


//    foo().forEach { value->
//       printLog("$value")
//    }

}

fun method(s:String,i:Int){}

fun foo():Sequence<Int> = sequence {
    for(i in 4..6){
       Thread.sleep(1000)
        yield(i)
    }
}

fun printLog(msg:Any){
    println("${Thread.currentThread().name}:   ${Date().getNowDateTime()} value:$msg")
}

fun Date.getNowDateTime(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(this)
}