package com.coroutine.bod.localkotlin.jetpackdemo.test

/**
 *
 * @ClassName: TestRepository
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-27
 */
class TestRepository {

    fun getData(): String {
        return "Data"
    }

    fun aaa(){
        val a = ::aaa
        a.invoke()
    }

    fun foo() = print("xxx")
}