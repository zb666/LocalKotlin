package com.coroutine.bod.localkotlin

import org.junit.Test

/**
 *
 * @ClassName: RxCondition
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-20
 */
fun main(){
    Son()
}

open class Parent{
    init {
        System.out.println("Parent init()")
    }
}

class Son:Parent(){
    init {
        System.out.println("Son init()")
    }
}