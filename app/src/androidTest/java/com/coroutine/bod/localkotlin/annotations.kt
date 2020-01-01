package com.coroutine.bod.localkotlin

import timber.log.Timber

/**
 *
 * @ClassName: annotations
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-26
 */

//注解和反射
@Target(AnnotationTarget.FIELD,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class Path

@Path class UserPath{

}

var name="111"

fun main(){
    //获得java的class
    String::class.java.also {

    }

    listOf(1,2,3).forEach {
        Timber.d("$it")
    }

    val p = ::name
    p.set("aaa")

}