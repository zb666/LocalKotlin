package com.coroutine.bod.localkotlin

/**
 *
 * @ClassName: mainLocal
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-12-03
 */

fun main() {

    val thread3 = Thread(A())

    log("Before start()")
    thread3.start()
    log("After start()")

    val thread2 = Thread(B())

    thread2.start()


    val a = 1.0f/21*100
    log("$a")

    val bbb = BBB()
    bbb.name.run { println(this) }
}


sealed class Base(name:String){

    class A(name: String,a:Int) : Base(name)

}

open class Test(private val name:String)

class BBB(val name:String = "Test"):Test(name)


